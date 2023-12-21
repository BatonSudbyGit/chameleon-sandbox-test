package ru.ibs.api.petstore.negative.get.id;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.ibs.api.common.swagger.requests.Requests;
import ru.ibs.api.common.swagger.requests.Specifications;
import ru.ibs.api.petstore.models.pet.PetModel;
import ru.ibs.api.petstore.utils.factory.enums.PetTypeVar;
import ru.ibs.api.petstore.utils.factory.pet.PetFactory;

import java.security.interfaces.RSAKey;

import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static ru.ibs.api.petstore.swagger.instances.endpoints.PetEndpoints.PET;
import static ru.ibs.api.petstore.swagger.instances.endpoints.PetEndpoints.PET_STRICT;
import static ru.ibs.utils.properties.ConfProperties.getProperty;

public class GetByIdNegativeTest {

    private final String BASE_URL = getProperty("petstore.url");
    private final PetModel petModel = PetFactory.createNewPet(PetTypeVar.FULFILLED_PET);

    @BeforeEach
    public void before() {
        RequestSpecification spec = Specifications.requestSpecification(BASE_URL, PET);
        Requests.post(spec);
    }

    @Test
    public void getPetByNotExistingId() {
        RequestSpecification spec = Specifications.requestSpecification(BASE_URL, PET_STRICT + petModel.getId());
        Requests.delete(spec);
        spec = Specifications.requestSpecification(BASE_URL, PET_STRICT + petModel.getId());
        Response response = Requests.get(spec);
        Assertions.assertEquals(SC_NOT_FOUND, response.getStatusCode(), "Not existing pet exists");
    }

    @ParameterizedTest
    @MethodSource("ru.ibs.api.petstore.utils.data.PetData#getIncorrectIdForPets")
    public void getPetByIncorrectId(String id) {
        RequestSpecification spec = Specifications.requestSpecification(BASE_URL, PET_STRICT + id);
        Response response = Requests.get(spec);
        Assertions.assertEquals(SC_NOT_FOUND, response.getStatusCode(), "Incompatible type of id works out");
    }
}

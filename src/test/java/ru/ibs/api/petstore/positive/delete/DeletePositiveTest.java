package ru.ibs.api.petstore.positive.delete;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ibs.api.common.swagger.requests.Requests;
import ru.ibs.api.common.swagger.requests.Specifications;
import ru.ibs.api.petstore.models.pet.PetModel;
import ru.ibs.api.petstore.utils.factory.enums.PetTypeVar;
import ru.ibs.api.petstore.utils.factory.pet.PetFactory;

import static org.apache.http.HttpStatus.SC_OK;
import static ru.ibs.api.petstore.swagger.instances.endpoints.PetEndpoints.PET;
import static ru.ibs.api.petstore.swagger.instances.endpoints.PetEndpoints.PET_STRICT;
import static ru.ibs.utils.properties.ConfProperties.getProperty;

public class DeletePositiveTest {
    private final String BASE_URL = getProperty("petstore.url");
    private final PetModel petModel = PetFactory.createNewPet(PetTypeVar.FULFILLED_PET);

    @BeforeEach
    public void before() {
        RequestSpecification spec = Specifications.requestSpecification(BASE_URL, PET);
        Requests.post(spec, petModel);
    }

    @Test
    public void deletePetById() {
        RequestSpecification spec = Specifications.requestSpecification(BASE_URL, PET_STRICT + petModel.getId());
        Response response = Requests.delete(spec);
        Assertions.assertEquals(SC_OK, response.getStatusCode(), "Couldn't delete existing pet by id");
    }
}

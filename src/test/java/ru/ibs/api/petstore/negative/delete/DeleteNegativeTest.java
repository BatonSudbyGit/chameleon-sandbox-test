package ru.ibs.api.petstore.negative.delete;

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

import static org.apache.http.HttpStatus.SC_METHOD_NOT_ALLOWED;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static ru.ibs.api.petstore.swagger.instances.endpoints.PetEndpoints.PET;
import static ru.ibs.api.petstore.swagger.instances.endpoints.PetEndpoints.PET_STRICT;
import static ru.ibs.utils.properties.ConfProperties.getProperty;

public class DeleteNegativeTest {
    private final String BASE_URL = getProperty("petstore.url");
    private final PetModel petModel = PetFactory.createNewPet(PetTypeVar.FULFILLED_PET);

    @BeforeEach
    public void before() {
        RequestSpecification spec = Specifications.requestSpecification(BASE_URL, PET);
        Requests.post(spec, petModel);
        spec = Specifications.requestSpecification(BASE_URL, PET_STRICT +  petModel.getId());
        Requests.delete(spec);
    }

    @Test
    public void deleteNotExistingPetById() {
        RequestSpecification spec = Specifications.requestSpecification(BASE_URL, PET_STRICT + petModel.getId());
        Response response = Requests.delete(spec);
        Assertions.assertEquals(SC_NOT_FOUND, response.getStatusCode(), "Delete not existing pet has done successfully");
    }

    @Test
    public void sendDeleteRequestWithEmptyQueryTest() {
        RequestSpecification spec = Specifications.requestSpecification(BASE_URL, PET_STRICT);
        Response response = Requests.delete(spec);
        Assertions.assertEquals(SC_METHOD_NOT_ALLOWED, response.getStatusCode(), "Empty query doesn't invoke an error");
    }
}

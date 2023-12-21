package ru.ibs.api.petstore.positive.put;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.ibs.api.common.swagger.requests.Requests;
import ru.ibs.api.common.swagger.requests.Specifications;
import ru.ibs.api.common.swagger.utils.paths.ModelType;
import ru.ibs.api.common.swagger.utils.validator.JsonValidator;
import ru.ibs.api.petstore.models.pet.PetModel;
import ru.ibs.api.petstore.utils.factory.enums.PetTypeVar;
import ru.ibs.api.petstore.utils.factory.pet.PetFactory;

import static org.apache.http.HttpStatus.SC_OK;
import static ru.ibs.api.petstore.swagger.instances.endpoints.PetEndpoints.PET;
import static ru.ibs.utils.properties.ConfProperties.getProperty;

public class PutNewPetRequestsPositiveTest {

    private final String BASE_URL = getProperty("petstore.url");
    @Test
    public void putNewPetInfoPositive() {
        PetModel petModel = PetFactory.createNewPet(PetTypeVar.FULFILLED_PET);
        RequestSpecification spec = Specifications.requestSpecification(BASE_URL, PET);
        Response response = Requests.put(spec, petModel);
        Assertions.assertEquals(SC_OK, response.getStatusCode(), "Setting new info has failed");
        JsonValidator.validateObject(response, ModelType.PET_TEMPLATE_PATH.getModelType());
    }
}

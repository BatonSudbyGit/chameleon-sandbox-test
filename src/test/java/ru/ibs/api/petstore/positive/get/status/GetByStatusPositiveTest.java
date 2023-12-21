package ru.ibs.api.petstore.positive.get.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.ibs.api.common.swagger.requests.Requests;
import ru.ibs.api.common.swagger.requests.Specifications;
import ru.ibs.api.common.swagger.utils.paths.ModelType;
import ru.ibs.api.common.swagger.utils.validator.JsonValidator;
import ru.ibs.api.petstore.models.pet.PetModel;

import java.util.List;

import static org.apache.http.HttpStatus.SC_OK;
import static ru.ibs.api.petstore.swagger.instances.endpoints.PetEndpoints.PETS_BY_STATUS;
import static ru.ibs.utils.properties.ConfProperties.getProperty;

public class GetByStatusPositiveTest {

    private final String BASE_URL = getProperty("petstore.url");
    private final String STATUS = getProperty("pet.status");

    private final RequestSpecification spec = Specifications.requestSpecification(BASE_URL, PETS_BY_STATUS);

    @ParameterizedTest
    @MethodSource("ru.ibs.api.petstore.utils.data.PetData#positiveStatusData")
    public void getPetByStatus(String[] status) {
        Response response = Requests.get(spec.queryParam(STATUS, status[0]));
        Assertions.assertEquals(response.getStatusCode(), SC_OK, "Status code is incorrect");
        JsonValidator.validateList(response, ModelType.PET_LIST_TEMPLATE_PATH.getModelType());
    }

    @ParameterizedTest
    @MethodSource("ru.ibs.api.petstore.utils.data.PetData#positiveStatusData")
    public void responseBodyHasStatusAccordingRequest(String[] status) {
        Response response = Requests.get(spec.queryParam(STATUS, status[0]));
        JsonMapper mapper = new JsonMapper();
        List<PetModel> petModelList;
        try {
            petModelList = mapper.readValue(response.asString(), new TypeReference<List<PetModel>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        for (PetModel pet: petModelList) {
            Assertions.assertEquals(pet.getStatus(), status[0], "This object has incorrect parameters");
        }
    }

}

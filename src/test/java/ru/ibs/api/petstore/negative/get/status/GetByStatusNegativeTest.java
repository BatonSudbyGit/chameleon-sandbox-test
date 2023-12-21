package ru.ibs.api.petstore.negative.get.status;

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
import ru.ibs.api.petstore.models.pet.PetModel;

import java.util.List;

import static ru.ibs.api.petstore.swagger.instances.endpoints.PetEndpoints.PETS_BY_STATUS;
import static ru.ibs.utils.properties.ConfProperties.getProperty;

public class GetByStatusNegativeTest {

    private final String BASE_URL = getProperty("petstore.url");
    private final String STATUS = getProperty("pet.status");

    @ParameterizedTest
    @MethodSource("ru.ibs.api.petstore.utils.data.PetData#getIncorrectPetStatuses")
    public void getPetByIncorrectStatus(String[] status) {
        RequestSpecification spec = Specifications.requestSpecification(BASE_URL, PETS_BY_STATUS);
        Response response = Requests.get(spec.queryParam(STATUS, status[0]));
        JsonMapper mapper = new JsonMapper();
        List<PetModel> petModelList;
        try {
            petModelList = mapper.readValue(response.asString(), new TypeReference<List<PetModel>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(0, petModelList.size(), "Pet statuses list is not empty");
    }
}

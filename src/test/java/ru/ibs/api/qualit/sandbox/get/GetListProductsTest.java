package ru.ibs.api.qualit.sandbox.get;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.ibs.api.common.swagger.requests.Requests;
import ru.ibs.api.common.swagger.requests.Specifications;
import ru.ibs.api.qulit.sandbox.models.food.FoodModel;
import ru.ibs.api.qulit.sandbox.swagger.instances.endpoints.QSEndpoints;

import ru.ibs.api.common.swagger.utils.validator.JsonValidator;
import ru.ibs.basetest.QSBaseTest;

import java.util.List;

import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.ibs.utils.properties.ConfProperties.getProperty;

public class GetListProductsTest extends QSBaseTest {

    @Test
    public void getListProducts() throws JsonProcessingException {
        RequestSpecification spec = Specifications.requestSpecification(getProperty("qualit.url"), QSEndpoints.FOOD);
        Response response = Requests.get(spec);
        JsonMapper mapper = new JsonMapper();
        List<FoodModel> foodModelList = mapper.readValue(response.asString(), new TypeReference<>() {});
        JsonValidator.validateObject(response);
        Assertions.assertAll(
                () -> assertEquals(SC_OK, response.statusCode(), "Status code is incorrect"),
                () -> assertTrue(foodModelList.size() > 0, "the response body is missing"));
    }
}

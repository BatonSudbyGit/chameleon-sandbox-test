package ru.ibs.api.qualit.sandbox.get;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.ibs.api.qulit.sandbox.models.food.FoodModel;
import ru.ibs.api.qulit.sandbox.swagger.instances.endpoints.QSEndpoints;
import ru.ibs.api.qulit.sandbox.swagger.requests.QSRequests;
import ru.ibs.api.qulit.sandbox.swagger.requests.Specifications;
import ru.ibs.api.qulit.sandbox.utils.validator.JsonValidator;
import ru.ibs.basetest.QSBaseTest;
import ru.ibs.utils.properties.ConfProperties;

import java.util.List;

import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetListProductsTest extends QSBaseTest {

    @Test
    public void getListProducts() throws JsonProcessingException {
        RequestSpecification spec = Specifications.requestSpecification(ConfProperties.getProperty("base.url"), QSEndpoints.FOOD);
        Response response = QSRequests.get(spec);
        response.statusCode();
        JsonMapper mapper = new JsonMapper();
        List<FoodModel> foodModelList = mapper.readValue(response.asString(), new TypeReference<>() {});
        JsonValidator.validateObject(response);
        Assertions.assertAll(
                () -> assertEquals(SC_OK, response.statusCode(), "Status code is incorrect"),
                () -> assertTrue(foodModelList.size() > 0, "the response body is missing"));
    }
}

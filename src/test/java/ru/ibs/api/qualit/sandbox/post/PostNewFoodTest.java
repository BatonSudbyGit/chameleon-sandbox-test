package ru.ibs.api.qualit.sandbox.post;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.ibs.api.qulit.sandbox.models.food.FoodModel;
import ru.ibs.api.qulit.sandbox.swagger.instances.endpoints.QSEndpoints;
import ru.ibs.api.qulit.sandbox.swagger.requests.QSRequests;
import ru.ibs.api.qulit.sandbox.swagger.requests.Specifications;
import ru.ibs.api.qulit.sandbox.utils.enums.FoodType;
import ru.ibs.api.qulit.sandbox.utils.food.Food;
import ru.ibs.basetest.QSBaseTest;

import java.util.List;

import static org.apache.http.HttpStatus.SC_OK;
import static ru.ibs.utils.properties.ConfProperties.getProperty;

public class PostNewFoodTest extends QSBaseTest {

    @ParameterizedTest
    @MethodSource("productData")
    public void postNewFood(boolean isExotic, FoodType foodType) {
        Food food = new Food();
        List<FoodModel> foodModelList;
        JsonMapper mapper = new JsonMapper();

        FoodModel foodModel = food.createFood(isExotic, foodType);

        RequestSpecification spec = Specifications.requestSpecification(getProperty("base.url"), QSEndpoints.FOOD);
        Response response = QSRequests.post(spec, foodModel);

        Assertions.assertEquals(response.statusCode(), SC_OK, "Food creation failed");

        response = QSRequests.get(spec);

        try {
             foodModelList = mapper.readValue(response.asString(), new TypeReference<>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(foodModel, foodModelList.get(foodModelList.size() - 1),
                "The last product does not correspond to the added one");
        Assertions.assertEquals(response.statusCode(), SC_OK, "Food creation failed");
    }
}

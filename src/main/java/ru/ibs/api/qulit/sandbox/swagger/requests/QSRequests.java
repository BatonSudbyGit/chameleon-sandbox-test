package ru.ibs.api.qulit.sandbox.swagger.requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ru.ibs.api.qulit.sandbox.models.food.FoodModel;

public class QSRequests {

    public static Response get(RequestSpecification spec) {
        return RestAssured.given()
                .spec(spec)
                .when()
                .get()
                .then()
                .log().all()
                .extract().response();
    }

    public static Response post(RequestSpecification spec, FoodModel foodModel) {
        return RestAssured.given()
                .spec(spec)
                .body(foodModel)
                .when()
                .post()
                .then()
                .log().all()
                .extract().response();
    }

    public static Response post(RequestSpecification spec) {
        return RestAssured.given()
                .spec(spec)
                .when()
                .post()
                .then()
                .log().all()
                .extract().response();
    }


}

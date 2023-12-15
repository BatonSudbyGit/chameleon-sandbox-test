package ru.ibs.api.common.swagger.requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Requests {

    public static Response get(RequestSpecification spec) {
        return RestAssured.given()
                .spec(spec)
                .when()
                .get()
                .then()
                .log().all()
                .extract().response();
    }

    public static Response post(RequestSpecification spec, Object model) {
        return RestAssured.given()
                .spec(spec)
                .body(model)
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

    public static Response put(RequestSpecification spec, Object model) {
        return RestAssured.given()
                .spec(spec)
                .body(model)
                .when()
                .put()
                .then()
                .log().all()
                .extract().response();
    }

    public static Response delete(RequestSpecification spec) {
        return RestAssured.given()
                .spec(spec)
                .when()
                .delete()
                .then()
                .log().all()
                .extract().response();
    }
}

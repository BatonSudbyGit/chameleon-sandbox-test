package ru.ibs.api.qulit.sandbox.swagger.requests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import ru.ibs.api.qulit.sandbox.swagger.instances.endpoints.QSEndpoints;

import java.io.File;

import static ru.ibs.utils.properties.ConfProperties.getProperty;

public class Specifications {

    public static RequestSpecification requestSpecification(String url, String path) {
        return requestSpecification(url, path, ContentType.JSON, ContentType.JSON);
    }

    public static RequestSpecification requestSpecification(String url, String path, ContentType sentType) {
        return requestSpecification(url, path, sentType, ContentType.JSON);
    }

    public static RequestSpecification requestSpecification(String url, String path, String sessionId) {
        return requestSpecification(url, path, ContentType.JSON, ContentType.JSON, sessionId);
    }

    public static RequestSpecification requestSpecification(String url, String path, ContentType sentType,
                                                             ContentType acceptType) {
        return new RequestSpecBuilder()
                .setContentType(sentType)
                .setAccept(acceptType)
                .setBaseUri(url)
                .setBasePath(path)
                .build()
                .log().all();
    }

    public static RequestSpecification requestSpecification(String url, String path, ContentType sentType,
                                                            ContentType acceptType, String sessionId) {
        return new RequestSpecBuilder()
                .setContentType(sentType)
                .setAccept(acceptType)
                .setBaseUri(url)
                .setBasePath(path)
                .setSessionId(sessionId)
                .build()
                .log().all();
    }

    public static RequestSpecification requestSpecification(String url, String path, File file) {
        return new RequestSpecBuilder()
                .addMultiPart("file", file, "multipart/form-data")
                .setAccept(ContentType.JSON)
                .setBaseUri(url)
                .setBasePath(path)
                .setSessionId(getSessionId())
                .build()
                .log().all();
    }

    public static String getSessionId() {
        return RestAssured.given()
                .when()
                .contentType(ContentType.JSON)
                .get(getProperty("base.url") + QSEndpoints.FOOD)
                .then()
                .log().all()
                .extract()
                .cookie("JSESSIONID");
    }
}

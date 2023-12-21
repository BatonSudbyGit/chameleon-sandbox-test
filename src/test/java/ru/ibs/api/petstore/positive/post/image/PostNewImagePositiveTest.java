package ru.ibs.api.petstore.positive.post.image;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.ibs.api.common.swagger.requests.Requests;
import ru.ibs.api.common.swagger.requests.Specifications;
import ru.ibs.api.petstore.models.pet.PetModel;
import ru.ibs.api.petstore.utils.factory.enums.PetTypeVar;
import ru.ibs.api.petstore.utils.factory.pet.PetFactory;

import java.io.File;

import static org.apache.http.HttpStatus.SC_OK;
import static ru.ibs.api.petstore.swagger.instances.endpoints.PetEndpoints.*;
import static ru.ibs.utils.properties.ConfProperties.getProperty;

public class PostNewImagePositiveTest {
    private final PetModel petMode = PetFactory.createNewPet(PetTypeVar.FULFILLED_PET);
    private final String BASE_URL = getProperty("petstore.url");

    @BeforeEach
    public void before() {
        RequestSpecification spec = Specifications.requestSpecification(BASE_URL, PET);
        Requests.post(spec, petMode);
    }

    @ParameterizedTest
    @MethodSource("ru.ibs.api.petstore.utils.data.PetData#getPathsToImages")
    public void postPetImage(String path) {
        RequestSpecification spec = Specifications.requestSpecification(BASE_URL,
                PET_STRICT + petMode.getId() + UPLOAD_IMAGE, new File(path).getAbsolutePath());
        Response response = Requests.post(spec);
        Assertions.assertEquals(SC_OK, response.getStatusCode(), "Image doesn't upload to server");
//        TODO: Подобрать формат файла для отправки
    }
}

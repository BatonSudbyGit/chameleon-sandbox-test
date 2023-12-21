package ru.ibs.api.petstore.negative.post.image;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.ibs.api.common.swagger.requests.Requests;
import ru.ibs.api.common.swagger.requests.Specifications;
import ru.ibs.api.petstore.models.pet.PetModel;
import ru.ibs.api.petstore.utils.factory.enums.PetTypeVar;
import ru.ibs.api.petstore.utils.factory.pet.PetFactory;

import java.io.File;

import static org.apache.http.HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE;
import static ru.ibs.api.petstore.swagger.instances.endpoints.PetEndpoints.*;
import static ru.ibs.utils.properties.ConfProperties.getProperty;

public class PostNewImageNegativeTest {
    private final PetModel petModel = PetFactory.createNewPet(PetTypeVar.FULFILLED_PET);
    private final String BASE_URL = getProperty("petstore.url");

    @BeforeEach
    public void before() {
        RequestSpecification spec = Specifications.requestSpecification(BASE_URL, PET);
        Requests.post(spec, petModel);
    }

    @ParameterizedTest
    @MethodSource("ru.ibs.api.petstore.utils.data.PetData#getPathsToFiles")
    public void postPetImage(String path) {
        RequestSpecification spec = Specifications.requestSpecification(BASE_URL,
                PET_STRICT + petModel.getId() + UPLOAD_IMAGE, new File(path).getAbsolutePath());
        Response response = Requests.post(spec);
        Assertions.assertEquals(SC_UNSUPPORTED_MEDIA_TYPE, response.getStatusCode(),
                "Incompatible type of file has been uploaded");
    }

}

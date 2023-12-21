package ru.ibs.api.petstore.utils.factory.response;

import org.junit.jupiter.api.Assertions;
import ru.ibs.api.petstore.models.response.ResponseModel;
import ru.ibs.api.petstore.utils.factory.enums.ResponseTypes;
import ru.ibs.api.petstore.utils.factory.response.types.InvalidId;
import ru.ibs.api.petstore.utils.factory.response.types.NotAllowed;
import ru.ibs.api.petstore.utils.factory.response.types.NotFound;

public class ResponseFactory {

//    TODO:написать нормальную реализацию фабричного метода
    public static ResponseModel createResponse(ResponseTypes responseTypes) {
        switch (responseTypes) {
            case NOT_FOUND:
                return new NotFound().createResponse();
            case INVALID_ID:
                return new InvalidId().createResponse();
            case NOT_ALLOWED:
                return new NotAllowed().createResponse();
            default:
                Assertions.fail(responseTypes + " is incorrect Response type");
                break;
        }
        throw new RuntimeException(responseTypes + " is incorrect Response type");
    }
}

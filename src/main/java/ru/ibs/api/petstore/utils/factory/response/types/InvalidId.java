package ru.ibs.api.petstore.utils.factory.response.types;

import ru.ibs.api.petstore.models.response.ResponseModel;
import ru.ibs.api.petstore.utils.factory.response.Response;

public class InvalidId implements Response {
    @Override
    public ResponseModel createResponse() {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setCode(400);
        responseModel.setType("Error");
        responseModel.setMessage("Bad Request");
        return responseModel;
    }
}

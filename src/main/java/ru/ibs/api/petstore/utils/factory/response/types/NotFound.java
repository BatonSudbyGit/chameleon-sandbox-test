package ru.ibs.api.petstore.utils.factory.response.types;

import ru.ibs.api.petstore.models.response.ResponseModel;
import ru.ibs.api.petstore.utils.factory.response.Response;

public class NotFound implements Response {
    @Override
    public ResponseModel createResponse() {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setCode(404);
        responseModel.setType("Not found");
        responseModel.setMessage("Pet not found");
        return responseModel;
    }
}

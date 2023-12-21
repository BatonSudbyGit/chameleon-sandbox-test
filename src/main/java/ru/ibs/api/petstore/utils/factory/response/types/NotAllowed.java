package ru.ibs.api.petstore.utils.factory.response.types;

import ru.ibs.api.petstore.models.response.ResponseModel;
import ru.ibs.api.petstore.utils.factory.response.Response;

public class NotAllowed implements Response {
    @Override
    public ResponseModel createResponse() {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setCode(405);
        responseModel.setType("Error");
        responseModel.setMessage("Method Not Allowed");
        return responseModel;
    }
}

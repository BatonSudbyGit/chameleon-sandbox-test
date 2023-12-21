package ru.ibs.api.common.swagger.utils.validator;

import io.restassured.response.Response;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class JsonValidator {

    public static void validateObject(Response response, String modelType) {
        try {
            JSONObject jsonSchema = new JSONObject(new JSONTokener(new FileInputStream(modelType)));
            JSONObject jsonSubject = new JSONObject(new JSONTokener(response.asString()));
            Schema schema = SchemaLoader.load(jsonSchema);
            schema.validate(jsonSubject);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void validateList(Response response, String modelType) {
        try {
            JSONObject jsonSchema = new JSONObject(new JSONTokener(new FileInputStream(modelType)));
            JSONArray jsonSubject = new JSONArray(new JSONTokener(response.asString()));
            Schema schema = SchemaLoader.load(jsonSchema);
            schema.validate(jsonSubject);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

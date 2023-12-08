package ru.ibs.api.qulit.sandbox.utils.validator;

import io.restassured.response.Response;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class JsonValidator {

    public static void validateObject(Response response) {
        try {
            JSONObject jsonSchema = new JSONObject(new JSONTokener(new FileInputStream("src/main/resources/validation_models/food.json")));
            JSONObject jsonSubject = new JSONObject(new JSONTokener(response.asString()));
            Schema schema = SchemaLoader.load(jsonSchema);
            schema.validate(jsonSubject);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

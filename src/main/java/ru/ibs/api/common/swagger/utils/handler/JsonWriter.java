package ru.ibs.api.common.swagger.utils.handler;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter {

    public void writeJsonFile(Object object, String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String convertedObj = mapper.writeValueAsString(object);
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(convertedObj);
        fileWriter.flush();
    }
}

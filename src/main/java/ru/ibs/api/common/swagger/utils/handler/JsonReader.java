package ru.ibs.api.common.swagger.utils.handler;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonReader {

    public <T> T readJsonFile(String path, Class<T> className) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(path), className);
    }
}

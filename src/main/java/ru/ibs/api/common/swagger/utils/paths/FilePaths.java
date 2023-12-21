package ru.ibs.api.common.swagger.utils.paths;

import ru.ibs.utils.properties.ConfProperties;

public enum FilePaths {
    TEXT_FILE_PATH(ConfProperties.getProperty("text.file.path")),
    DOC_FILE_PATH(ConfProperties.getProperty("doc.file.path")),
    HTML_FILE_PATH(ConfProperties.getProperty("html.file.path")),
    IMAGE_FILE_PATH(ConfProperties.getProperty("image.file.path"));

    private final String path;

    FilePaths(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}

package ru.ibs.api.common.swagger.utils.paths;

import ru.ibs.utils.properties.ConfProperties;

public enum ModelType {
    FOOD_TEMPLATE_PATH(ConfProperties.getProperty("food.template.path")),
    PET_TEMPLATE_PATH(ConfProperties.getProperty("pet.template.path")),
    PET_LIST_TEMPLATE_PATH(ConfProperties.getProperty("petlist.template.path")),
    PET_RESPONSE_TEMPLATE_PATH(ConfProperties.getProperty("response.template.path"));

    private String modelType;

    ModelType(String modelType){
        this.modelType = modelType;
    }

    public String getModelType() {
        return this.modelType;
    }
}

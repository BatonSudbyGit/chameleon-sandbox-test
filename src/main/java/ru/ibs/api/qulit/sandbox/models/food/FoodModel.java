package ru.ibs.api.qulit.sandbox.models.food;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"name", "type", "exotic"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FoodModel {
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("exotic")
    private Boolean exotic;

    public FoodModel() {
    }

    public FoodModel(String name, String type, Boolean exotic) {
        this.name = name;
        this.type = type;
        this.exotic = exotic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getExotic() {
        return exotic;
    }

    public void setExotic(Boolean exotic) {
        this.exotic = exotic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodModel foodModel = (FoodModel) o;
        return Objects.equals(name, foodModel.name) && Objects.equals(type, foodModel.type) && Objects.equals(exotic, foodModel.exotic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, exotic);
    }
}

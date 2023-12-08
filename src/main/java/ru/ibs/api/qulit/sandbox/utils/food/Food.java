package ru.ibs.api.qulit.sandbox.utils.food;

import ru.ibs.api.qulit.sandbox.models.food.FoodModel;
import ru.ibs.api.qulit.sandbox.utils.enums.FoodType;
import ru.ibs.api.qulit.sandbox.utils.generator.FoodNameGenerator;

public class Food implements FoodImpl {
    @Override
    public FoodModel createFood(boolean isExotic, FoodType foodType) {
        FoodModel food = new FoodModel();
        food.setName(FoodNameGenerator.getName(foodType, isExotic));
        food.setType(String.valueOf(foodType));
        food.setExotic(isExotic);
        return food;
    }
}

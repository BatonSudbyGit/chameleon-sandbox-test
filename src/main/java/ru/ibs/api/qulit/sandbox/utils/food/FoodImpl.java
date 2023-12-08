package ru.ibs.api.qulit.sandbox.utils.food;

import ru.ibs.api.qulit.sandbox.models.food.FoodModel;
import ru.ibs.api.qulit.sandbox.utils.enums.FoodType;

public interface FoodImpl {
    FoodModel createFood(boolean isExotic, FoodType foodType);
}

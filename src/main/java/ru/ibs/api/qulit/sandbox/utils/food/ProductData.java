package ru.ibs.api.qulit.sandbox.utils.food;

import ru.ibs.api.qulit.sandbox.utils.enums.FoodType;
import ru.ibs.basetest.QSBaseTest;

public class ProductData extends QSBaseTest {

    public static Object[][] productData() {
        return new Object[][]{
                {true, FoodType.FRUIT},
                {false, FoodType.FRUIT},
                {true, FoodType.VEGETABLE},
                {false, FoodType.VEGETABLE},
        };
    }
}

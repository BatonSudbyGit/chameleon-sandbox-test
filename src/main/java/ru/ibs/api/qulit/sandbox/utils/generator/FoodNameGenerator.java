package ru.ibs.api.qulit.sandbox.utils.generator;

import org.junit.jupiter.api.Assertions;
import ru.ibs.api.qulit.sandbox.utils.enums.FoodType;

import java.util.Random;

import static ru.ibs.api.qulit.sandbox.utils.constants.FoodName.*;

public class FoodNameGenerator {

    public static String getName(FoodType foodType, boolean isExotic) {
        String name = "unknown fruit";
        switch (foodType) {
            case FRUIT:
                if (isExotic) name = getName(EXOTIC_FRUIT);
                else name = getName(FRUIT);
                break;
            case VEGETABLE:
                if (isExotic) name = getName(EXOTIC_VEGETABLE);
                else name = getName(VEGETABLE);
                break;
            default:
                Assertions.fail(foodType + " is unknown");
                break;
        }
        return name;
    }

    public static String getName(String[] arrayNames) {
        String name = arrayNames[new Random().nextInt(arrayNames.length) + 1];
        System.out.println(name);
        return name;
    }
}

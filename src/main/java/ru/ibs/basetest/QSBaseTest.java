package ru.ibs.basetest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ru.ibs.api.qulit.sandbox.utils.enums.FoodType;
import ru.ibs.utils.QSInitialization;
import ru.ibs.utils.logger.Log;

import static java.lang.Thread.sleep;

public class QSBaseTest {

    @BeforeAll
    public static void init() {
        Log.info("Инициализация");
        QSInitialization.startQSApplication();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterAll
    public static void destroyProcess() {
        Log.info("Начало метода afterAll");
        QSInitialization.destroyAllProcesses();
        QSInitialization.stopQSApplication();
        QSInitialization.stopQSThread();
        Log.info("Выход из метода AfterAll");
    }

    public static Object[][] productData() {
        return new Object[][]{
                {true, FoodType.FRUIT},
                {false, FoodType.FRUIT},
                {true, FoodType.VEGETABLE},
                {false, FoodType.VEGETABLE},
        };
    }
}

package ru.ibs.api;

import org.junit.jupiter.api.Test;
import ru.ibs.basetest.QSBaseTest;
import ru.ibs.utils.logger.Log;

import static ru.ibs.api.qulit.sandbox.utils.generator.FoodNameGenerator.getName;

public class RunTest {

    @Test
    public void test() {
        Log.info("в начале теста");
        try {
            String[] vegetables = {"Тыква",  "Лук","Свекла", "Кабачок"};
            Thread.sleep(5000);
//            Utils.getQSPid();
//            Thread.sleep(10000);
            getName(vegetables);
            Log.info("В теле теста, после слипа");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Log.info("Тест завершен");
    }


}

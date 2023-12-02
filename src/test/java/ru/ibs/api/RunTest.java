package ru.ibs.api;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.ibs.basetest.QualitSandboxBaseTest;
import ru.ibs.utils.Utils;

public class RunTest extends QualitSandboxBaseTest {
    Logger LOG = LoggerFactory.getLogger("");

    @Test
    public void test() {
        LOG.info("в начале теста");
        try {
            Thread.sleep(5000);
            Utils.getQSPid();
            Thread.sleep(10000);
            LOG.info("В теле теста, после слипа");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LOG.info("Тест завершен");
    }
}

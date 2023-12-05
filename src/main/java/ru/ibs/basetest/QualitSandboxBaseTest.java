package ru.ibs.basetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ru.ibs.utils.QualitSandboxInitialization;

public class QualitSandboxBaseTest {
    private static final Logger LOG = LogManager.getLogger(QualitSandboxBaseTest.class);

    @BeforeAll
    public static void init() {
        LOG.info("Инициализация");
        QualitSandboxInitialization.startQSApplication();
    }

    @AfterAll
    public static void destroyProcess() {
        LOG.info("Начало метода afterAll");
        QualitSandboxInitialization.destroyAllProcesses();
        QualitSandboxInitialization.stopQSApplication();
        QualitSandboxInitialization.stopQSThread();
        LOG.info("Выход из метода AfterAll");
    }
}

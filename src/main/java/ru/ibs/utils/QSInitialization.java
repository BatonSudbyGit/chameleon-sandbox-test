package ru.ibs.utils;

import ru.ibs.utils.cmd.CmdCommandRunner;
import ru.ibs.utils.enums.DataWarehousing;
import ru.ibs.utils.logger.Log;
import ru.ibs.utils.properties.ConfProperties;

import java.io.File;

import static ru.ibs.utils.cmd.CmdCommandRunner.isWindows;

/**
 * QS - qualit-sandbox
 */
public class QSInitialization {

    private static Thread thread;

    /**
     * Метод для запуска qualit-sandbox в отдельном потоке
     */
    public static void startQSApplication() {
        String qsPath = ConfProperties.getProperty("qualit.sandbox.path");
        String command = "cd " + System.getProperty("user.dir") + File.separator + qsPath + " ; java -jar qualit-sandbox.jar";
        thread = new Thread(() -> {
            CmdCommandRunner.runCommand(command);
            Log.info("Запустили qualit.sandbox в отдельном потоке");
        });
        thread.start();
    }

    /**
     * Метод для завершения процесса qualit-sandbox
     */
    public static void stopQSApplication() {
        String command;
        if (isWindows()) {
            command = "";
//            TODO:Написать реализацию для windows
        } else {
            command = "kill -s kill " + Utils.getQSPid();
        }
        CmdCommandRunner.runCommand(command);
    }

    /**
     * Метод для завершения потока, в котором запущен qualit-sandbox.jar
     */
    public static void stopQSThread() {
        try {
            thread.interrupt();
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Log.info("Остановили поток, в котором запущен qualit-sandbox.jar");
    }

    /**
     * Метод для завершения всех процессов, созданных методом runProcess.
     * Используется для корректной работы с qualit-sandbox.jar
     */
    public static void destroyAllProcesses() {
        for (Process process: DataWarehousing.INSTANCE.getProcessesList()) {
            process.destroy();
        }
        Log.info("Завершили все процессы");
    }
}

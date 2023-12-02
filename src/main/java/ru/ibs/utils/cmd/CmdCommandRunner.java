package ru.ibs.utils.cmd;

import org.junit.jupiter.api.condition.OS;
import ru.ibs.utils.enums.DataWarehousing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CmdCommandRunner {

    /**
     * Метод для получения названия операционной системы
     *
     * @return возвращает название операционной системы
     */
    public static String getOsName() {
        return OS.current().toString();
    }

    public static boolean isWindows() {
        return getOsName().contains("WINDOWS");
    }

    /**
     * Метод для запуска команды через CMD
     */
    public static List<String> runCommand(String command) {
        List<String> response = new ArrayList<>();
        System.out.println(command);
        ProcessBuilder builder;
        if (isWindows()) {
            builder = new ProcessBuilder("cmd.exe", "/c", command);
        } else {
            builder = new ProcessBuilder("/bin/bash", "-c", command);
        }
        try {
            Process process = builder.start();
            DataWarehousing.INSTANCE.getProcessesList().add(process);
            String charset = "Windows-1251";
            BufferedReader stdout = new BufferedReader(new InputStreamReader(process.getInputStream(), charset));
            String line;
            while ((line = stdout.readLine()) != null && !Thread.interrupted()) {
                response.add(line);
                System.out.println(line);
            }
            stdout.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }
}

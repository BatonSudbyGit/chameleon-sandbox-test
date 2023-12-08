package ru.ibs.utils;


import ru.ibs.utils.cmd.CmdCommandRunner;
import ru.ibs.utils.logger.Log;

import java.util.List;

import static ru.ibs.utils.cmd.CmdCommandRunner.isWindows;

public class Utils {

    public static String getQSPid() {
        String command;
        List<String> resultList;
        String qsPID;
        if (isWindows()) {
            qsPID = "нет команды для windows";
//            TODO:Написать реализацию для windows
        } else {
            command = "lsof -t -i:8080";
            resultList = CmdCommandRunner.runCommand(command);
            qsPID = resultList.get(resultList.size() - 1);
        }
        Log.info("Получили PID процесса qualit-sandbox: " + qsPID);
        return qsPID;
    }
}

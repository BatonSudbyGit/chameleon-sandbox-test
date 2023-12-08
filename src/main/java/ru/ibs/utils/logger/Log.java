package ru.ibs.utils.logger;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    private static final Logger LOG = LogManager.getLogger(Log.class);

    public static void info(String massage) {
        LOG.info(massage);
    }
}

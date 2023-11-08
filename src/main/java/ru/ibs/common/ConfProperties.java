package ru.ibs.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {

    private static FileInputStream fileInputStream;
    private static Properties props;

    static {
        try {
            fileInputStream = new FileInputStream("src/main/resources/properties/environment.properties");
            props = new Properties();
            props.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getProperty(String key) {
        return props.getProperty(key);
    }

    public static Object setProperty(String key, String value) {
        return props.setProperty(key, value);
    }
}

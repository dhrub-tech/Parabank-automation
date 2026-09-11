package com.parabank.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input != null) {
                properties.load(input);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null && key.equals("base.url")) {
            value = properties.getProperty("baseUrl");
        }
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Property key '" + key + "' not found or empty in config.properties");
        }
        return value;
    }

    public static String get(String key) {
        return getProperty(key);
    }

    public static int getInt(String key) {
        return Integer.parseInt(getProperty(key).trim());
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(getProperty(key).trim());
    }
}
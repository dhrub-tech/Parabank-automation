package com.parabank.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {

    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IllegalStateException("config.properties file not found in resources directory");
            }
            PROPERTIES.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Unable to load configuration properties", e);
        }
    }

    private ConfigReader() {}

    public static String getProperty(String key) {
        String value = PROPERTIES.getProperty(key);
        if (value == null || value.isBlank()) {
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
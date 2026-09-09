package com.parabank.tests;

import com.parabank.utils.ConfigReader;
import org.testng.annotations.Test;

public class ConfigReaderTest {

    @Test
    public void verifyConfiguration() {

        System.out.println("URL: "
                + ConfigReader.get("base.url"));

        System.out.println("Browser: "
                + ConfigReader.get("browser"));

        System.out.println("Timeout: "
                + ConfigReader.getInt("timeout"));

        System.out.println("Headless: "
                + ConfigReader.getBoolean("headless"));
    }
}
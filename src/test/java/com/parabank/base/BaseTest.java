package com.parabank.base;

import com.parabank.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Fetch browser parameter from config, default to chrome if not specified
        String browser = ConfigReader.getProperty("browser");
        
        // Instantiate driver via factory
        driver = DriverFactory.createDriver(browser != null ? browser : "chrome");
        
        // Configure browser window and timeouts
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Navigate to the base URL configured in config.properties
        driver.get(ConfigReader.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        // Cleanly close the session and clear ThreadLocal instance
        DriverFactory.quitDriver();
    }
}
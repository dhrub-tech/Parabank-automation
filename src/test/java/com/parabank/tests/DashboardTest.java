package com.parabank.tests;

import com.parabank.base.BaseTest;
import com.parabank.pages.DashboardPage;
import com.parabank.pages.LoginPage;
import com.parabank.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class DashboardTest extends BaseTest {

    @Test
    public void verifyDashboardAfterLogin() {
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);

        String username = "qa_user_" + UUID.randomUUID().toString().substring(0, 8);

        loginPage.clickRegister();
        registerPage.registerNewUser("QA", "Tester", username, "Password123");

        Assert.assertTrue(dashboardPage.isWelcomeHeaderDisplayed(), "Dashboard elements not visible after login.");
    }
}
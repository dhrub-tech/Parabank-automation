package com.parabank.tests;

import com.parabank.base.BaseTest;
import com.parabank.pages.DashboardPage;
import com.parabank.pages.LoginPage;
import com.parabank.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class SmokeTest extends BaseTest {

    @Test(priority = 1)
    public void verifyUserRegistrationAndLoginFlow() {
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);

        // Generate a completely unique username for every run
        String uniqueUsername = "qa_user_" + UUID.randomUUID().toString().substring(0, 8);
        String password = "Password123";

        // Step 1: Register User
        loginPage.clickRegister();
        registerPage.registerNewUser("QA", "Tester", uniqueUsername, password);
        Assert.assertTrue(dashboardPage.isOverviewDisplayed(), "Account Overview missing after registration.");

        // Step 2: Logout
        dashboardPage.logout();

        // Step 3: Login with newly created user
        loginPage.login(uniqueUsername, password);
        Assert.assertTrue(dashboardPage.isOverviewDisplayed(), "Account Overview missing after login.");

        // Step 4: Logout
        dashboardPage.logout();
    }
}
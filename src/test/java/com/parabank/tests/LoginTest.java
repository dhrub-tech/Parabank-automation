package com.parabank.tests;

import com.parabank.base.BaseTest;
import com.parabank.pages.DashboardPage;
import com.parabank.pages.LoginPage;
import com.parabank.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class LoginTest extends BaseTest {

    @Test
    public void verifyUserLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);

        String username = "qa_user_" + UUID.randomUUID().toString().substring(0, 8);
        String password = "Password123";

        // Step 1: Register user (ParaBank auto-logs in here)
        loginPage.clickRegister();
        registerPage.registerNewUser("QA", "Tester", username, password);

        // Step 2: Log out to expose the login form
        dashboardPage.logout();

        // Step 3: Test the actual login function
        loginPage.login(username, password);

        // Step 4: Verify success by asserting the dashboard is visible
        Assert.assertTrue(dashboardPage.isWelcomeHeaderDisplayed(), "Login failed: Welcome header missing.");
    }
}
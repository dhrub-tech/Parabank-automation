package com.parabank.tests;

import com.parabank.base.BaseTest;
import com.parabank.pages.LoginPage;
import com.parabank.pages.OpenAccountPage;
import com.parabank.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class OpenAccountTest extends BaseTest {

    @Test
    public void verifyOpenNewSavingsAccount() {
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        OpenAccountPage openAccountPage = new OpenAccountPage(driver);

        String username = "qa_user_" + UUID.randomUUID().toString().substring(0, 8);

        loginPage.clickRegister();
        registerPage.registerNewUser("QA", "Tester", username, "Password123");

        openAccountPage.clickOpenNewAccountMenu();
        openAccountPage.openAccount("SAVINGS");

        String newAccountId = openAccountPage.getNewAccountId();
        Assert.assertFalse(newAccountId.isEmpty(), "New account creation failed; account ID is empty.");
    }
}
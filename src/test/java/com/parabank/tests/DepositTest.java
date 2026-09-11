package com.parabank.tests;

import com.parabank.base.BaseTest;
import com.parabank.pages.DepositPage;
import com.parabank.pages.LoginPage;
import com.parabank.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class DepositTest extends BaseTest {

    @Test
    public void verifyDepositFunds() {
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        DepositPage depositPage = new DepositPage(driver);

        String username = "qa_user_" + UUID.randomUUID().toString().substring(0, 8);

        loginPage.clickRegister();
        registerPage.registerNewUser("QA", "Tester", username, "Password123");

        depositPage.depositFunds("500.00");
        Assert.assertTrue(depositPage.isDepositSuccessful(), "Deposit failed.");
    }
}
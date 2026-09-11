package com.parabank.tests;

import com.parabank.base.BaseTest;
import com.parabank.pages.LoginPage;
import com.parabank.pages.RegisterPage;
import com.parabank.pages.TransferFundsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class TransferFundsTest extends BaseTest {

    @Test
    public void verifyTransferBetweenAccounts() {
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        TransferFundsPage transferPage = new TransferFundsPage(driver);

        String username = "qa_user_" + UUID.randomUUID().toString().substring(0, 8);

        loginPage.clickRegister();
        registerPage.registerNewUser("QA", "Tester", username, "Password123");

        transferPage.transferFunds("150.00");
        Assert.assertTrue(transferPage.isTransferSuccessful(), "Fund transfer failed.");
    }
}
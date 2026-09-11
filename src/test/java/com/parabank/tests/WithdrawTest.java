package com.parabank.tests;

import com.parabank.base.BaseTest;
import com.parabank.pages.LoginPage;
import com.parabank.pages.RegisterPage;
import com.parabank.pages.WithdrawPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class WithdrawTest extends BaseTest {

    @Test
    public void verifyWithdrawalFunds() {
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        WithdrawPage withdrawPage = new WithdrawPage(driver);

        String username = "qa_user_" + UUID.randomUUID().toString().substring(0, 8);

        loginPage.clickRegister();
        registerPage.registerNewUser("QA", "Tester", username, "Password123");

        withdrawPage.withdrawFunds("100.00");
        Assert.assertTrue(withdrawPage.isWithdrawalSuccessful(), "Withdrawal failed.");
    }
}
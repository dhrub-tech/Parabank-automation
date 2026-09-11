package com.parabank.tests;

import com.parabank.base.BaseTest;
import com.parabank.pages.FindTransactionsPage;
import com.parabank.pages.LoginPage;
import com.parabank.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class FindTransactionsTest extends BaseTest {

    @Test
    public void verifySearchTransactionByAmount() {
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        FindTransactionsPage findPage = new FindTransactionsPage(driver);

        String username = "qa_user_" + UUID.randomUUID().toString().substring(0, 8);

        loginPage.clickRegister();
        registerPage.registerNewUser("QA", "Tester", username, "Password123");

        findPage.findTransactionByAmount("100");
        Assert.assertTrue(findPage.isResultsTableDisplayed(), "Transaction search table missing.");
    }
}
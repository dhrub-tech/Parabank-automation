package com.parabank.tests;

import com.parabank.base.BaseTest;
import com.parabank.pages.AccountsOverviewPage;
import com.parabank.pages.LoginPage;
import com.parabank.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class AccountsOverviewTest extends BaseTest {

    @Test
    public void verifyAccountsOverviewTable() {
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        AccountsOverviewPage overviewPage = new AccountsOverviewPage(driver);

        String username = "qa_user_" + UUID.randomUUID().toString().substring(0, 8);

        loginPage.clickRegister();
        registerPage.registerNewUser("QA", "Tester", username, "Password123");

        overviewPage.navigateToAccountsOverview();
        Assert.assertTrue(overviewPage.isOverviewTableDisplayed(), "Accounts Overview table not displayed.");
    }
}
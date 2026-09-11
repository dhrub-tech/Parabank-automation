package com.parabank.tests;

import com.parabank.base.BaseTest;
import com.parabank.pages.BillPayPage;
import com.parabank.pages.LoginPage;
import com.parabank.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class BillPayTest extends BaseTest {

    @Test
    public void verifyBillPaymentToPayee() {
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        BillPayPage billPayPage = new BillPayPage(driver);

        String username = "qa_user_" + UUID.randomUUID().toString().substring(0, 8);

        loginPage.clickRegister();
        registerPage.registerNewUser("QA", "Tester", username, "Password123");

        billPayPage.payBill("Electric Company", "75.50", "12345");
        Assert.assertTrue(billPayPage.isPaymentSuccessful(), "Bill payment failed.");
    }
}
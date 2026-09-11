package com.parabank.tests;

import com.parabank.base.BaseTest;
import com.parabank.pages.LoginPage;
import com.parabank.pages.RegisterPage;
import com.parabank.pages.UpdateProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class UpdateProfileTest extends BaseTest {

    @Test
    public void verifyUpdateUserProfileInfo() {
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        UpdateProfilePage profilePage = new UpdateProfilePage(driver);

        String username = "qa_user_" + UUID.randomUUID().toString().substring(0, 8);

        loginPage.clickRegister();
        registerPage.registerNewUser("QA", "Tester", username, "Password123");

        profilePage.updateFirstName("UpdatedName");
        Assert.assertTrue(profilePage.isProfileUpdateSuccessful(), "Profile update failed.");
    }
}
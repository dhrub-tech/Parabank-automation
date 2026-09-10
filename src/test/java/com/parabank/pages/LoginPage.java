package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By txtUsername = By.name("username");
    private By txtPassword = By.name("password");
    private By btnLogin = By.xpath("//input[@value='Log In']");
    private By linkRegister = By.xpath("//a[text()='Register']");
    private By txtError = By.cssSelector("p.error");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        type(txtUsername, username);
        type(txtPassword, password);
        click(btnLogin);
    }

    public void clickRegister() {
        click(linkRegister);
    }

    public String getErrorMessage() {
        return getText(txtError);
    }
}
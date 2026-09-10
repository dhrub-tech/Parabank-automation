package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    private By txtFirstName = By.id("customer.firstName");
    private By txtLastName = By.id("customer.lastName");
    private By txtAddress = By.id("customer.address.street");
    private By txtCity = By.id("customer.address.city");
    private By txtState = By.id("customer.address.state");
    private By txtZipCode = By.id("customer.address.zipCode");
    private By txtPhone = By.id("customer.phoneNumber");
    private By txtSsn = By.id("customer.ssn");
    private By txtUsername = By.id("customer.username");
    private By txtPassword = By.id("customer.password");
    private By txtConfirmPassword = By.id("repeatedPassword");
    private By btnRegister = By.xpath("//input[@value='Register']");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void registerNewUser(String fName, String lName, String username, String password) {
        type(txtFirstName, fName);
        type(txtLastName, lName);
        type(txtAddress, "123 Main St");
        type(txtCity, "Kolkata");
        type(txtState, "WB");
        type(txtZipCode, "700001");
        type(txtPhone, "9876543210");
        type(txtSsn, "123-45-6789");
        type(txtUsername, username);
        type(txtPassword, password);
        type(txtConfirmPassword, password);
        click(btnRegister);
    }
}
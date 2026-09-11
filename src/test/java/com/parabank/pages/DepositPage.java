package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DepositPage extends BasePage {

    private By linkDeposit = By.xpath("//a[text()='Deposit']");
    private By txtAmount = By.id("amount");
    private By btnSubmit = By.xpath("//input[@value='Deposit']");
    private By txtSuccess = By.xpath("//h1[text()='Deposit Complete']");

    public DepositPage(WebDriver driver) {
        super(driver);
    }

    public void depositFunds(String amount) {
        click(linkDeposit);
        type(txtAmount, amount);
        click(btnSubmit);
    }

    public boolean isDepositSuccessful() {
        return isDisplayed(txtSuccess);
    }
}
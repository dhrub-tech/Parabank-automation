package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WithdrawPage extends BasePage {

    private By linkWithdraw = By.xpath("//a[text()='Withdrawal']");
    private By txtAmount = By.id("amount");
    private By btnSubmit = By.xpath("//input[@value='Withdraw']");
    private By txtSuccess = By.xpath("//h1[text()='Withdrawal Complete']");

    public WithdrawPage(WebDriver driver) {
        super(driver);
    }

    public void withdrawFunds(String amount) {
        click(linkWithdraw);
        type(txtAmount, amount);
        click(btnSubmit);
    }

    public boolean isWithdrawalSuccessful() {
        return isDisplayed(txtSuccess);
    }
}
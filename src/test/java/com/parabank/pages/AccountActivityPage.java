package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountActivityPage extends BasePage {

    private By txtAccountDetailsHeader = By.xpath("//h1[text()='Account Details']");
    private By tableTransactions = By.id("transactionTable");

    public AccountActivityPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountDetailsDisplayed() {
        return isDisplayed(txtAccountDetailsHeader);
    }

    public boolean isTransactionTableDisplayed() {
        return isDisplayed(tableTransactions);
    }
}
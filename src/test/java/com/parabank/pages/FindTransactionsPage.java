package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindTransactionsPage extends BasePage {

    private By linkFindTransactions = By.xpath("//a[text()='Find Transactions']");
    private By txtAmount = By.id("criteria.amount");
    private By btnFindByAmount = By.xpath("//button[@id='findByAmount']");
    private By tableResults = By.id("transactionTable");

    public FindTransactionsPage(WebDriver driver) {
        super(driver);
    }

    public void findTransactionByAmount(String amount) {
        click(linkFindTransactions);
        type(txtAmount, amount);
        click(btnFindByAmount);
    }

    public boolean isResultsTableDisplayed() {
        return isDisplayed(tableResults);
    }
}
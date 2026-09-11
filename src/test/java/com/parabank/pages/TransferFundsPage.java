package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransferFundsPage extends BasePage {

    private By linkTransfer = By.xpath("//a[text()='Transfer Funds']");
    private By txtAmount = By.id("amount");
    private By btnTransfer = By.xpath("//input[@value='Transfer']");
    private By txtSuccessHeader = By.xpath("//h1[text()='Transfer Complete!']");

    public TransferFundsPage(WebDriver driver) {
        super(driver);
    }

    public void transferFunds(String amount) {
        click(linkTransfer);
        type(txtAmount, amount);
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        click(btnTransfer);
    }

    public boolean isTransferSuccessful() {
        return isDisplayed(txtSuccessHeader);
    }
}
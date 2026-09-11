package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsOverviewPage extends BasePage {

    private By linkAccountsOverview = By.xpath("//a[text()='Accounts Overview']");
    private By tableAccountOverview = By.id("accountTable");
    private By linkFirstAccount = By.xpath("//table[@id='accountTable']//tbody/tr[1]/td[1]/a");

    public AccountsOverviewPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToAccountsOverview() {
        click(linkAccountsOverview);
    }

    public boolean isOverviewTableDisplayed() {
        return isDisplayed(tableAccountOverview);
    }

    public void clickFirstAccount() {
        click(linkFirstAccount);
    }
}
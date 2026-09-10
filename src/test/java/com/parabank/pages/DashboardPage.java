package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    private By linkLogout = By.xpath("//a[text()='Log Out']");
    private By txtAccountOverviewHeader = By.xpath("//h1[text()='Accounts Overview']");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOverviewDisplayed() {
        return isDisplayed(txtAccountOverviewHeader);
    }

    public void logout() {
        click(linkLogout);
    }
}
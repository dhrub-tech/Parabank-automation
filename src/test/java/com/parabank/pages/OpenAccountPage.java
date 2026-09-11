package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class OpenAccountPage extends BasePage {

    private By linkOpenAccount = By.xpath("//a[text()='Open New Account']");
    private By selectAccountType = By.id("type");
    private By btnOpenAccount = By.xpath("//input[@value='Open New Account']");
    private By txtNewAccountId = By.id("newAccountId");

    public OpenAccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickOpenNewAccountMenu() {
        click(linkOpenAccount);
    }

    public void openAccount(String accountType) {
        Select typeSelect = new Select(wait.until(d -> driver.findElement(selectAccountType)));
        typeSelect.selectByVisibleText(accountType);
        
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        
        click(btnOpenAccount);
    }

    public String getNewAccountId() {
        return getText(txtNewAccountId);
    }
}
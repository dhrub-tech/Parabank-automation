package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UpdateProfilePage extends BasePage {

    private By linkUpdateProfile = By.xpath("//a[text()='Update Contact Info']");
    private By txtFirstName = By.id("customer.firstName");
    private By txtLastName = By.id("customer.lastName");
    private By btnUpdateProfile = By.xpath("//input[@value='Update Profile']");
    private By txtSuccess = By.xpath("//h1[text()='Profile Updated']");

    public UpdateProfilePage(WebDriver driver) {
        super(driver);
    }

    public void updateFirstName(String newFirstName) {
        click(linkUpdateProfile);
        
        // Wait for Angular to populate existing customer data
        WebElement lastNameElement = wait.until(ExpectedConditions.presenceOfElementLocated(txtLastName));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(lastNameElement, "value"));
        
        // Clear and update first name
        WebElement firstNameInput = wait.until(ExpectedConditions.elementToBeClickable(txtFirstName));
        firstNameInput.clear();
        firstNameInput.sendKeys(newFirstName);

        // Click the update button natively
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(btnUpdateProfile));
        button.click();
    }

    public boolean isProfileUpdateSuccessful() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(txtSuccess));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
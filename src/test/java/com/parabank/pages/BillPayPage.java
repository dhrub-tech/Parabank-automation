package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BillPayPage extends BasePage {

    private By linkBillPay = By.xpath("//a[text()='Bill Pay']");
    private By txtPayeeName = By.name("payee.name");
    private By txtAddress = By.name("payee.address.street");
    private By txtCity = By.name("payee.address.city");
    private By txtState = By.name("payee.address.state");
    private By txtZipCode = By.name("payee.address.zipCode");
    private By txtPhone = By.name("payee.phoneNumber");
    private By txtAccount = By.name("payee.accountNumber");
    private By txtVerifyAccount = By.name("verifyAccount");
    private By txtAmount = By.name("amount");
    private By btnSendPayment = By.xpath("//input[@value='Send Payment']");
    private By txtSuccessHeader = By.xpath("//h1[text()='Bill Payment Complete']");

    public BillPayPage(WebDriver driver) {
        super(driver);
    }

    public void payBill(String payee, String amount, String accountNum) {
        click(linkBillPay);
        type(txtPayeeName, payee);
        type(txtAddress, "456 Commercial St");
        type(txtCity, "Kolkata");
        type(txtState, "WB");
        type(txtZipCode, "700002");
        type(txtPhone, "9876543211");
        type(txtAccount, accountNum);
        type(txtVerifyAccount, accountNum);
        type(txtAmount, amount);
        click(btnSendPayment);
    }

    public boolean isPaymentSuccessful() {
        return isDisplayed(txtSuccessHeader);
    }
}
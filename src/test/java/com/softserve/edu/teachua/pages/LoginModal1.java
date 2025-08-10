package com.softserve.edu.teachua.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginModal1 {

    private WebDriver driver;
    //
    private WebElement emailInput;
    //private WebElement emailFeedbackIcon; // TODO
    private WebElement passwordInput;
    //private WebElement passwordFeedbackIcon; // TODO
    private WebElement signInButton;

    // TODO pop-up message

    public LoginModal1(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        emailInput = driver.findElement(By.id("basic_email"));
        passwordInput = driver.findElement(By.id("basic_password"));
        signInButton = driver.findElement(By.cssSelector("div.login-footer button"));
    }

    // Page Object

    // emailInput
    public WebElement getEmailInput() {
        return emailInput;
    }

    public String getEmailInputText() {
        return getEmailInput().getAttribute(TopPart.TAG_ATTRIBUTE_VALUE);
    }

    public void clearEmailInput() {
        getEmailInput().clear();
    }

    public void clickEmailInput() {
        getEmailInput().click();
    }

    public void setEmailInput(String email) {
        getEmailInput().sendKeys(email);
    }

    // passwordInput
    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public String getPasswordInputText() {
        return getPasswordInput().getAttribute(TopPart.TAG_ATTRIBUTE_VALUE);
    }

    public void clearPasswordInput() {
        getPasswordInput().clear();
    }

    public void clickPasswordInput() {
        getPasswordInput().click();
    }

    public void setPasswordInput(String password) {
        getPasswordInput().sendKeys(password);
    }

    // signInButton
    public WebElement getSignInButton() {
        return signInButton;
    }

    public String getSignInButtonText() {
        return getSignInButton().getAttribute(TopPart.TAG_ATTRIBUTE_VALUE);
    }

    public void clickSignInButton() {
        getSignInButton().click();
    }

    // Functional

    private void enterEmailInput(String email) {
        clickEmailInput();
        clearEmailInput();
        setEmailInput(email);
    }

    private void enterPasswordInput(String password) {
        clickPasswordInput();
        clearPasswordInput();
        setPasswordInput(password);
    }

    //public void fillLogin(IUser user) {
    public void fillLogin(String email, String password) {
        enterEmailInput(email);
        enterPasswordInput(password);
        clickSignInButton();
    }

    // Business Logic

    //public HomePage successfulLogin(IUser validUser) {
    public HomePage successfulLogin(String email, String password) {
        fillLogin(email, password);
        return new HomePage(driver);
    }

    //public LoginModal unsuccessfulLoginPage(IUser invalidUser) {
    public LoginModal unsuccessfulLoginPage(String email, String password) {
        //fillLogin(invalidUser);
        fillLogin(email, password);
        return new LoginModal(driver);
    }
}

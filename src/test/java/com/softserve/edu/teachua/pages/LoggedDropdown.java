package com.softserve.edu.teachua.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoggedDropdown {

    private WebDriver driver;
    //
    private WebElement addClubLink;
    private WebElement addCenterLink;
    private WebElement searchCertificatesLink;
    private WebElement personalProfileLink;
    private WebElement signOutLink;

    protected LoggedDropdown(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        addClubLink = driver.findElement(By.cssSelector("li[data-menu-id*='club'] > span.ant-dropdown-menu-title-content"));
        addCenterLink = driver.findElement(By.cssSelector("li[data-menu-id*='centre'] > span"));
        searchCertificatesLink = driver.findElement(By.cssSelector("li[data-menu-id*='certificates'] > span"));
        personalProfileLink = driver.findElement(By.cssSelector("li[data-menu-id*='profile'] > span"));
        signOutLink = driver.findElement(By.cssSelector("li[data-menu-id*='logout'] > span"));
    }

    // Page Object

    // addClubLink;
    public WebElement getAddClubLink() {
        return addClubLink;
    }

    public String getAddClubLinkText() {
        return getAddClubLink().getText();
    }

    public void clickAddClubLink() {
        getAddClubLink().click();
    }

    // addCenterLink;
    public WebElement getAddCenterLink() {
        return addCenterLink;
    }

    public String getAddCenterLinkText() {
        return getAddCenterLink().getText();
    }

    public void clickAddCenterLink() {
        getAddCenterLink().click();
    }

    // searchCertificatesLink;
    public WebElement getSearchCertificatesLink() {
        return searchCertificatesLink;
    }

    public String getSearchCertificatesLinkText() {
        return getSearchCertificatesLink().getText();
    }

    public void clickSearchCertificatesLink() {
        getSearchCertificatesLink().click();
    }

    // personalProfileLink;
    public WebElement getPersonalProfileLink() {
        return personalProfileLink;
    }

    public String getPersonalProfileLinkText() {
        return getPersonalProfileLink().getText();
    }

    public void clickPersonalProfileLink() {
        getPersonalProfileLink().click();
    }

    // signOutLink;
    public WebElement getSignOutLink() {
        return signOutLink;
    }

    public String getSignOutLinkText() {
        return getSignOutLink().getText();
    }

    public void clickSignOutLink() {
        getSignOutLink().click();
    }

    // Functional

    // Business Logic

    // TODO signout
}

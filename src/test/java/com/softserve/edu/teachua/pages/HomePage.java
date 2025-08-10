package com.softserve.edu.teachua.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends TopSearchPart {

    public static final String BEGIN_TEACH_LABEL_MESSAGE = "Ініціатива";

    private WebElement addClubButton;
    private WebElement teachLabel;

    public HomePage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        addClubButton = driver.findElement(By.cssSelector("button.add-club-button"));
        teachLabel = driver.findElement(By.cssSelector("div.city-name-box h2.city-name"));
    }

    // Page Object

    // addClubButton
    public WebElement getAddClubButton() {
        return addClubButton;
    }

    public String getAddClubButtonText() {
        return getAddClubButton().getText();
    }

    public void clickAddClubButton() {
        getAddClubButton().click();
    }

    // teachLabel
    public WebElement getTeachLabel() {
        return teachLabel;
    }

    public String getTeachLabelText() {
        return getTeachLabel().getText();
    }

    // Functional

    // Business Logic

    // addClubButton
    public LoginModal openLoginModalAddClub() {
        clickAddClubButton();
        return new LoginModal(driver);
    }

    /* // TODO
    public AddClubModal openAddClubModal() {
        clickAddClubButton();
        return new AddClubModal(driver);
    }
    */

}

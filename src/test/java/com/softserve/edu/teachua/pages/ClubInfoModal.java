package com.softserve.edu.teachua.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClubInfoModal {

    private WebDriver driver;

    // TODO
    private WebElement ariaCloseButton;
    private WebElement clubTitleLabel;
    private WebElement clubMoreButton;
    private WebElement clubDescriptionLabel;

    public ClubInfoModal(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        ariaCloseButton = driver.findElement(By.cssSelector("button[aria-label='Close']"));
        clubTitleLabel = driver.findElement(By.cssSelector("div.title div.club-name"));
        clubMoreButton = driver.findElement(By.cssSelector("button.more-button"));
        clubDescriptionLabel = driver.findElement(By.cssSelector("div.about-club div.description"));
    }

    // Page Object

    // ariaCloseButton
    public WebElement getAriaCloseButton() {
        return ariaCloseButton;
    }

    public void clickAriaCloseButton() {
        getAriaCloseButton().click();
    }

    // clubTitleLabel;
    public WebElement getClubTitleLabel() {
        return clubTitleLabel;
    }

    public String getClubTitleLabelText() {
        return getClubTitleLabel().getText();
    }

    // clubMoreButton;
    public WebElement getClubMoreButton() {
        return clubMoreButton;
    }

    public String getClubMoreButtonText() {
        return getClubMoreButton().getText();
    }

    public void clickClubMoreButton() {
        getClubMoreButton().click();
    }

    // clubDescriptionLabel
    public WebElement getClubDescriptionLabel() {
        return clubDescriptionLabel;
    }

    public String getClubDescriptionLabelText() {
        return getClubDescriptionLabel().getText();
    }

    // Functional

    // Business Logic

    public ClubPage closeClubInfoModal() {
        // TODO
        clickAriaCloseButton();
        return new ClubPage(driver);
    }

    // moreAboutClub
    public ClubDetailsPage gotoClubDetailsPage() {
        // TODO
        clickClubMoreButton();
        return new ClubDetailsPage(driver);
    }

}

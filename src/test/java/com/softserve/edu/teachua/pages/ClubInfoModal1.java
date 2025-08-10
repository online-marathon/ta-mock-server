package com.softserve.edu.teachua.pages;

import org.openqa.selenium.WebDriver;

public class ClubInfoModal1 {

    private WebDriver driver;

    // TODO

    public ClubInfoModal1(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
    }

    // Page Object

    // Functional

    // Business Logic

    public ClubPage closeClubInfoModal() {
        // TODO
        return new ClubPage(driver);
    }

    // moreAboutClub
    public ClubDetailsPage gotoClubDetailsPage() {
        // TODO
        return new ClubDetailsPage(driver);
    }

}

package com.softserve.edu.teachua.pages;

import org.openqa.selenium.WebDriver;

public class ClubDetailsPage1 extends TopPart {

    // TODO

    public ClubDetailsPage1(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
    }

    // Page Object

    // Functional

    // Business Logic

    public ClubCommentModal openClubCommentModal() {
        // TODO
        return new ClubCommentModal(driver);
    }

}

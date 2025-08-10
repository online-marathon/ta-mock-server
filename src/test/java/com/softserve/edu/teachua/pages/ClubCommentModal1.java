package com.softserve.edu.teachua.pages;

import org.openqa.selenium.WebDriver;

public class ClubCommentModal1 {

    private WebDriver driver;

    // TODO

    public ClubCommentModal1(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
    }

    // Page Object

    // Functional

    // Business Logic

    public ClubDetailsPage submitComment(String commentText) {
        // TODO
        return new ClubDetailsPage(driver);
    }
}

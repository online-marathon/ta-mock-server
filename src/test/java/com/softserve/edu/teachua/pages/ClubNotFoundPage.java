package com.softserve.edu.teachua.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClubNotFoundPage extends TopSearchPart {
    public static String NOT_FOUND_MASSAGE = "За критеріями пошуку гуртків не знайдено";

    private WebElement notFoundLabel;

    public ClubNotFoundPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        notFoundLabel = driver.findElement(By.cssSelector("div.clubs-not-found"));
    }

    // Page Object

    // notFoundLabel
    public WebElement getNotFoundLabel() {
        return notFoundLabel;
    }

    public String getNotFoundLabelText() {
        return getNotFoundLabel().getText();
    }

    // Functional

    // Business Logic

}

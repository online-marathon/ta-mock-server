package com.softserve.edu.teachua.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UkrainianServicePage extends TopSearchPart {

    private WebElement faqTitleLabel;

    public UkrainianServicePage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        faqTitleLabel = driver.findElement(By.cssSelector("div.faq-title"));
    }

    // Page Object

    // faqTitleLabel
    public WebElement getFaqTitleLabel() {
        return faqTitleLabel;
    }

    public String getFaqTitleLabelText() {
        return getFaqTitleLabel().getText();
    }

    // Functional

    // Business Logic

}

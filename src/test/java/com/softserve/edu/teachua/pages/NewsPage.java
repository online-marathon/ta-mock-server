package com.softserve.edu.teachua.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewsPage extends TopSearchPart {

    private WebElement cityNewsLabel;

    public NewsPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        cityNewsLabel = driver.findElement(By.cssSelector("div.club-sider h2.city-name"));
    }

    // Page Object

    // cityNewsLabel
    public WebElement getCityNewsLabel() {
        return cityNewsLabel;
    }

    public String getCityNewsLabelText() {
        return getCityNewsLabel().getText();
    }

    // Functional

    // Business Logic

}

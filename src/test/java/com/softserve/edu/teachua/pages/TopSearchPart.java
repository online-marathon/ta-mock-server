package com.softserve.edu.teachua.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class TopSearchPart extends TopPart {

    private WebElement searchInput;

    public TopSearchPart(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        searchInput = driver.findElement(By.cssSelector("input.ant-select-selection-search-input"));
    }

    // Page Object

    // searchInput
    public WebElement getSearchInput() {
        return searchInput;
    }

    public String getSearchInputText() {
        return getSearchInput().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearSearchInput() {
        getSearchInput().clear();
    }

    public void clickSearchInput() {
        getSearchInput().click();
    }

    public void setSearchInput(String text) {
        getSearchInput().sendKeys(text + Keys.ARROW_RIGHT);
    }

    // Functional

    // searchInput
    private void fillSearchInput(String searchText) {
        clickSearchInput();
        clearSearchInput();
        setSearchInput(searchText);
    }

    // Business Logic

    public ClubPage successfulSearchClub(String searchText) {
        fillSearchInput(searchText);
        return new ClubPage(driver);
    }

    public ClubNotFoundPage unsuccessfulSearchClub(String searchText) {
        fillSearchInput(searchText);
        return new ClubNotFoundPage(driver);
    }

}

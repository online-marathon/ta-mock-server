package com.softserve.edu.teachua.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClubDetailsPage extends TopPart {

    // TODO
    private WebElement createCommentButton;
    private WebElement authorContentLabel;
    private WebElement datetimeLabel;
    private WebElement commentContentLabel;

    public ClubDetailsPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        createCommentButton = driver.findElement(By.cssSelector("button.comment-button"));
        authorContentLabel = driver.findElement(By.cssSelector("div.ant-spin-container li:first-child div.author-content > span.name"));
        datetimeLabel = driver.findElement(By.cssSelector("div.ant-spin-container li:first-child div.author-content > span.datetime"));
        commentContentLabel = driver.findElement(By.cssSelector("div.ant-spin-container li:first-child div.ant-comment-content-detail > p"));
    }

    // Page Object

    // createCommentButton
    public WebElement getCreateCommentButton() {
        return createCommentButton;
    }

    public String getCreateCommentButtonText() {
        return getCreateCommentButton().getText();
    }

    public void clickCreateCommentButton() {
        getCreateCommentButton().click();
    }

    // authorContentLabel
    public WebElement getAuthorContentLabel() {
        return authorContentLabel;
    }

    public String getAuthorContentLabelText() {
        return getAuthorContentLabel().getText();
    }


    // datetimeLabel
    public WebElement getDatetimeLabel() {
        return datetimeLabel;
    }

    public String getDatetimeLabelText() {
        return getDatetimeLabel().getText();
    }

    // commentContentLabel
    public WebElement getCommentContentLabel() {
        return commentContentLabel;
    }

    public String getCommentContentLabelText() {
        return getCommentContentLabel().getText();
    }

    // Functional

    // Business Logic

    public ClubCommentModal openClubCommentModal() {
        // TODO
        clickCreateCommentButton();
        return new ClubCommentModal(driver);
    }

}

package com.softserve.edu.teachua.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClubCommentModal {

    private WebDriver driver;

    // TODO
    private WebElement rateStar5Link;
    private WebElement typeCommentArea;
    private WebElement sendCommentButton;

    public ClubCommentModal(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // TODO
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // init elements
        rateStar5Link = driver.findElement(By.cssSelector("div.ant-form-item div[aria-posinset='5']"));
        typeCommentArea = driver.findElement(By.id("comment-edit_commentText"));
        sendCommentButton = driver.findElement(By.cssSelector("button.do-comment-button"));
    }

    // Page Object

    // rateStar5Link
    public WebElement getRateStar5Link() {
        return rateStar5Link;
    }

    public void clickRateStar5Link() {
        getRateStar5Link().click();
    }

    // typeCommentArea
    public WebElement getTypeCommentArea() {
        return typeCommentArea;
    }

    public String getTypeCommentAreaText() {
        return getTypeCommentArea().getText();
    }

    public void clearTypeCommentArea() {
        getTypeCommentArea().clear();
    }

    public void clickTypeCommentArea() {
        getTypeCommentArea().click();
    }

    public void setTypeCommentArea(String commentText) {
        getTypeCommentArea().sendKeys(commentText);
    }

    // sendCommentButton
    public WebElement getSendCommentButton() {
        return sendCommentButton;
    }

    public String getSendCommentButtonText() {
        return getSendCommentButton().getText();
    }

    public void clickSendCommentButton() {
        getSendCommentButton().click();
    }

    // Functional

    private void enterCommentArea(String commentText) {
        clickTypeCommentArea();
        clearTypeCommentArea();
        setTypeCommentArea(commentText);
    }

    public void acceptComment(String commentText) {
        clickRateStar5Link();
        enterCommentArea(commentText);
        clickSendCommentButton();
        //
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //
    }

    // Business Logic

    public ClubDetailsPage submitComment(String commentText) {
        // TODO
        acceptComment(commentText);
        return new ClubDetailsPage(driver);
    }
}

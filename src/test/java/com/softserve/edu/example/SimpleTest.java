package com.softserve.edu.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SimpleTest {
    private static final String BASE_URL = "http://speak-ukrainian.eastus2.cloudapp.azure.com/dev/";
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private static final Long ONE_SECOND_DELAY = 1000L;
    private static WebDriver driver;

    // Overload
    private static void presentationSleep() {
        presentationSleep(1);
    }

    // Overload
    private static void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void afterAll() {
        presentationSleep(); // For Presentation ONLY
        if (driver != null) {
            driver.quit();
            // driver.close();
        }
    }

    @BeforeEach
    public void beforeEach() {
        driver.get(BASE_URL);
        presentationSleep(); // For Presentation ONLY
    }

    @AfterEach
    public void afterEach() {
        presentationSleep(); // For Presentation ONLY
        // logout; clear cache; delete cookie; delete session;
        // Save Screen;
    }

    @Test
    public void checkLogin() {
        // Open caret
        driver.findElement(By.cssSelector("div.user-profile span.anticon.anticon-caret-down")).click();
        presentationSleep(); // For Presentation
        //
        // Open login window
        driver.findElement(By.cssSelector("li[data-menu-id*='login'] span.ant-dropdown-menu-title-content")).click();
        presentationSleep(); // For Presentation
        //
        // Enter email
        driver.findElement(By.id("basic_email")).click();
        driver.findElement(By.id("basic_email")).clear();
        driver.findElement(By.id("basic_email")).sendKeys("yagifij495@eqvox.com");
        presentationSleep(); // For Presentation
        //
        // Enter password
        driver.findElement(By.id("basic_password")).click();
        driver.findElement(By.id("basic_password")).clear();
        driver.findElement(By.id("basic_password")).sendKeys("Qwerty_1");
        presentationSleep(); // For Presentation
        //
        // Click sign in
        driver.findElement(By.cssSelector("div.login-footer button")).click();
        presentationSleep(); // For Presentation
        //
        // TODO Check message
        //
        // Search web element
        WebElement cityName = driver.findElement(By.cssSelector("h2.city-name"));
        presentationSleep(); // For Presentation
        //
        // Check
        Assertions.assertTrue(cityName.getText().contains("Навчай українською"));
        presentationSleep(); // For Presentation
    }

    @Test
    public void checkClubExist() {
        // Type in to search input
        driver.findElement(By
                .cssSelector("input.ant-select-selection-search-input")).sendKeys("Школа");
        presentationSleep(); // For Presentation
        //
        // Search club
        WebElement titleClub = driver.findElement(By
                .xpath("//div[contains(@class,'ant-card')]//div[contains(text(),'Dream Team')]"));
        presentationSleep(); // For Presentation
        //
        // Check club title
        Assertions.assertEquals("Школа танців Dream Team", titleClub.getText());
        presentationSleep(); // For Presentation
        //
        // View Club info
        titleClub.click();
        presentationSleep(); // For Presentation
    }

    @Test
    public void checkAddComment() {
        // Open caret
        driver.findElement(By.cssSelector("div.user-profile span.anticon.anticon-caret-down")).click();
        presentationSleep(); // For Presentation
        //
        // Open login window
        driver.findElement(By.cssSelector("li[data-menu-id*='login'] span.ant-dropdown-menu-title-content")).click();
        presentationSleep(); // For Presentation
        //
        // Enter email
        driver.findElement(By.id("basic_email")).click();
        driver.findElement(By.id("basic_email")).clear();
        driver.findElement(By.id("basic_email")).sendKeys("yagifij495@eqvox.com");
        presentationSleep(); // For Presentation
        //
        // Enter password
        driver.findElement(By.id("basic_password")).click();
        driver.findElement(By.id("basic_password")).clear();
        driver.findElement(By.id("basic_password")).sendKeys("Qwerty_1");
        presentationSleep(); // For Presentation
        //
        // Click sign in
        driver.findElement(By.cssSelector("div.login-footer button")).click();
        presentationSleep(); // For Presentation
        //
        // Goto club page
        driver.findElement(By.cssSelector("span.ant-menu-title-content > a[href*='/clubs']")).click();
        presentationSleep(); // For Presentation
        //
        // Type in to search input
        driver.findElement(By
                .cssSelector("input.ant-select-selection-search-input")).sendKeys("IT освіта");
        presentationSleep(); // For Presentation
        //
        // Check club title
        Assertions.assertTrue(driver.findElement(By
                        .xpath("//div[contains(@class,'ant-card-body')]//div[contains(text(),'IT освіта: курси')]"))
                        .getText().contains("ГРАНД"));
        presentationSleep(); // For Presentation
        //
        // Click details button
        driver.findElement(By.xpath("//div[@class='ant-card-body']//div[contains(text(),'IT освіта: курси')]/../../a[contains(@href, '/club/')]")).click();
        presentationSleep(); // For Presentation
        //
        // Click comment button
        driver.findElement(By.cssSelector("button.comment-button")).click();
        presentationSleep(); // For Presentation
        //
        // Choose five stars
        driver.findElement(By.cssSelector("div.ant-form-item div[aria-posinset='5']")).click();
        presentationSleep(); // For Presentation
        //
        // Type comment
        driver.findElement(By.id("comment-edit_commentText")).click();
        driver.findElement(By.id("comment-edit_commentText")).clear();
        driver.findElement(By.id("comment-edit_commentText")).sendKeys("Проба Коментар");
        presentationSleep(); // For Presentation
        //
        // Click send button
        driver.findElement(By.cssSelector("button.do-comment-button")).click();
        presentationSleep(); // For Presentation
        //
        // Read last comment
        WebElement comment = driver.findElement(By.xpath(("//div[@class='ant-comment-content']//span[contains(text(), 'Проба')]/../../../../../div[@class='ant-comment-content-detail']/p")));
        presentationSleep(); // For Presentation
        //
        // Check comment text
        Assertions.assertEquals("Проба Коментар", comment.getText());
        presentationSleep(); // For Presentation
        //
        // Open caret
        driver.findElement(By.cssSelector("div.user-profile span.anticon.anticon-caret-down")).click();
        presentationSleep(); // For Presentation
        //
        // Sign out
        driver.findElement(By.cssSelector("li[data-menu-id*='logout'] span.ant-dropdown-menu-title-content")).click();
        presentationSleep(); // For Presentation
    }

}

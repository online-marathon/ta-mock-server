package com.softserve.edu.teachua.tests;

import com.softserve.edu.teachua.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TeachTest1 {

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

    protected HomePage loadApplication() {
        return new HomePage(driver);
    }

    @Test
    public void checkSmoke() {
        // Steps
        HomePage homePage = loadApplication()
                .gotoClubPage()
                .gotoNewsPage()
                .gotoAboutUsPage()
                .gotoUkrainianServicePage()
                .gotoHomePage();
        presentationSleep();
        //
        // Check
        Assertions.assertTrue(homePage.getTeachLabelText().contains(HomePage.BEGIN_TEACH_LABEL_MESSAGE));
    }

    @ParameterizedTest(name = "{index} => email={0}, password={1}")
    @CsvSource({"yagifij495@eqvox.com, Qwerty_1"})
    public void checkSuccessfulLogin(String email, String password) {
        // Steps
        HomePage homePage = loadApplication()
                .openLoginModal()
                .successfulLogin(email, password);
        presentationSleep();
        //
        // TODO Check pop-up message
        //
        // Check
        Assertions.assertTrue(homePage.getTeachLabelText()
                .contains(HomePage.BEGIN_TEACH_LABEL_MESSAGE));
        presentationSleep();
        //
        // TODO
        // homePage = homePage.signoutUser();
        // presentationSleep();
    }

    @ParameterizedTest(name = "{index} => email={0}, password={1}")
    @CsvSource({"hahaha@gmail.com, Qwerty_1"})
    public void checkUnsuccessfulLogin(String email, String password) {
        // Steps
        LoginModal loginModal = loadApplication()
                .openLoginModal()
                .unsuccessfulLoginPage(email, password);
        presentationSleep();
        //
        // TODO Check pop-up message
    }

    @ParameterizedTest(name = "{index} => searchText={0}, clubTitle={1}")
    @CsvSource({"Dream Team, Школа танців Dream Team"})
    public void checkClubExist(String searchText, String clubTitle) {
        ClubPage clubPage = loadApplication()
                .successfulSearchClub(searchText);
        //
        // Check club title
        Assertions.assertEquals(clubTitle, clubPage.getClubTitleLinkText());
    }

    @ParameterizedTest(name = "{index} => searchText={0}")
    @CsvSource({"proba"})
    public void checkClubNotExist(String searchText) {
        ClubNotFoundPage clubNotFoundPage = loadApplication()
                .unsuccessfulSearchClub(searchText);
        //
        // Check club title
        Assertions.assertEquals(ClubNotFoundPage.NOT_FOUND_MASSAGE, clubNotFoundPage.getNotFoundLabelText());
    }

    @ParameterizedTest(name = "{index} => email={0}, password={1}, searchText={2}, commentText={3}")
    @CsvSource({"yagifij495@eqvox.com, Qwerty_1, IT освіта: курси, Проба Коментар"})
    public void checkAddComment(String email, String password, String searchText, String commentText) {
        ClubDetailsPage clubDetailsPage = loadApplication()
                .openLoginModal()
                .successfulLogin(email, password)
                .successfulSearchClub(searchText)
                .gotoClubDetailsPage();
                //.openClubCommentModal()
                //.submitComment(commentText);
        //
        // TODO Check comment text
        //
        // clubDetailsPage.signoutUser();
    }

    @ParameterizedTest(name = "{index} => searchText={0}, commentText={1}")
    @CsvSource({"IT освіта: курси, Проба Коментар"})
    public void checkExistComment(String searchText, String commentText) {
        ClubDetailsPage clubDetailsPage = loadApplication()
                .successfulSearchClub(searchText)
                .openClubInfoModal()
                .gotoClubDetailsPage();
        //
        // TODO Check comment text
        //
        // clubDetailsPage.signoutUser();
    }
}

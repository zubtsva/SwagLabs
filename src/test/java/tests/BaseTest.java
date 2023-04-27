package tests;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    WebDriver webDriver;
    LoginPage loginPage;
    HomePage homePage;
    String baseUrl = "https://www.saucedemo.com/";

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    @BeforeMethod
    public void beforeMethod() {
        webDriver.manage().deleteAllCookies();
        open(baseUrl);
    }

    @AfterClass
    public void teardown() {
        webDriver.quit();
    }
}

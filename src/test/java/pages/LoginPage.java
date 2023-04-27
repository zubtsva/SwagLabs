package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage{

    public final By EMAIL_INPUT = By.id("user-name");
    public final By PASSWORD_INPUT = By.id("password");
    public final By LOGIN_BUTTON = By.name("login-button");
    public final String CORRECT_USERNAME = "standard_user";
    public final String PASSWORD = "secret_sauce";
    public final String INCORRECT_USERNAME = "locked_out_user";
    public final By successMessage = By.xpath("//span[@class='title']");
    public String expectedSuccessMessage = "Products";
    public final By errorMessage = By.xpath("//h3[@data-test='error']");
    public String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void attemptCorrectLoginTest() {

        $(EMAIL_INPUT).sendKeys(CORRECT_USERNAME);
        $(PASSWORD_INPUT).sendKeys(PASSWORD);
        $(LOGIN_BUTTON).click();

    }
    public void attemptIncorrectLoginTest() {

        $(EMAIL_INPUT).sendKeys(INCORRECT_USERNAME);
        $(PASSWORD_INPUT).sendKeys(PASSWORD);
        $(LOGIN_BUTTON).click();

    }


}

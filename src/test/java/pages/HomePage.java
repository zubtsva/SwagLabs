package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage{

    public HomePage(WebDriver webDriver){
        super(webDriver);
    }
    public final By EMAIL_INPUT = By.id("user-name");
    public final By PASSWORD_INPUT = By.id("password");
    public final By LOGIN_BUTTON = By.name("login-button");
    public final String CORRECT_USERNAME = "standard_user";
    public final String PASSWORD = "secret_sauce";
    public By addToCartButton = By.id("add-to-cart-sauce-labs-fleece-jacket");
    public By cartButton = By.xpath("//a[@class='shopping_cart_link']");
    public By itemName = By.xpath("//div[@class='inventory_item_name']");
    public String expectedItemName = "Sauce Labs Fleece Jacket";


    public String cartTest() {
        $(EMAIL_INPUT).sendKeys(CORRECT_USERNAME);
        $(PASSWORD_INPUT).sendKeys(PASSWORD);
        $(LOGIN_BUTTON).click();
        $(addToCartButton).click();
        $(cartButton).click();
        return $(itemName).getText();
    }
}

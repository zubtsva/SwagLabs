package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class Tests extends BaseTest {
    @Test (priority = 1)
    @Feature("Login Test")
    @Description("Test with correct login and password")
    public void successfulLoginTest() {
        loginPage.attemptCorrectLoginTest();
        $(loginPage.successMessage).should(Condition.exist);
        Assert.assertEquals(
                $(loginPage.successMessage).getText(), loginPage.expectedSuccessMessage);
    }

    @Test(priority = 2)
    @Description("Test with incorrect login")
    @Feature("Login Test")
    public void unsuccessfulLoginTest() {
        loginPage.attemptIncorrectLoginTest();
        $(loginPage.errorMessage).should(Condition.exist);
        Assert.assertEquals(
                $(loginPage.errorMessage).getText(),
                loginPage.expectedErrorMessage);
    }

    @Test(priority = 3)
    @Story("Item exists in cart")
    @Description("Test checks the item was added to cart")
    public void itemExistInCartTest() {
        homePage.cartTest();
        $(homePage.itemName).should(Condition.exist);
        Assert.assertEquals(
                $(homePage.itemName).getText(), homePage.expectedItemName);
    }
}

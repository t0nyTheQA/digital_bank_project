package co.digitalBankCucumberPractice.automation.ui.steps;

import co.digitalBankCucumberPractice.automation.ui.Pages.LoginPage;
import co.digitalBankCucumberPractice.automation.ui.Utilities.ConfigReader;
import co.digitalBankCucumberPractice.automation.ui.Utilities.Driver;
import io.cucumber.java.Before;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginSteps {

    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));



    @Given("user entered {string} and {string}")
    public void user_entered_and(String invalidUsername, String invalidPassword) {
        loginPage.navigateToLoginPage();
        assertEquals(ConfigReader.getPropertiesValue("dBankLoginPageURL"), driver.getCurrentUrl());
        loginPage.login(invalidUsername, invalidPassword);
        WebElement errorMessage = driver.findElement(By.xpath("//div/span/.."));
        assertTrue(errorMessage.isDisplayed());
        System.out.println(errorMessage.getText());
    }


    @Given("user entered valid {string} and {string}")
    public void user_entered_valid_and(String validUsername, String validPassword) {
        loginPage.navigateToLoginPage();
        loginPage.login(validUsername, validPassword);
    }


    @Then("verify user successfully logged in")
    public void verify_user_successfully_logged_in() {
        String expectedUrl = "https://dbank-qa.wedevx.co/bank/home";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }


}

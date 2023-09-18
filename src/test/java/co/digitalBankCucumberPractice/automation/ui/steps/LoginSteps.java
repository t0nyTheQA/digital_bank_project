package co.digitalBankCucumberPractice.automation.ui.steps;

import co.digitalBankCucumberPractice.automation.ui.Pages.LoginPage;
import co.digitalBankCucumberPractice.automation.ui.Utilities.Driver;
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

    @Given("url {string} is opened;")
    public void url_is_opened(String url) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        assertEquals("https://dbank-qa.wedevx.co/bank/login", driver.getCurrentUrl());
    }


    @Given("user entered {string} and {string}")
    public void user_entered_and(String invalidUsername, String invalidPassword) {

        loginPage.login(invalidUsername, invalidPassword);
    }

    @Then("verify user is not logged")
    public void verify_user_is_not_logged() {
        WebElement errorMessage = driver.findElement(By.xpath("//div/span/.."));
        assertTrue(errorMessage.isDisplayed());
        System.out.println(errorMessage.getText());
    }

    @Given("user entered valid {string} and {string}")
    public void user_entered_valid_and(String validUsername, String validPassword) {
        loginPage.login(validUsername,validPassword);
    }


    @Then("verify user successfully logged in")
    public void verify_user_successfully_logged_in() {
        String expectedUrl = "https://dbank-qa.wedevx.co/bank/home";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }


}

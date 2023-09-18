package co.digitalBankCucumberPractice.automation.ui.steps;


import co.digitalBankCucumberPractice.automation.ui.Models.RegistrationData;
import co.digitalBankCucumberPractice.automation.ui.Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import co.digitalBankCucumberPractice.automation.ui.Utilities.Driver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RegisterNewUserSteps {

    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage(driver);


    @Given("user clicks on Sign Up Here link from the login page")
    public void user_clicks_on_sign_up_here_link_from_the_login_page() {
        driver.get("https://dbank-qa.wedevx.co/bank/login");
        loginPage.clickToSignUp();
    }

    @When("user enters the following data:")
    public void user_enters_the_following_data(List<RegistrationData> registrationData) {
        RegistrationData expectedRegData = registrationData.get(0);

        WebElement titleSelector = driver.findElement(By.xpath("//select[@name='title']"));
        WebElement firstNameTextBox = driver.findElement(By.xpath("//input[@name = 'firstName']"));
        WebElement lastNameTextBox = driver.findElement(By.xpath("//input[@name = 'lastName']"));
        WebElement maleRadioButton = driver.findElement(By.xpath("//input[@type='radio' and @value='M'] "));
        // WebElement femaleRadioButton = driver.findElement(By.xpath("//input[@value='F']"));
        WebElement DobTextBox = driver.findElement(By.xpath("//input[@name = 'dob']"));
        WebElement SsnTextBox = driver.findElement(By.xpath("//input[@name='ssn']"));
        WebElement emailAddressTextBox = driver.findElement(By.xpath("//input [@type='email' and @name ='emailAddress']"));
        WebElement passwordTextBox = driver.findElement(By.id("password"));
        WebElement confirmPasswordTextBox = driver.findElement(By.id("confirmPassword"));
        // WebElement signInLinkIfAccountExists = driver.findElement(By.xpath("//a[@href='/bank/login']"));
        WebElement nextButton = driver.findElement(By.xpath("//button[@type ='submit']"));
        Select selectTitle = new Select(titleSelector);

        selectTitle.selectByVisibleText(expectedRegData.getTitle());
        firstNameTextBox.sendKeys(expectedRegData.getFirstName());
        lastNameTextBox.sendKeys(expectedRegData.getLastName());
        maleRadioButton.click();
        DobTextBox.sendKeys(expectedRegData.getDateOfBirth());
        SsnTextBox.sendKeys(expectedRegData.getSsn());
        emailAddressTextBox.sendKeys(expectedRegData.getEmail());
        passwordTextBox.sendKeys(expectedRegData.getPassword());
        confirmPasswordTextBox.sendKeys(expectedRegData.getConfirmPassword());
        nextButton.click();


        WebElement addressTextBox = driver.findElement(By.id("address"));
        WebElement localityTextBox = driver.findElement(By.xpath("//input[@name= 'locality']"));
        WebElement regionTextBox = driver.findElement(By.xpath("//input[@name= 'region']"));
        WebElement postalCodeTextBox = driver.findElement(By.xpath("//input[@name= 'postalCode']"));
        WebElement countryTextBox = driver.findElement(By.xpath("//input[@name= 'country']"));
        WebElement homePhoneTextBox = driver.findElement(By.id("homePhone"));
        WebElement mobilePhoneTextBox = driver.findElement(By.id("mobilePhone"));
        WebElement workPhoneTextBox = driver.findElement(By.id("workPhone"));

        addressTextBox.sendKeys(expectedRegData.getAddress());
        localityTextBox.sendKeys(expectedRegData.getLocality());
        regionTextBox.sendKeys(expectedRegData.getRegion());
        postalCodeTextBox.sendKeys(expectedRegData.getPostalCode());
        countryTextBox.sendKeys(expectedRegData.getCountry());
        mobilePhoneTextBox.sendKeys(expectedRegData.getMobilePhone());
        homePhoneTextBox.sendKeys(expectedRegData.getMobilePhone());


    }


    @When("user agrees to the terms and policies and clicks on Register button")
    public void user_agrees_to_the_terms_and_policies_and_clicks_on_register_button() {

        WebElement registerButton = driver.findElement(By.xpath("//button[text()='Register']"));
        WebElement agreeToTermsCheckBox = driver.findElement(By.xpath("//input[@name= 'agree-terms']"));

        agreeToTermsCheckBox.click();
        registerButton.click();
    }

    @Then("user should see a green {string} alert")
    public void user_should_see_a_green_alert(String string) {
        WebElement successAlert = driver.findElement(By.xpath("//span[text()='Registration Successful. Please Login.']"));
        assertEquals("Registration Successful. Please Login.", successAlert.getText());
    }


}

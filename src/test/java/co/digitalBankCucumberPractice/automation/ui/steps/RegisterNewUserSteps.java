package co.digitalBankCucumberPractice.automation.ui.steps;

import co.digitalBankCucumberPractice.automation.ui.Pages.RegistrationPage1;
import co.digitalBankCucumberPractice.automation.ui.Pages.RegistrationPage2;
import co.digitalBankCucumberPractice.automation.ui.Utilities.ConfigReader;
import co.digitalBankCucumberPractice.automation.ui.Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RegisterNewUserSteps {

    WebDriver driver = Driver.getDriver();
    RegistrationPage1 registrationPage1 = new RegistrationPage1(driver);
    RegistrationPage2 registrationPage2 = new RegistrationPage2(driver);


    @Given("user is on the dBank registration page")
    public void user_is_on_the_d_bank_registration_page() {
        driver.get(ConfigReader.getPropertiesValue("dBankRegistrationPageURL"));
        assertEquals("Digital Bank", driver.getTitle(), "registration page title mismatch");
    }

    @When("user enters the following data with mocked SSN and email")
    public void user_enters_the_following_data_with_mocked_ssn_and_email(List<Map<String, String>> registrationTableList) {
        registrationPage1.fillOutRegistrationPage1(registrationTableList);
        registrationPage2.fillOutRegistrationPage2(registrationTableList);

    }

    @Then("user should see a green {string} alert")
    public void user_should_see_a_green_alert(String confirmationMessage) {
    }

}

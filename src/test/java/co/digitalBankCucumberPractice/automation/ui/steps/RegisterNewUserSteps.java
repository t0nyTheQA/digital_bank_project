package co.digitalBankCucumberPractice.automation.ui.steps;

import co.digitalBankCucumberPractice.automation.ui.Pages.RegistrationPage1;
import co.digitalBankCucumberPractice.automation.ui.Pages.RegistrationPage2;
import co.digitalBankCucumberPractice.automation.ui.Utilities.ConfigReader;
import co.digitalBankCucumberPractice.automation.ui.Utilities.DBUtils;
import co.digitalBankCucumberPractice.automation.ui.Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;


public class RegisterNewUserSteps {

    WebDriver driver = Driver.getDriver();
    RegistrationPage1 registrationPage1 = new RegistrationPage1(driver);
    RegistrationPage2 registrationPage2 = new RegistrationPage2(driver);

    @Given("the user with {string} is not in database")
    public void theUserWithIsNotInDatabase(String email) {
        String queryForUserProfile = String.format("DELETE from user_profile where email_address='%s'", email);
        String queryForUsers = String.format("delete from users where email_address='%s'", email);


        DBUtils.runSQLUpdateQuery(queryForUserProfile);
        DBUtils.runSQLUpdateQuery(queryForUsers);

    }

    @Given("user is on the dBank registration page")
    public void user_is_on_the_d_bank_registration_page() {
        driver.get(ConfigReader.getPropertiesValue("dBankRegistrationPageURL"));
        assertEquals("Digital Bank", driver.getTitle(), "registration page title mismatch");
    }

    @When("user enters the following data")
    public void user_enters_the_following_data(List<Map<String, String>> registrationTableList) {
        registrationPage1.fillOutRegistrationPage1(registrationTableList);
        registrationPage2.fillOutRegistrationPage2(registrationTableList);

    }

    @Then("user should see a green {string} alert")
    public void user_should_see_a_green_alert(String confirmationMessage) {
        assertEquals(confirmationMessage, registrationPage2.getConfirmationMessage());
    }

    @Then("The user should see the {string} with the appropriate {string}")
    public void theUserShouldSeeTheWithTheAppropriate(String fieldName, String expectedErrorMessage) {
        if (registrationPage2.getAddressTextBox().isDisplayed()) {
            String actualErrorMessagePage2 = registrationPage2.getRequiredFieldErrorMessage(fieldName);
            assertEquals(expectedErrorMessage, actualErrorMessagePage2, "Mismatch with the " + fieldName + " error message");
        } else if (registrationPage1.getTitleSelector().isDisplayed()) {
            String actualErrorMessage = registrationPage1.getRequiredFieldErrorMessage(fieldName);
            assertEquals(expectedErrorMessage, actualErrorMessage, "Mismatch with the " + fieldName + " error message");
        }
    }


    @And("the following user info should be saved in the database")
    public void theFollowingUserInfoShouldBeSavedInTheDatabase(List<Map<String, String>> expectedDataBaseInfo) {

    }
}


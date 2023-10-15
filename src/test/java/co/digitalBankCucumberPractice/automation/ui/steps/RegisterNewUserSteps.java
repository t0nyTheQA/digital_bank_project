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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RegisterNewUserSteps {


    WebDriver driver = Driver.getDriver();
    RegistrationPage1 registrationPage1 = new RegistrationPage1(driver);
    RegistrationPage2 registrationPage2 = new RegistrationPage2(driver);
    List<Map<String, Object>> nextIdValueSequence = new ArrayList<>();

    @Given("the user with {string} is not in database")
    public void theUserWithIsNotInDatabase(String email) {
        String queryForUserProfile = String.format("DELETE from user_profile where email_address='%s'", email);
        String queryForUsers = String.format("delete from users where username='%s'", email);
        String queryToGetNexValueInHibernateSeq = "select next_val from hibernate_sequence";

        nextIdValueSequence = DBUtils.runSQLSelectQuery(queryToGetNexValueInHibernateSeq);

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
        Map<String, String> expectedUserInfoMap = expectedDataBaseInfo.get(0);
        String queryUser = String.format("select * from users where username = '%s'", expectedUserInfoMap.get("email"));
        String queryUser_profile = String.format("select * from user_profile where email_address = '%s'", expectedUserInfoMap.get("email"));

        List<Map<String, Object>> actualUserInfoList = DBUtils.runSQLSelectQuery(queryUser);
        List<Map<String, Object>> actualUserProfileInfoList = DBUtils.runSQLSelectQuery(queryUser_profile);

        assertEquals(1, actualUserInfoList.size(), "registration generated duplicate users");
        assertEquals(1, actualUserProfileInfoList.size(), "registration generated duplicate users_profile");

        Map<String, Object> actualUserInfo = actualUserInfoList.get(0);
        Map<String, Object> actualUserProfileInfo = actualUserProfileInfoList.get(0);

        assertEquals(expectedUserInfoMap.get("title"), actualUserProfileInfo.get("title"), "incorrect title");
        assertEquals(expectedUserInfoMap.get("firstName"), actualUserProfileInfo.get("first_name"), "incorrect firstName");
        assertEquals(expectedUserInfoMap.get("lastName"), actualUserProfileInfo.get("last_name"), "incorrect lstName");
        assertEquals(expectedUserInfoMap.get("gender"), actualUserProfileInfo.get("gender"), "incorrect gender");
//        assertEquals(expectedUserInfoMap.get("ssn"), actualUserProfileInfo.get("ssn"), "wrong ssn");
        assertEquals(expectedUserInfoMap.get("email"), actualUserProfileInfo.get("email_address"), "wrong email");
        assertEquals(expectedUserInfoMap.get("address"), actualUserProfileInfo.get("address"), "wrong address");
        assertEquals(expectedUserInfoMap.get("locality"), actualUserProfileInfo.get("locality"), "wrong locality");
        assertEquals(expectedUserInfoMap.get("region"), actualUserProfileInfo.get("region"), "wrong region");
        assertEquals(expectedUserInfoMap.get("postalCode"), actualUserProfileInfo.get("postal_code"), "wrong postal code");
        assertEquals(expectedUserInfoMap.get("country"), actualUserProfileInfo.get("country"), "wrong country");
        assertEquals(expectedUserInfoMap.get("mobilePhone"), actualUserProfileInfo.get("mobile_phone"), "wrong mobile phone number");

        assertEquals(expectedUserInfoMap.get("email"), actualUserInfo.get("username"), "email/username mismatch");
        assertEquals(nextIdValueSequence.get(0).get("next_val"), actualUserInfo.get("id"));
        long expectedUserProfileId = Integer.parseInt(String.valueOf(nextIdValueSequence.get(0).get("next_val")));
        assertEquals(++expectedUserProfileId,actualUserProfileInfo.get("id"));



    }
}


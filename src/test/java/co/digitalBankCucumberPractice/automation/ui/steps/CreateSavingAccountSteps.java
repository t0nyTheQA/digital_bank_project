package co.digitalBankCucumberPractice.automation.ui.steps;

import co.digitalBankCucumberPractice.automation.ui.Models.NewCheckingData;
import co.digitalBankCucumberPractice.automation.ui.Models.NewSavingAccountData;
import co.digitalBankCucumberPractice.automation.ui.Pages.CreateNewSavingsPage;
import co.digitalBankCucumberPractice.automation.ui.Pages.LoginPage;
import co.digitalBankCucumberPractice.automation.ui.Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateSavingAccountSteps {

    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    CreateNewSavingsPage newSavingsPage = new CreateNewSavingsPage(driver);


    @Given("user is on the login page of dBank")
    public void user_is_on_the_login_page_of_d_bank() {
        driver.get("https://dbank-qa.wedevx.co/bank/login");
    }

    @Given("user logs in with {string} and {string}")
    public void user_logs_in_with_and(String username, String password) {
        loginPage.login(username, password);
    }

    @When("User creates a new savings account with the information")
    public void user_creates_a_new_savings_account_with_the_information(List<NewSavingAccountData> newSavingAccountData)  {
        NewSavingAccountData expectedData = newSavingAccountData.get(0);
        newSavingsPage.navigateToNewSavingsPage();

        assertEquals("https://dbank-qa.wedevx.co/bank/account/savings-add",driver.getCurrentUrl());

        //method to create an individual saving account
        newSavingsPage.createNewSaving_IndividualAccount(expectedData.getAccountName(), String.valueOf(expectedData.getInitialDeposit()));

        assertTrue(newSavingsPage.getSavingsAccountTypeRadioButton().isSelected());
        assertTrue(newSavingsPage.getIndividualOwnershipRadio().isSelected());
        assertEquals(expectedData.getAccountName(), newSavingsPage.getAccountNameTextbox().getText());
        assertEquals(expectedData.getInitialDeposit(), Double.parseDouble(newSavingsPage.getInitialDepositTextbox().getText()));
    }

    @Then("user should see green {string} alert")
    public void user_should_see_green_alert(String alertText) {
    }

    @Then("user should see the new checking account card with initial input data and")
    public void user_should_see_the_new_checking_account_card_with_initial_input_data_and(io.cucumber.datatable.DataTable dataTable) {

    }
}

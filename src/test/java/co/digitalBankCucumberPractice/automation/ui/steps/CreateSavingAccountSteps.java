package co.digitalBankCucumberPractice.automation.ui.steps;

import co.digitalBankCucumberPractice.automation.ui.Models.NewSavingAccountData;
import co.digitalBankCucumberPractice.automation.ui.Models.SavingAccountCard;
import co.digitalBankCucumberPractice.automation.ui.Pages.CreateNewSavingsPage;
import co.digitalBankCucumberPractice.automation.ui.Pages.LoginPage;
import co.digitalBankCucumberPractice.automation.ui.Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;

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
    public void user_creates_a_new_savings_account_with_the_information(List<NewSavingAccountData> newSavingAccountData) throws InterruptedException {
        NewSavingAccountData expectedData = newSavingAccountData.get(0);
        newSavingsPage.navigateToNewSavingsPage();
        assertEquals("https://dbank-qa.wedevx.co/bank/account/savings-add", driver.getCurrentUrl());
        newSavingsPage.createNewSaving_IndividualAccount(expectedData.getAccountName(), String.valueOf(expectedData.getInitialDeposit()));

        assertTrue(newSavingsPage.getSavingsAccountTypeRadioButton().isSelected());
        assertTrue(newSavingsPage.getIndividualOwnershipRadio().isSelected());

//        assertEquals(expectedData.getAccountName(), newSavingsPage.getAccountNameTextbox().getText());
//        assertEquals(expectedData.getInitialDeposit(), Double.parseDouble(newSavingsPage.getInitialDepositTextbox().getText()));

        newSavingsPage.clickSubmit();
    }

    @Then("user should see green {string} alert")
    public void user_should_see_green_alert(String alertText) {

        assertEquals(alertText, newSavingsPage.getNewSavingAccountConfirmationMessage().getText());
    }

    @Then("user should see the new checking account card with initial input data and")
    public void user_should_see_the_new_checking_account_card_with_initial_input_data_and(List<SavingAccountCard> savingAccountCard) {
        SavingAccountCard expectedResult = savingAccountCard.get(0);
       String fullCardText = newSavingsPage.getLastMadeSavingsCardText();

        String actualAccName = fullCardText.substring(0, fullCardText.indexOf("Account")).trim();
        String actualAccType = fullCardText.substring(fullCardText.indexOf("Account"), fullCardText.indexOf("Ownership")).trim();
        String actualAccOwner = fullCardText.substring(fullCardText.indexOf("Ownership"), fullCardText.indexOf("Account Number")).trim();
        String actualAccNumber = fullCardText.substring(fullCardText.indexOf("Account Number"), fullCardText.indexOf("Interest")).trim();
        String actualAccInterest = fullCardText.substring(fullCardText.indexOf("Interest"), fullCardText.indexOf("Balance")).trim();
        String actualBalance = fullCardText.substring(fullCardText.indexOf("Balance"));

        assertEquals(expectedResult.getAccountName(), actualAccName);
        assertEquals("Account: " + expectedResult.getAccountType(), actualAccType);
        assertEquals("Ownership: " + expectedResult.getOwnership(), actualAccOwner);
        //assertEquals(expectedResult.getAccountNumber(), actualAccNumber); cannot validate number yt because it always changes
        assertEquals("Interest Rate: " + expectedResult.getInterestRate()+"%", actualAccInterest);
        assertEquals("Balance: $" + String.format("%.2f", expectedResult.getBalance()), actualBalance);


    }
}

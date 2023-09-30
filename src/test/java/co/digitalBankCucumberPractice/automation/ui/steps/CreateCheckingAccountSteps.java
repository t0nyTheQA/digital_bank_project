package co.digitalBankCucumberPractice.automation.ui.steps;

import co.digitalBankCucumberPractice.automation.ui.Models.CheckingAccountCard;
import co.digitalBankCucumberPractice.automation.ui.Models.CheckingTransactionMenu;
import co.digitalBankCucumberPractice.automation.ui.Models.NewCheckingData;
import co.digitalBankCucumberPractice.automation.ui.Pages.CreateNewCheckingPage;
import co.digitalBankCucumberPractice.automation.ui.Pages.LoginPage;
import co.digitalBankCucumberPractice.automation.ui.Pages.ViewCheckingAccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.openqa.selenium.WebDriver;

import co.digitalBankCucumberPractice.automation.ui.Utilities.Driver;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateCheckingAccountSteps {

    WebDriver driver = Driver.getDriver();

    private LoginPage loginPage = new LoginPage(driver);
    private CreateNewCheckingPage newCheckingPage = new CreateNewCheckingPage(driver);
    private ViewCheckingAccountPage viewCheckingAccountPage = new ViewCheckingAccountPage(driver);


    @Given("User is logged in credentials {string} and {string}")
    public void user_is_logged_in_credentials_and(String username, String password) {
        loginPage.navigateToLoginPage();
        loginPage.login(username, password);
    }

    @Given("creates a new individual checking account with the following data")
    public void createsANewIndividualCheckingAccountWithTheFollowingData(List<NewCheckingData> newCheckingDataExpected) {
        newCheckingPage.createNewCheckingAccount(newCheckingDataExpected);
    }


    @Then("User should see a green confirmation message saying {string}")
    public void user_should_see_a_green_confirmation_message_saying(String expectedMessage) {
        assertEquals(expectedMessage, viewCheckingAccountPage.getActualConfirmationMessage());
    }


    @Then("User should see the new checking account card")
    public void user_should_see_the_new_checking_account_card(List<CheckingAccountCard> checkingAccountCard) {

        Map<String, String> actualResultMap = viewCheckingAccountPage.getNewlyAddedAcountInfoMap();
        CheckingAccountCard expectedResult = checkingAccountCard.get(0);


        assertEquals(expectedResult.getAccountName(), actualResultMap.get("actualAccountName"));
        assertEquals("Account: " + expectedResult.getAccountType(), actualResultMap.get("actualAccountType"));
        assertEquals("Ownership: " + expectedResult.getOwnership(), actualResultMap.get("actualAccountOwner"));
        //assertEquals(expectedResult.getAccountNumber(), actualAccNumber); cannot validate number yt because it always changes
        assertEquals("Interest Rate: " + expectedResult.getInterestRate(), actualResultMap.get("actualAccountInterest"));
        assertEquals("Balance: $" + String.format("%.2f", expectedResult.getBalance()), actualResultMap.get("actualBalance"));


    }

    @Then("User should see the following Transaction menu")
    public void user_should_see_the_following_transaction_menu(List<CheckingTransactionMenu> checkingTransactionMenu) {
        Map<String, String> actualResultMap = viewCheckingAccountPage.getTransactionTableMap();
        CheckingTransactionMenu expected = checkingTransactionMenu.get(0);

        assertEquals(expected.getCategory(), actualResultMap.get("actualCategory"));
//        assertEquals(expected.getDescription().substring(expected.getDescription().lastIndexOf(("(DPT)"))), actualDescription);
        assertEquals(expected.getAmount(), Double.parseDouble(actualResultMap.get("actualAmount")));
        assertEquals(expected.getBalance(), Double.parseDouble(actualResultMap.get("actualBalance")));


    }


}



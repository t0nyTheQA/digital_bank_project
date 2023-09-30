package co.digitalBankCucumberPractice.automation.ui.steps;

import co.digitalBankCucumberPractice.automation.ui.Models.WithdrawInputData;
import co.digitalBankCucumberPractice.automation.ui.Pages.BaseMenuPage;
import co.digitalBankCucumberPractice.automation.ui.Pages.LoginPage;
import co.digitalBankCucumberPractice.automation.ui.Pages.Transactions_WithdrawPage;
import co.digitalBankCucumberPractice.automation.ui.Utilities.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static co.digitalBankCucumberPractice.automation.ui.Utilities.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class WithdrawFromAccountSteps  {

    WebDriver driver = getDriver();

    LoginPage lp = new LoginPage(driver);
    Transactions_WithdrawPage withdrawPage = new Transactions_WithdrawPage(driver);

    @Given("User is logged in with credentials {string} and {string}")
    public void user_is_logged_in_with_credentials_and(String username, String password) {
        lp.navigateToLoginPage();
        lp.login(username, password);
    }

    @Given("User is on the to Withdraw page")
    public void user_is_on_the_to_withdraw_page() {
        withdrawPage.goToWithdrawPage();
        assertEquals(ConfigReader.getPropertiesValue("dbankWithdrawFunctionPageURL"), getDriver().getCurrentUrl());
    }

    @When("user chooses an account and enters a withdraw amount and submits the withdrawal")
    public void user_chooses_an_account_and_enters_a_withdraw_amount_and_submits_the_withdrawal(List<WithdrawInputData> withdrawInputData) {
        withdrawPage.performWithdraw(withdrawInputData);
    }

    @Then("user should see the new balance and amount withdrew in the transaction table")
    public void user_should_see_the_new_balance_and_amount_withdrew_in_the_transaction_table() {

    }



}

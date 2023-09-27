package co.digitalBankCucumberPractice.automation.ui.steps;

import co.digitalBankCucumberPractice.automation.ui.Pages.HomePage;
import co.digitalBankCucumberPractice.automation.ui.Pages.LoginPage;
import co.digitalBankCucumberPractice.automation.ui.Pages.Transactions_DepositPage;
import co.digitalBankCucumberPractice.automation.ui.Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DepositIntoCheckingSteps {

    WebDriver driver = Driver.getDriver();

    HomePage hp = new HomePage(driver);
    LoginPage lp = new LoginPage(driver);
    Transactions_DepositPage depositPage = new Transactions_DepositPage(driver);

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        lp.navigateToLoginPage();
    }

    @Given("User successfully logs in with credentials {string} and {string}")
    public void user_successfully_logs_in_with_credentials_and(String username, String password) {
        lp.login(username, password);
        assertEquals("https://dbank-qa.wedevx.co/bank/home", driver.getCurrentUrl());
    }

    @When("User navigates to deposit page")
    public void user_navigates_to_deposit_page() {
        hp.getDepositButton().click();
    }

    @When("user selects checking {string} from dropdown")
    public void user_selects_checking_from_dropdown(String account) {
        depositPage.selectAccount(account);
    }

    @When("User enters a {string} amount")
    public void user_enters_a_amount(String amount) {
        depositPage.enterDepositAmount(amount);
    }

    @When("User clicks submit")
    public void user_clicks_submit() {depositPage.clickSubmit();
    }

    @Then("User should see updated Balance in the Account Card")
    public void user_should_see_updated_balance_in_the_account_card() {

    }

    @Then("User should see the updated deposit information in the transaction table")
    public void user_should_see_the_updated_deposit_information_in_the_transaction_table() {
        double balanceBeforeDeposit = depositPage.getInitialBalanceBeforeDeposit();
        double amountDeposited = depositPage.getNewestAmountDepositedFromTable();
        double newBalance = depositPage.getNewBalanceInTransaction();
        assertEquals(balanceBeforeDeposit + amountDeposited, newBalance);

    }

}

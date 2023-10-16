package co.digitalBankCucumberPractice.automation.ui.steps;

import co.digitalBankCucumberPractice.automation.ui.Pages.BaseMenuPage;
import co.digitalBankCucumberPractice.automation.ui.Pages.LoginPage;
import co.digitalBankCucumberPractice.automation.ui.Pages.Transactions_DepositPage;
import co.digitalBankCucumberPractice.automation.ui.Utilities.ConfigReader;
import co.digitalBankCucumberPractice.automation.ui.Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static co.digitalBankCucumberPractice.automation.ui.Utilities.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DepositIntoCheckingSteps {
    WebDriver driver = Driver.getDriver();
    LoginPage lp = new LoginPage(driver);
    Transactions_DepositPage depositPage = new Transactions_DepositPage(driver);

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        lp.navigateToLoginPage();
    }

    @Given("User successfully logs in with credentials {string} and {string}")
    public void user_successfully_logs_in_with_credentials_and(String username, String password) {
        lp.login(username, password);
        assertEquals(ConfigReader.getPropertiesValue("dBankHomePageURL"), getDriver().getCurrentUrl());
    }

    @When("User navigates to deposit page")
    public void user_navigates_to_deposit_page() {
        lp.goToDeposit();
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
    public void user_clicks_submit() {
        depositPage.clickSubmit();
    }


    @Then("User should see the updated deposit information in the transaction table")
    public void user_should_see_the_updated_deposit_information_in_the_transaction_table() {
        double balanceBeforeDeposit = depositPage.getInitialBalanceBeforeDeposit();
        System.out.println(balanceBeforeDeposit);
        double amountDeposited = depositPage.getNewestAmountDepositedFromTable();
        System.out.println(amountDeposited);
        double newBalance = depositPage.getNewBalanceInTransaction();
        System.out.println(newBalance);
        assertEquals(balanceBeforeDeposit + amountDeposited, newBalance, "Incorrect balance");

    }

}

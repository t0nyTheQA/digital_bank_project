package ui.steps;

import ui.Models.CheckingAccountCard;
import ui.Models.CheckingTransactionMenu;
import ui.Models.NewCheckingData;
import ui.Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.Utilities.Driver;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateCheckingAccountSteps {


   WebDriver driver = Driver.getDriver();
    private LoginPage loginPage = new LoginPage(driver);

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));


    @Given("User is on dBank main login page {string}")
    public void user_is_on_d_bank_main_login_page(String url) {

        driver.get(url);

    }

    @And("User enters userName {string} and password {string}")
    public void user_enters_user_name_and_password(String username, String password) {

        driver.get("https://dbank-qa.wedevx.co/bank/login");
        driver.manage().window().fullscreen();

        loginPage.login(username, password);  //this method is from LoginPage class in Pages

        //assert we are logged in
        String expectedUrl = "https://dbank-qa.wedevx.co/bank/home";
        assertEquals(expectedUrl, driver.getCurrentUrl(), "actual url does not match the expected url");
    }


    @Given("creates a new individual checking account with the following data")
    public void createsANewIndividualCheckingAccountWithTheFollowingData(List<NewCheckingData> newCheckingDataExpected) {

        NewCheckingData expected = newCheckingDataExpected.get(0);

        //click on checking button
        WebElement checkingAccountButton = driver.findElement(By.xpath("//div/ul/li[2]"));
        checkingAccountButton.click();

        //click on new checking account button
        WebElement newCheckingButton = driver.findElement(By.xpath("//a[text()='New Checking']"));
        newCheckingButton.click();

        String expectedUrl = "https://dbank-qa.wedevx.co/bank/account/checking-add";

        //make sure we are on create account page
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        assertEquals(expectedUrl, driver.getCurrentUrl());

        //select account type
        WebElement standardCheckingRadioBtn = driver.findElement(By.xpath("//input[@type = 'radio' and @id= 'Standard Checking']"));
        standardCheckingRadioBtn.click();
        assertTrue(standardCheckingRadioBtn.isSelected());

        //select ownership
        WebElement individualRadioBtn = driver.findElement(By.id("Individual"));
        individualRadioBtn.click();
        assertTrue(individualRadioBtn.isSelected());

        //enter checking account name
        WebElement accountNameTextBox = driver.findElement(By.id("name"));
        accountNameTextBox.sendKeys(expected.getAccountName());

        //enter initial deposit
        WebElement initialDepositTextBox = driver.findElement(By.id("openingBalance"));
        initialDepositTextBox.sendKeys(String.valueOf(expected.getDeposit()));

        //click on submit button
        WebElement sumbitBtn = driver.findElement(By.id("newCheckingSubmit"));
        sumbitBtn.click();

    }


    @Then("User should see a green confirmation message saying {string}")
    public void user_should_see_a_green_confirmation_message_saying(String expectedMessage) {

        WebElement confirmationMessage = driver.findElement(By.xpath("//div/span[contains(text(),'Successfully')]"));

        assertEquals(expectedMessage, confirmationMessage.getText());
        System.out.println(confirmationMessage.getText());
    }


    @Then("User should see the new checking account card")
    public void user_should_see_the_new_checking_account_card(List<CheckingAccountCard> checkingAccountCard) {
        List<WebElement> allCheckingCards = driver.findElements(By.xpath("//div[@id='firstRow']/div"));

        WebElement lastMadeCard = allCheckingCards.get(allCheckingCards.size() - 1);
        String fullCardText = lastMadeCard.getText();


        String actualAccName = fullCardText.substring(0, fullCardText.indexOf("Account")).trim();
        String actualAccType = fullCardText.substring(fullCardText.indexOf("Account"), fullCardText.indexOf("Ownership")).trim();
        String actualAccOwner = fullCardText.substring(fullCardText.indexOf("Ownership"), fullCardText.indexOf("Account Number")).trim();
        String actualAccNumber = fullCardText.substring(fullCardText.indexOf("Account Number"), fullCardText.indexOf("Interest")).trim();
        String actualAccInterest = fullCardText.substring(fullCardText.indexOf("Interest"), fullCardText.indexOf("Balance")).trim();
        String actualBalance = fullCardText.substring(fullCardText.indexOf("Balance"));


        CheckingAccountCard expectedResult = checkingAccountCard.get(0);


        assertEquals(expectedResult.getAccountName(), actualAccName);
        assertEquals("Account: " + expectedResult.getAccountType(), actualAccType);
        assertEquals("Ownership: " + expectedResult.getOwnership(), actualAccOwner);
        //assertEquals(expectedResult.getAccountNumber(), actualAccNumber); cannot validate number yt because it always changes
        assertEquals("Interest Rate: " + expectedResult.getInterestRate(), actualAccInterest);
        assertEquals("Balance: $" + String.format("%.2f", expectedResult.getBalance()), actualBalance);


    }

    @Then("User should see the following Transaction menu")
    public void user_should_see_the_following_transaction_menu(List<CheckingTransactionMenu> checkingTransactionMenu) {
        WebElement fullTransactionTable = driver.findElement(By.xpath("//table/tbody/tr"));

        List<WebElement> firstRow = fullTransactionTable.findElements(By.xpath("//td"));


        String actualCategory = firstRow.get(1).getText();
        String description = firstRow.get(2).getText();
        String actualDescription = description.substring(description.lastIndexOf("(DPT)")).trim();
        double actualAmount = Double.parseDouble(firstRow.get(3).getText().substring(1));
        double actualBalance = Double.parseDouble(firstRow.get(4).getText().substring(1));

        CheckingTransactionMenu expected = checkingTransactionMenu.get(0);

        assertEquals(expected.getCategory(), actualCategory);
        assertEquals(expected.getDescription().substring(expected.getDescription().lastIndexOf(("(DPT)"))), actualDescription);
        assertEquals(expected.getAmount(), actualAmount);
        assertEquals(expected.getBalance(), actualBalance);


    }


}



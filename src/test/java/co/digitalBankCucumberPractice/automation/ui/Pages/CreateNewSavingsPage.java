package co.digitalBankCucumberPractice.automation.ui.Pages;

import co.digitalBankCucumberPractice.automation.ui.Utilities.Driver;
import io.cucumber.java.de.Wenn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateNewSavingsPage {

    private WebDriver driver;

    @FindBy(id = "savings-menu")
    WebElement savingsSideButton;

    @FindBy(id = "new-savings-menu-item")
    WebElement newSavingAccountButton;

    @FindBy(id = "Savings")
    WebElement savingsAccountTypeRadioButton;

    @FindBy(id = "Money Market")
    WebElement moneyMarketAccountTypeRadioButton;

    @FindBy(id = "Individual")
    WebElement individualOwnershipRadio;

    @FindBy(id = "Joint")
    WebElement jointOwnershipRadio;

    @FindBy(id = "name")
    WebElement accountNameTextbox;

    @FindBy(id = "openingBalance")
    WebElement initialDepositTextbox;

    @FindBy(id = "newSavingsSubmit")
    WebElement submitButton;

    @FindBy(id = "newSavingsReset")
    WebElement resetButton;

    public CreateNewSavingsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //ACTION METHODS
    public void navigateToNewSavingsPage() {
        savingsSideButton.click();
        newSavingAccountButton.click();
    }

    public void createNewSaving_IndividualAccount(String accountName, String deposit) {
        savingsAccountTypeRadioButton.click();
        individualOwnershipRadio.click();
        accountNameTextbox.sendKeys(accountName);
        initialDepositTextbox.sendKeys(deposit);
        //submitButton.click();
    }














    //ELEMENT GETTERS BELOW
    public WebElement getSavingsSideButton() {
        return savingsSideButton;
    }

    public WebElement getNewSavingAccountButton() {
        return newSavingAccountButton;
    }

    public WebElement getSavingsAccountTypeRadioButton() {
        return savingsAccountTypeRadioButton;
    }

    public WebElement getMoneyMarketAccountTypeRadioButton() {
        return moneyMarketAccountTypeRadioButton;
    }

    public WebElement getIndividualOwnershipRadio() {
        return individualOwnershipRadio;
    }

    public WebElement getJointOwnershipRadio() {
        return jointOwnershipRadio;
    }

    public WebElement getAccountNameTextbox() {
        return accountNameTextbox;
    }

    public WebElement getInitialDepositTextbox() {
        return initialDepositTextbox;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getResetButton() {
        return resetButton;
    }
}





package co.digitalBankCucumberPractice.automation.ui.Pages;

import co.digitalBankCucumberPractice.automation.ui.Utilities.BrowserHelper;
import co.digitalBankCucumberPractice.automation.ui.Utilities.Driver;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.cucumber.java.de.Wenn;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static co.digitalBankCucumberPractice.automation.ui.Utilities.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateNewSavingsPage extends BaseMenuPage {


    public CreateNewSavingsPage(WebDriver driver) {
       super(driver);
    }




    @FindBy(id = "savings-menu")
    WebElement savingsSideButton;

    @FindBy(id = "new-savings-menu-item")
    WebElement newSavingAccountButton;

    @FindBy(id = "Savings")
    WebElement savingsAccountTypeRadioButton;

    @FindBy(id = "Money Market")
    WebElement moneyMarketAccountTypeRadioButton;

    @FindBy(xpath = "//input[@id='Individual']")
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

    @FindBy(id = "new-account-msg")
    WebElement newSavingAccountConfirmationMessage;


    //ACTION METHODS
    public void navigateToNewSavingsPage() {
      getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        savingsMenuButton.click();
        newSavingAccountButton.click();
    }

    public void createNewSaving_IndividualAccount(String accountName, String deposit) {
        savingsAccountTypeRadioButton.click();
        individualOwnershipRadio.click();

        accountNameTextbox.sendKeys(accountName);
        initialDepositTextbox.sendKeys(deposit);
    }

    public void clickSubmit() {
        submitButton.click();
    }


    public String getLastMadeSavingsCardText() {
        List<WebElement> listOfCards = getDriver().findElements(By.xpath("//div[@id='firstRow']/div"));
        WebElement lastCard = listOfCards.get(listOfCards.size()-1);
         return lastCard.getText();
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

    public WebElement getNewSavingAccountConfirmationMessage() {
        return newSavingAccountConfirmationMessage;
    }

}





package co.digitalBankCucumberPractice.automation.ui.Pages;

import co.digitalBankCucumberPractice.automation.ui.Models.NewCheckingData;
import co.digitalBankCucumberPractice.automation.ui.Utilities.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static co.digitalBankCucumberPractice.automation.ui.Utilities.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CreateNewCheckingPage extends BaseMenuPage {

    public CreateNewCheckingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type = 'radio' and @id= 'Standard Checking']")
    WebElement standardCheckingRadioBtn;

    @FindBy(id = "Interest Checking")
    WebElement interestChecking;

    @FindBy(id = "Individual")
    WebElement individualOwnershipRadioBtn;

    @FindBy(id = "Joint")
    WebElement jointOwnershipRadioBtn;

    @FindBy(id = "name")
    WebElement accountNameTextBox;

    @FindBy(id = "openingBalance")
    WebElement initialDepositTextBox;

    @FindBy(id = "newCheckingSubmit")
    WebElement submitBtn;




    public void createNewCheckingAccount(List<NewCheckingData> newCheckingDataExpected) {
        NewCheckingData testDataForChecking = newCheckingDataExpected.get(0);
        checkingMenuButton.click();
        newCheckingButton.click();
        assertEquals(ConfigReader.getPropertiesValue("dBankNewCheckingPageURL"), getDriver().getCurrentUrl());

        if(testDataForChecking.getAccountType().equalsIgnoreCase("Standard Checking")){
            standardCheckingRadioBtn.click();
        } else if (testDataForChecking.getAccountType().equalsIgnoreCase("Interest Checking")){
            interestChecking.click();
        } else throw new NoSuchElementException("Invalid account type");

        if(testDataForChecking.getOwnership().equalsIgnoreCase("Individual")){
            individualOwnershipRadioBtn.click();
        } else if (testDataForChecking.getOwnership().equalsIgnoreCase("Joint")){
            jointOwnershipRadioBtn.click();
        } else throw new NoSuchElementException("Invalid ownership type");

        accountNameTextBox.sendKeys(testDataForChecking.getAccountName());
        initialDepositTextBox.sendKeys(String.valueOf(testDataForChecking.getDeposit()));
        submitBtn.click();
    }






}

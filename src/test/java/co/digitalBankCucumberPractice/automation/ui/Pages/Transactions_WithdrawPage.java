package co.digitalBankCucumberPractice.automation.ui.Pages;

import co.digitalBankCucumberPractice.automation.ui.Models.WithdrawInputData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Transactions_WithdrawPage extends BaseMenuPage {

    public Transactions_WithdrawPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//select")
    WebElement chooseAccountDropdown;

    @FindBy(id = "amount")
    WebElement withdrawAmountTextBox;

    @FindBy(xpath = "//div[@class = 'card-footer']/button[@type='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//div[@class = 'card-footer']/button[@type='reset']")
    WebElement resetButton;

    public void performWithdraw(String accountName, String deposit) {
        Select select = new Select(chooseAccountDropdown);
        select.selectByVisibleText(accountName);
        withdrawAmountTextBox.sendKeys(String.valueOf(deposit));
        submitButton.click();
    }

    public void goToWithdrawPage(){
        withdrawButton.click();
    }

    public void resetWithdraw() {
        resetButton.click();
    }
}

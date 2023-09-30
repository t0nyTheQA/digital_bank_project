package co.digitalBankCucumberPractice.automation.ui.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static co.digitalBankCucumberPractice.automation.ui.Utilities.Driver.getDriver;

public class Transactions_DepositPage extends BaseMenuPage {


    public Transactions_DepositPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "selectedAccount")
    WebElement selectAccountForDeposit;

    @FindBy(xpath = "//input[@name ='amount']")
    WebElement depositAmountTextBox;

    @FindBy(xpath = "//button[text() =' Submit']")
    WebElement submitButton;

    @FindBy(xpath = "//button[text() =' Reset']")
    WebElement resetButton;

    @FindBy(xpath = "//table/tbody/tr")
    WebElement entireTransactionTable;


    public void selectAccount(String account) {
        Select select = new Select(selectAccountForDeposit);
        select.selectByVisibleText(account);
    }

    public void enterDepositAmount(String amount) {
        depositAmountTextBox.sendKeys(amount);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public void clickReset() {
        resetButton.click();
    }

    public double getNewestAmountDepositedFromTable() {
        List<WebElement> transactions = getDriver().findElements(By.xpath("//table/tbody/tr"));
        WebElement transaction = transactions.get(1);


        double newestDepositAmount = Double.parseDouble(transaction.findElement(By.xpath("//table/tbody/tr/td[4]")).getText().replace("$",""));
        return newestDepositAmount;
    }

    public double getNewBalanceInTransaction() {
        List<WebElement> transactions = getDriver().findElements(By.xpath("//table/tbody/tr"));
        WebElement transaction = transactions.get(1);

        double newBalanceAfterDeposit = Double.parseDouble(transaction.findElement(By.xpath("//table/tbody/tr/td[5]")).getText().replace("$",""));
        return newBalanceAfterDeposit;
    }


    public double getInitialBalanceBeforeDeposit() {
        WebElement transaction2 = getDriver().findElement(By.xpath("//table/tbody/tr[2]"));


        double initialBalance = Double.parseDouble(transaction2.findElement(By.xpath("//table/tbody/tr[2]/td[5]")).getText().replace("$",""));
        return initialBalance;
    }

}

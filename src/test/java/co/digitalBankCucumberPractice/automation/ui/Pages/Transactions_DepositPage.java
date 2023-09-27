package co.digitalBankCucumberPractice.automation.ui.Pages;

import co.digitalBankCucumberPractice.automation.ui.Models.CheckingAccountCard;
import co.digitalBankCucumberPractice.automation.ui.Models.CheckingTransactionMenu;
import io.cucumber.java.eo.Do;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Transactions_DepositPage extends HomePage {

    private WebDriver driver;

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
        List<WebElement> transactions = driver.findElements(By.xpath("//table/tbody/tr"));
        WebElement transaction = transactions.get(1);


        double newestDepositAmount = Double.parseDouble(transaction.findElement(By.xpath("/td[4]")).getText());
        return newestDepositAmount;
    }

    public double getNewBalanceInTransaction() {
        List<WebElement> transactions = driver.findElements(By.xpath("//table/tbody/tr"));
        WebElement transaction = transactions.get(1);

        double newBalanceAfterDeposit = Double.parseDouble(transaction.findElement(By.xpath("/td[5]")).getText());
        return newBalanceAfterDeposit;
    }


    public double getInitialBalanceBeforeDeposit() {
        List<WebElement> transactions = driver.findElements(By.xpath("//table/tbody/tr"));
        WebElement transaction = transactions.get(2);

        double initialBalance = Double.parseDouble(transaction.findElement(By.xpath("/td[5]")).getText());
        return initialBalance;
    }

}

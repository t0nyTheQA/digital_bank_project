package co.digitalBankCucumberPractice.automation.ui.Pages;

import co.digitalBankCucumberPractice.automation.ui.Models.CheckingAccountCard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewCheckingAccountPage extends BaseMenuPage {

    public ViewCheckingAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div/span[contains(text(),'Successfully')]")
    WebElement newAccountConfirmationMessage;

    @FindBy (xpath = "//div[@id='firstRow']/div")
    List<WebElement> allCheckingCards;

    @FindBy(xpath ="//table/tbody/tr" )
    WebElement fullTransactionTable;


    public String getActualConfirmationMessage(){
        return newAccountConfirmationMessage.getText();

    }

    public Map<String, String> getNewlyAddedAcountInfoMap(){
        WebElement lastMadeCard = allCheckingCards.get(allCheckingCards.size()-1);
        String fullCardText = lastMadeCard.getText();

        HashMap<String, String> actualResultAccountCard = new HashMap<>();
        actualResultAccountCard.put("actualAccountName",fullCardText.substring(0, fullCardText.indexOf("Account")).trim());
        actualResultAccountCard.put("actualAccountType",  fullCardText.substring(fullCardText.indexOf("Account"), fullCardText.indexOf("Ownership")).trim());
        actualResultAccountCard.put("actualAccountOwner",fullCardText.substring(fullCardText.indexOf("Ownership"), fullCardText.indexOf("Account Number")).trim());
        actualResultAccountCard.put("actualAccountNumber", fullCardText.substring(fullCardText.indexOf("Account Number"), fullCardText.indexOf("Interest")).trim());
        actualResultAccountCard.put("actualAccountInterest", fullCardText.substring(fullCardText.indexOf("Interest"), fullCardText.indexOf("Balance")).trim());
        actualResultAccountCard.put("actualBalance",  fullCardText.substring(fullCardText.indexOf("Balance")));

        return actualResultAccountCard;
    }

    public Map<String, String> getTransactionTableMap(){
        List<WebElement> firstRow = fullTransactionTable.findElements(By.xpath("//td"));

        Map<String,String> actualResultMap = new HashMap<>();
        actualResultMap.put("actualCategory", firstRow.get(1).getText());
        actualResultMap.put("actualDescription",firstRow.get(2).getText());
        actualResultMap.put("actualAmount", firstRow.get(3).getText().substring(1));
        actualResultMap.put("actualBalance", firstRow.get(4).getText().substring(1));

        return actualResultMap;
    }
}












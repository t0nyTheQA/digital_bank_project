package co.digitalBankCucumberPractice.automation.ui.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class RegistrationPage2 extends BaseMenuPage {

    public RegistrationPage2(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type = 'C']")
    WebElement addressTextBox;

    @FindBy(xpath = "//input[@name= 'locality']")
    WebElement localityTextBox;

    @FindBy(xpath = "//input[@name= 'region']")
    WebElement regionTextBox;

    @FindBy(xpath = "//input[@name= 'postalCode']")
    WebElement postalCodeTextBox;

    @FindBy(xpath = "//input[@name= 'country']")
    WebElement countryTextBox;

    @FindBy(id = "homePhone")
    WebElement homePhoneTextBox;

    @FindBy(id = "mobilePhone")
    WebElement mobilePhoneTextBox;

    @FindBy(id = "workPhone")
    WebElement workPhoneTextBox;

    @FindBy(xpath = "//input[@name= 'agree-terms']")
    WebElement agreeToTermsCheckBox;

    @FindBy(xpath = "//button[text()='Register']")
    WebElement registerButton;


    public void fillOutRegistrationPage2(List<Map<String, String>> registrationDataList){
        Map<String,String> registerData = registrationDataList.get(0);
        addressTextBox.sendKeys(registerData.get("address"));
        localityTextBox.sendKeys(registerData.get("locality"));
        regionTextBox.sendKeys(registerData.get("region"));
        postalCodeTextBox.sendKeys(registerData.get("postalCode"));
        countryTextBox.sendKeys(registerData.get("country"));
        mobilePhoneTextBox.sendKeys(registerData.get("mobilePhone"));
        agreeToTermsCheckBox.click();
        registerButton.click();
    }



}

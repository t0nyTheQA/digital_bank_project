package co.digitalBankCucumberPractice.automation.ui.Pages;

import co.digitalBankCucumberPractice.automation.ui.Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static co.digitalBankCucumberPractice.automation.ui.Utilities.Driver.getDriver;

public class RegistrationPage2 extends BaseMenuPage {

    public RegistrationPage2(WebDriver driver) {
        super(driver);
    }

    public WebElement getAddressTextBox() {
        return addressTextBox;
    }

    @FindBy(xpath = "//input[@name= 'address']")
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
    protected WebElement registerButton;

    @FindBy(xpath = "//span[text() = 'Registration Successful. Please Login.']")
    WebElement confirmationMessage;


    public void fillOutRegistrationPage2(List<Map<String, String>> registrationDataList) {
        Map<String, String> registerData = registrationDataList.get(0);
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        if (addressTextBox.isDisplayed()) {

            if (registerData.get("address") != null) {
                addressTextBox.sendKeys(registerData.get("address"));
            }
            if (registerData.get("locality") != null) {
                localityTextBox.sendKeys(registerData.get("locality"));
            }
            if (registerData.get("region") != null) {
                regionTextBox.sendKeys(registerData.get("region"));
            }
            if (registerData.get("postalCode") != null) {
                postalCodeTextBox.sendKeys(registerData.get("postalCode"));
            }
            if (registerData.get("country") != null) {
                countryTextBox.sendKeys(registerData.get("country"));
            }
            if (registerData.get("mobilePhone") != null) {
                homePhoneTextBox.sendKeys(registerData.get("mobilePhone"));
            }
            if (registerData.get("mobilePhone") != null) {
                mobilePhoneTextBox.sendKeys(registerData.get("mobilePhone"));
            }
            if (registerData.get("termsCheckBox") != null) {
                if (registerData.get("termsCheckBox").equalsIgnoreCase("true")) {
                    agreeToTermsCheckBox.click();
                }
            }
            registerButton.click();
        }
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }


    public String getRequiredFieldErrorMessage(String fieldName) {

        if (addressTextBox.isDisplayed()) {
            switch (fieldName.toLowerCase()) {
                case "address":
                    return addressTextBox.getAttribute("validationMessage");
                case "locality":
                    return localityTextBox.getAttribute("validationMessage");
                case "region":
                    return regionTextBox.getAttribute("validationMessage");
                case "postalcode":
                    return postalCodeTextBox.getAttribute("validationMessage");
                case "country":
                    return countryTextBox.getAttribute("validationMessage");
                case "mobilephone":
                    return homePhoneTextBox.getAttribute("validationMessage");
                case "termscheckbox":
                    return agreeToTermsCheckBox.getAttribute("validationMessage");

            }
            return "Incorrect page 2";
        }
        return null;
    }


}

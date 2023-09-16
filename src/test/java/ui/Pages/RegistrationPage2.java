package ui.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage2 {

    private WebDriver driver;

    public RegistrationPage2(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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



}

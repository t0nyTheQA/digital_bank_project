package co.digitalBankCucumberPractice.automation.ui.Pages;

import co.digitalBankCucumberPractice.automation.ui.Utilities.MockData;
import io.cucumber.java.it.Ma;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class RegistrationPage1 extends BaseMenuPage {

    public RegistrationPage1(WebDriver driver) {
        super(driver);
    }
    MockData mockData = new MockData();

    @FindBy(xpath = "//img[@src ='images/logo.png']")
    WebElement digitalBankRegistrationHomeButton;


    @FindBy(xpath = "//select[@name='title']")
    WebElement titleSelector;

    @FindBy(xpath = "//input[@name = 'firstName']")
    WebElement firstNameTextBox;

    @FindBy(xpath = "//input[@name = 'lastName']")
    WebElement lastNameTextBox;

    @FindBy(xpath = "//input[@type='radio' and @value='M'] ")
    WebElement maleRadioButton;

    @FindBy(xpath = "//input[@value='F']")
    WebElement femaleRadioButton;

    @FindBy(xpath = "//input[@name = 'dob']")
    WebElement DobTextBox;

    @FindBy(xpath = "//input[@name='ssn'")
    WebElement SsnTextBox;

    @FindBy(xpath = "//input [@type='email' and @name ='emailAddress']")
    WebElement emailAddressTextBox;

    @FindBy(id = "password")
    WebElement passwordTextBox;

    @FindBy(id = "confirmPassword")
    WebElement confirmPasswordTextBox;

    @FindBy(xpath = "//a[@href='/bank/login']")
    WebElement signInLinkIfAccountExists;

    @FindBy(xpath = "//button[@type ='submit']")
    WebElement nextButton;


    //action methods

    public void fillOutRegistrationPage1(List<Map<String, String>> registrationDataList) {
        Map<String, String> registerData = registrationDataList.get(0);

        Select select = new Select(titleSelector);
        select.selectByVisibleText(registerData.get("title"));
        firstNameTextBox.sendKeys(registerData.get("firstName"));
        lastNameTextBox.sendKeys(registerData.get("lastName"));


        switch (registerData.get("gender")) {
            case "M", "m" -> maleRadioButton.click();
            case "F", "f" -> femaleRadioButton.click();
            default -> throw new NoSuchElementException("Invalid gender chosen");
        }

        DobTextBox.sendKeys(registerData.get("dateOfBirth"));
        SsnTextBox.sendKeys(mockData.generateRandomSSN());
        emailAddressTextBox.sendKeys(mockData.generateRandomEmail());
        passwordTextBox.sendKeys(registerData.get("password"));
        confirmPasswordTextBox.sendKeys(registerData.get("confirmPassword"));
        nextButton.click();
    }
}

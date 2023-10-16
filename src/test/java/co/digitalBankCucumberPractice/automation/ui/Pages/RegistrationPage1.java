package co.digitalBankCucumberPractice.automation.ui.Pages;

import co.digitalBankCucumberPractice.automation.ui.Utilities.Driver;
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

import static co.digitalBankCucumberPractice.automation.ui.Utilities.Driver.getDriver;

public class RegistrationPage1 extends BaseMenuPage {

    public RegistrationPage1(WebDriver driver) {
        super(driver);
    }


    MockData mockData = new MockData();

    @FindBy(xpath = "//img[@src ='images/logo.png']")
    WebElement digitalBankRegistrationHomeButton;


    public WebElement getTitleSelector() {
        return titleSelector;
    }


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

    @FindBy(xpath = "//input[@name='ssn']")
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
        if (registerData.get("title") != null) {
            select.selectByVisibleText(registerData.get("title"));
        }

        if (registerData.get("firstName") != null) {
            firstNameTextBox.sendKeys(registerData.get("firstName"));
        }
        if (registerData.get("lastName") != null) {
            lastNameTextBox.sendKeys(registerData.get("lastName"));
        }
        if (registerData.get("gender") != null) {
            switch (registerData.get("gender")) {
                case "M":
                case "m" :
                    maleRadioButton.click();
                    break;
                case "F":
                case "f":
                    femaleRadioButton.click();
                    break;
                default:
                    throw new NoSuchElementException("Invalid gender chosen");
            }
        }
        if (registerData.get("dateOfBirth") != null) {
            DobTextBox.sendKeys(registerData.get("dateOfBirth"));
        }

        if (registerData.get("ssn") != null) {
           if (registerData.get("ssn").equalsIgnoreCase("mock")) {
               SsnTextBox.sendKeys(mockData.generateRandomSSN());
           }else SsnTextBox.sendKeys(registerData.get("ssn"));
        }

        if (registerData.get("email") != null) {
            if(registerData.get("email").equalsIgnoreCase("mock")){
                emailAddressTextBox.sendKeys(mockData.generateRandomEmail());
            }else emailAddressTextBox.sendKeys(registerData.get("email"));
        }

        if (registerData.get("password") != null) {
            passwordTextBox.sendKeys(registerData.get("password"));
        }

        if (registerData.get("confirmPassword") != null) {
            confirmPasswordTextBox.sendKeys(registerData.get("confirmPassword"));
        }
        nextButton.click();
    }


    public String getRequiredFieldErrorMessage(String fieldName) {
        RegistrationPage2 registrationPage2 = new RegistrationPage2(getDriver());


        switch (fieldName.toLowerCase()) {
            case "title":
                return titleSelector.getAttribute("validationMessage");
            case "firstname":
                return firstNameTextBox.getAttribute("validationMessage");
            case "lastname":
                return lastNameTextBox.getAttribute("validationMessage");
            case "gender":
                return maleRadioButton.getAttribute("validationMessage");
            case "dateofbirth":
                return DobTextBox.getAttribute("validationMessage");
            case "ssn":
                return SsnTextBox.getAttribute("validationMessage");
            case "email":
                return emailAddressTextBox.getAttribute("validationMessage");
            case "password":
                return passwordTextBox.getAttribute("validationMessage");
            case "confirmpassword":
                return confirmPasswordTextBox.getAttribute("validationMessage");


        }
        return "incorrect page 1";
    }
}

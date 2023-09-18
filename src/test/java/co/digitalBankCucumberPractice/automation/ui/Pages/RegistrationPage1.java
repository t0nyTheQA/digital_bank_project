package co.digitalBankCucumberPractice.automation.ui.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage1 {

    private WebDriver driver;

    public RegistrationPage1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


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
    public void fillOutRegistration(String firstName, String lastName){
        Select select = new Select(titleSelector);


    }
}

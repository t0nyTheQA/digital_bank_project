package ui.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@src='/bank/images/logo.png']")
    WebElement digitalBanksSignInHomeButton;

    @FindBy(xpath = "//form/div[1]/label")
    WebElement userNameTitle;

    @FindBy(xpath = "//form/div[2]/label")
    WebElement passwordTitle;

    @FindBy(xpath = "//input[@name = 'username']")
    WebElement usernameTextBox;

    @FindBy(xpath = "//input[@name = 'password']")
    WebElement passwordTextBox;

    @FindBy(xpath = "//input[@name = 'remember-me']")
    WebElement rememberMeCheckBox;

    @FindBy(xpath = "//button[@type = 'submit']")
    WebElement signInButton;

    @FindBy(xpath = "//a[@href='/bank/signup']")
    WebElement signUpHereLink;


    //create action methods

    public void login(String username, String password){
        usernameTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);

        signInButton.click();
    }

    public void clickToSignUp(){
        signUpHereLink.click();
    }

}

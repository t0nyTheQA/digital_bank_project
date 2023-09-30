package co.digitalBankCucumberPractice.automation.ui.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaseMenuPage extends BasePage {



    public BaseMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "home-menu-item")
    protected WebElement homeMenuButton;

    @FindBy(id = "menuToggle")
    protected WebElement sideMenuToggle;

    @FindBy(id = "checking-menu")
    protected WebElement checkingMenuButton;

    //checking menu options
    @FindBy(id = "view-checking-menu-item")
    protected WebElement viewCheckingButton;
    @FindBy(id = "new-checking-menu-item")
    protected WebElement newCheckingButton;

    @FindBy(id = "savings-menu")
    protected WebElement savingsMenuButton;

    //saving menu options
    @FindBy(id = "view-savings-menu-item")
    protected WebElement viewSavingsButton;
    @FindBy(id = "new-savings-menu-item")
    protected WebElement newSavingsButton;

    @FindBy(id = "external-accounts-menu")
    protected WebElement externalAccountsButton;

    //external menu options
    @FindBy(id = "link-external-menu-item")
    protected WebElement linkExternalAccountButton;
    @FindBy(id = "view-external-menu-item")
    protected WebElement viewExternalAccountsButton;

    @FindBy(id = "deposit-menu-item")
    protected WebElement depositButton;

    @FindBy(id = "withdraw-menu-item")
    protected WebElement withdrawButton;

    @FindBy(id = "transfer-menu-item")
    protected WebElement transferBetweenAccountButton;

    @FindBy(id = "visa-transfer-menu-item")
    protected WebElement visaDirectTransferButton;

    @FindBy(xpath = "//button[@class='search-trigger']")
    protected WebElement searchAtmButton;

    @FindBy(id = "notification")
    protected WebElement notificationsButton;

    @FindBy(id = "message")
    protected WebElement messagesButton;

    @FindBy(xpath = "//a[@class='user-avatar rounded-circle']")
    protected WebElement websiteInfoButton;

    @FindBy(xpath = "//div[@class='user-area dropdown']//img")
    protected WebElement profileDropDownMenuButton;

    //Profile drop down menu OPTIONS
    @FindBy(xpath = "//div[@class ='user-menu dropdown-menu show']/a[1]")
    protected WebElement myProfileSettingsButton;

    protected @FindBy(xpath = "//div[@class ='user-menu dropdown-menu show']/a[2]")
    WebElement changePasswordSettingButton;

    @FindBy(xpath = "//div[@class ='user-menu dropdown-menu show']/a[3]")
    protected WebElement logoutButton;

    public void goToDeposit(){
        depositButton.click();
    }



}

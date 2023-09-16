package ui.Pages;

import io.cucumber.java.zh_cn.假如;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "home-menu-item")
    WebElement homeMenuButton;

    @FindBy(id = "menuToggle")
    WebElement sideMenuToggle;

    @FindBy(id = "checking-menu")
    WebElement checkingMenuButton;

    //checking menu options
    @FindBy(id = "view-checking-menu-item")
    WebElement viewCheckingButton;
    @FindBy(id = "new-checking-menu-item")
    WebElement newCheckingButton;

    @FindBy(id = "savings-menu")
    WebElement savingsMenuButton;

    //saving menu options
    @FindBy(id = "view-savings-menu-item")
    WebElement viewSavingsButton;
    @FindBy(id = "new-savings-menu-item")
    WebElement newSavingsButton;

    @FindBy(id = "external-accounts-menu")
    WebElement externalAccountsButton;

    //external menu options
    @FindBy(id = "link-external-menu-item")
    WebElement linkExternalAccountButton;
    @FindBy(id = "view-external-menu-item")
    WebElement viewExternalAccountsButton;

    @FindBy(id = "deposit-menu-item")
    WebElement depositButton;

    @FindBy(id = "withdraw-menu-item")
    WebElement withdrawButton;

    @FindBy(id = "transfer-menu-item")
    WebElement transferBetweenAccountButton;

    @FindBy(id = "visa-transfer-menu-item")
    WebElement visaDirectTransferButton;

    @FindBy(xpath = "//button[@class='search-trigger']")
    WebElement searchAtmButton;

    @FindBy(id = "notification")
    WebElement notificationsButton;

    @FindBy(id = "message")
    WebElement messagesButton;

    @FindBy(xpath = "//a[@class='user-avatar rounded-circle']")
    WebElement websiteInfoButton;

    @FindBy(xpath = "//div[@class='user-area dropdown']//img")
    WebElement profileDropDownMenuButton;

    //Profile drop down menu OPTIONS
    @FindBy(xpath = "//div[@class ='user-menu dropdown-menu show']/a[1]")
    WebElement myProfileSettingsButton;

    @FindBy(xpath = "//div[@class ='user-menu dropdown-menu show']/a[2]")
    WebElement changePasswordSettingButton;

    @FindBy(xpath = "//div[@class ='user-menu dropdown-menu show']/a[3]")
    WebElement logoutButton;

}

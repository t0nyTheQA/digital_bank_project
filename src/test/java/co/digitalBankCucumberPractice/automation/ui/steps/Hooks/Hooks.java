package co.digitalBankCucumberPractice.automation.ui.steps.Hooks;

import co.digitalBankCucumberPractice.automation.ui.Pages.BaseMenuPage;
import co.digitalBankCucumberPractice.automation.ui.Utilities.ConfigReader;
import co.digitalBankCucumberPractice.automation.ui.Utilities.DBUtils;
import io.cucumber.java.*;
import co.digitalBankCucumberPractice.automation.ui.Utilities.Driver;

import javax.xml.bind.Element;
import java.util.NoSuchElementException;
import java.util.Objects;

import static co.digitalBankCucumberPractice.automation.ui.Utilities.Driver.getDriver;

public class Hooks {
    BaseMenuPage bpm = new BaseMenuPage(getDriver());
    @Before
    public  void establishDatabaseConnection(){
        DBUtils.establishConnection();
        System.out.println("Connection to Database completed.");
    }



    @After ("not @negativeExamples and @registration")
    public void tearDown(Scenario scenario){
        Driver.takeScreenShot(scenario);

        try {
            bpm.logout();
        } catch (Exception e){
            System.out.println("no need to logout");
        }finally {
            Driver.closeDriver();
        }
        System.out.println("take screenshot, logout and close driver");
    }

    @After
    public static void closeDatabaseConnection(){
        DBUtils.closeConnection();
        System.out.println("Connection to Database has been closed");
    }




}

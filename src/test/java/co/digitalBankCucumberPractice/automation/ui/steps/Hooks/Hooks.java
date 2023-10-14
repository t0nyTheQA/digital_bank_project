package co.digitalBankCucumberPractice.automation.ui.steps.Hooks;

import co.digitalBankCucumberPractice.automation.ui.Utilities.DBUtils;
import io.cucumber.java.*;
import co.digitalBankCucumberPractice.automation.ui.Utilities.Driver;

public class Hooks {

    @Before
    public  void establishDatabaseConnection(){
        DBUtils.establishConnection();
        System.out.println("Connection to Database completed.");
    }

    @After ("not @negativeExamples")
    public void tearDown(Scenario scenario){
        Driver.takeScreenShot(scenario);
        Driver.closeDriver();
    }

    @After
    public static void closeDatabaseConnection(){
        DBUtils.closeConnection();
        System.out.println("Connection to Database has been closed");
    }


}

package co.digitalBankCucumberPractice.automation.ui.steps.Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import co.digitalBankCucumberPractice.automation.ui.Utilities.Driver;

public class Hooks {

    @After
    public void tearDown(Scenario scenario){
        Driver.takeScreenShot(scenario);
        Driver.closeDriver();
    }
}

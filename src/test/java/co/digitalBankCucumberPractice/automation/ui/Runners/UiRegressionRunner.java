package co.digitalBankCucumberPractice.automation.ui.Runners;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("ui.features")
@ConfigurationParameter(key=GLUE_PROPERTY_NAME, value = "ui.steps")
@ExcludeTags("ignore")

public class UiRegressionRunner {

}

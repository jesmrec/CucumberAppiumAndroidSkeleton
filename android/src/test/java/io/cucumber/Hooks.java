package io.cucumber;

import java.util.logging.Level;

import io.android.AppiumManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.log.Log;

public class Hooks {

    @Before
    public void setup(Scenario scenario) {
        Log.log(Level.FINE, "START SCENARIO EXECUTION: " + scenario.getName());
        AppiumManager.getManager().getDriver().launchApp();
    }

    @After
    public void tearDown(Scenario scenario) {
        AppiumManager.getManager().getDriver().closeApp();
        Log.log(Level.FINE, "END SCENARIO EXECUTION: " + scenario.getName() + "\n\n");
    }
}

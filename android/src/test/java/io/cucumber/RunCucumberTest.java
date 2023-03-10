package io.cucumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.util.logging.Level;

import io.android.AppiumManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utils.LocProperties;
import utils.log.Log;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"})
public class RunCucumberTest {

    @BeforeClass
    public static void beforeclass() {
        Log.init();
        Log.log(Level.FINE, "START EXECUTION\n");
    }

    @AfterClass
    public static void afterclass() {
        AppiumManager.getManager().getDriver().removeApp(LocProperties.getProperties().getProperty("appPackage"));
        AppiumManager.getManager().getDriver().quit();
        Log.log(Level.FINE, "END EXECUTION\n");
    }
}

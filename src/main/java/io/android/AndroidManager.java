package io.android;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.logging.Level;

import io.appium.java_client.android.AndroidDriver;
import utils.LocProperties;
import utils.log.Log;

public class AndroidManager {

    private static AndroidDriver driver = null;
    private static File app;
    private static final String driverURL = LocProperties.getProperties().getProperty("appiumURL");
    private static final String appPackage = LocProperties.getProperties().getProperty("appPackage");
    private static final String automationName = "uiautomator2";

    private AndroidManager() {
    }

    private static void init() {

        File rootPath = new File(System.getProperty("user.dir"));
        File appDir = new File(rootPath, "src/test/resources");
        app = new File(appDir, LocProperties.getProperties().getProperty("apkName"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        setCapabilities(capabilities);

        try {
            driver = new AndroidDriver(new URL(driverURL), capabilities);
        } catch (MalformedURLException e) {
            Log.log(Level.SEVERE, "Driver could not be created: " + e.getMessage());
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Log.log(Level.FINE, "Device: " +
                driver.getCapabilities().getCapability("deviceManufacturer") + " " +
                driver.getCapabilities().getCapability("deviceModel"));
        Log.log(Level.FINE, "Platform: " +
                driver.getCapabilities().getCapability("platformName") + " " +
                driver.getCapabilities().getCapability("platformVersion"));
        Log.log(Level.FINE, "API Level: " +
                driver.getCapabilities().getCapability("deviceApiLevel") + "\n");

    }

    //Singletonize
    public static AndroidDriver getDriver() {
        if (driver == null) {
            init();
        }
        return driver;
    }

    //Check https://appium.io/docs/en/2.5/guides/caps/
    private static void setCapabilities(DesiredCapabilities capabilities) {

        capabilities.setCapability("appium:platformName", "Android");

        capabilities.setCapability("appium:deviceName", "test");

        capabilities.setCapability("appium:app", app.getAbsolutePath());

        capabilities.setCapability("appium:automationName", automationName);

        capabilities.setCapability("appium:appWaitPackage", appPackage);

        capabilities.setCapability("appium:uiautomator2ServerInstallTimeout", 60000);

        capabilities.setCapability("appium:disableWindowAnimation", true);

        capabilities.setCapability("appium:fullReset", true);

    }
}

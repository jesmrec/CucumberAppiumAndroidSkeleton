package io.android;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import utils.LocProperties;
import utils.log.Log;

public class AppiumManager {

    private static AppiumManager appiumManager;
    private static AndroidDriver driver;
    private static final String driverURL = LocProperties.getProperties().getProperty("appiumURL");
    private static File app;

    private AppiumManager() {
        init();
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

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

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
    public static AppiumManager getManager() {
        if (appiumManager == null) {
            appiumManager = new AppiumManager();
        }
        return appiumManager;
    }

    public AndroidDriver getDriver() {
        return driver;
    }

    //Check https://appium.io/docs/en/writing-running-appium/caps/
    private static void setCapabilities(DesiredCapabilities capabilities){

        capabilities.setCapability("appium:platformName", "Android");

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "test");

        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        capabilities.setCapability("appium:automationName", "UIAutomator2");

        capabilities.setCapability("appWaitActivity", "com.google.samples.apps.nowinandroid*");

        capabilities.setCapability("appium:uiautomator2ServerInstallTimeout", 60000);

        capabilities.setCapability("appium:disableWindowAnimation", true);

        capabilities.setCapability("appium:noReset", false);

    }
}

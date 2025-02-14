package io.android;

import org.openqa.selenium.WebElement;

import java.util.List;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class CommonPage {
    protected static AndroidDriver driver = AndroidManager.getDriver();

    public CommonPage() {
    }

    public WebElement findUIAutomatorText(String text) {
        return (WebElement) driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().textContains(\"" + text + "\");"));
    }
}

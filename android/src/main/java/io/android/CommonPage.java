package io.android;

import org.openqa.selenium.WebElement;

import java.util.List;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class CommonPage {
    protected static AndroidDriver driver = AndroidManager.getDriver();

    public CommonPage() {
    }

    public WebElement findId(String id) {
        return (WebElement) driver.findElement(AppiumBy.id(id));
    }

    public List<WebElement> findListId(String id) {
        return (List<WebElement>) driver.findElements(AppiumBy.id(id));
    }

    public WebElement findXpath(String xpath) {
        return (WebElement) driver.findElement(AppiumBy.xpath(xpath));
    }

    public List<WebElement> findListXpath(String xpath) {
        return (List<WebElement>) driver.findElements(AppiumBy.xpath(xpath));
    }

    public WebElement findUIAutomatorText(String text) {
        return (WebElement) driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().textContains(\"" + text + "\");"));
    }

    public List<WebElement> findListUIAutomatorText(String finder) {
        return (List<WebElement>) driver.findElements(AppiumBy.androidUIAutomator(
                "new UiSelector().textContains(\"" + finder + "\");"));
    }

    public WebElement findUIAutomatorDescription(String description) {
        return (WebElement) driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().description(\"" + description + "\");"));
    }

    public WebElement findAccesibility(String id) {
        return (WebElement) driver.findElement(new AppiumBy.ByAccessibilityId(id));
    }

    public List<WebElement> findListAccesibility(String id) {
        return (List<WebElement>) driver.findElements(new AppiumBy.ByAccessibilityId(id));
    }

}

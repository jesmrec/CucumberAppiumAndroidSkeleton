package io.android;

import java.util.List;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CommonPage {
    protected static AndroidDriver driver = AppiumManager.getManager().getDriver();

    public CommonPage(){
    }

    public MobileElement findId(String id){
        return (MobileElement) driver.findElement(MobileBy.id(id));
    }

    public List<MobileElement> findListId(String id){
        return (List<MobileElement>) driver.findElements(MobileBy.id(id));
    }

    public MobileElement findXpath(String xpath){
        return (MobileElement) driver.findElement(MobileBy.xpath(xpath));
    }

    public List<MobileElement> findListXpath(String xpath){
        return (List<MobileElement>) driver.findElements(MobileBy.xpath(xpath));
    }

    public MobileElement findUIAutomatorText(String text){
        return (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiSelector().textContains(\"" + text + "\");"));
    }

    public List<MobileElement> findListUIAutomatorText(String finder){
        return (List<MobileElement>) driver.findElements(MobileBy.AndroidUIAutomator(
                "new UiSelector().textContains(\"" + finder + "\");"));
    }

    public MobileElement findUIAutomatorDescription(String description){
        return (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiSelector().description(\"" + description + "\");"));
    }

    public MobileElement findAccesibility(String id){
        return (MobileElement) driver.findElement(new MobileBy.ByAccessibilityId(id));
    }

    public List<MobileElement> findListAccesibility(String id){
        return (List<MobileElement>) driver.findElements(new MobileBy.ByAccessibilityId(id));
    }

}

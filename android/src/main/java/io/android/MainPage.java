package io.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Level;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.log.Log;

public class MainPage extends CommonPage {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/C0.r0/android.view.View/android.view.View/android.view.View/" +
            "android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button")
    WebElement doneButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/C0.r0/android.view.View/android.view.View/android.view.View/" +
            "android.view.View/android.view.View[1]/android.view.View[2]/android.widget.Button")
    WebElement settingsButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/C0.r0/android.view.View/android.view.View/android.view.View/" +
            "android.view.View/android.view.View[1]/android.view.View[1]/android.widget.Button")
    WebElement lensIcon;

    public MainPage() {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickOnSection(String elementUI){
        Log.log(Level.FINE, "Start: Click on section: " + elementUI);
        switch (elementUI) {
            case "Headlines": {
                findUIAutomatorText(elementUI).click();
                break;
            }
            case "lens icon": {
                lensIcon.click();
                break;
            }
        }
    }

    public void clickOnSettings(){
        Log.log(Level.FINE, "Start: Click on Settings");
        settingsButton.click();
    }

    public boolean isDoneUnlocked(){
        return doneButton.isEnabled();
    }
}

package io.android;

import org.openqa.selenium.support.PageFactory;

import java.util.logging.Level;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.log.Log;

public class MainPage extends CommonPage {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "androidx.compose.ui.platform.x0/android.view.View/android.view.View/android.view.View/android.view.View/" +
            "android.view.View[2]/android.view.View[2]/android.widget.Button")
    MobileElement doneButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "androidx.compose.ui.platform.x0/android.view.View/android.view.View/android.view.View/android.view.View/" +
            "android.view.View[1]/android.view.View/android.widget.Button")
    MobileElement settingsButton;

    public MainPage() {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickOnSection(String sectionName){
        Log.log(Level.FINE, "Start: Click on section: " + sectionName);
        findUIAutomatorText(sectionName).click();
    }

    public void clickOnSettings(){
        Log.log(Level.FINE, "Start: Click on Settings");
        settingsButton.click();
    }

    public boolean isDoneUnlocked(){
        return doneButton.isEnabled();
    }
}

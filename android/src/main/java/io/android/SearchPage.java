package io.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Level;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.log.Log;

public class SearchPage extends CommonPage{

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/C0.r0/android.view.View/android.view.View/android.view.View/" +
            "android.view.View/android.widget.EditText/android.view.View[3]")
    WebElement searchTextField;

    @AndroidFindBy(id = "search:newsResources")
    WebElement results;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/C0.r0/android.view.View/android.view.View/android.view.View/" +
            "android.view.View/android.view.View[2]/android.view.View[1]/android.widget.TextView")
    WebElement firstResult;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Search\"]")
    WebElement lensIcon;

    public SearchPage() {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void typeSearch(String search){
        Log.log(Level.FINE, "Start: Search: " + search);
        lensIcon.click();
        searchTextField.sendKeys(search);
    }

    public boolean isResultDisplayed(String element) {
        Log.log(Level.FINE, "Start: Check if " + element + " is displayed");
        return results.isDisplayed() &&
                firstResult.isDisplayed() &&
                firstResult.getAttribute("text").equals(element);
    }
}

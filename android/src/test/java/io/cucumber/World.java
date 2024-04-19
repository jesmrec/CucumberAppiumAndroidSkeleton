package io.cucumber;

import io.android.MainPage;
import io.android.SearchPage;
import io.android.SettingsPage;

public class World {

    //Involved pages
    MainPage mainPage = new MainPage();
    SettingsPage settingsPage = new SettingsPage();
    SearchPage searchPage = new SearchPage();

    public World() {
    }
}

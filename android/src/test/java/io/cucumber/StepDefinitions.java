package io.cucumber;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.logging.Level;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.log.Log;

public class StepDefinitions {

    private World world;

    public StepDefinitions(World world) {
        this.world = world;
    }

    @Given("I open the app")
    public void I_open_the_app() {
        String stepName = new Object(){}.getClass().getEnclosingMethod().getName().toUpperCase();
        Log.log(Level.FINE, "----STEP----: " + stepName);
    }

    @When("I click on {word}")
    public void I_click_on(String sectionName) {
        String stepName = new Object(){}.getClass().getEnclosingMethod().getName().toUpperCase();
        Log.log(Level.FINE, "----STEP----: " + stepName);
        world.mainPage.clickOnSection(sectionName);
    }

    @When("I open Settings")
    public void I_click_on_settings() {
        String stepName = new Object(){}.getClass().getEnclosingMethod().getName().toUpperCase();
        Log.log(Level.FINE, "----STEP----: " + stepName);
        world.mainPage.clickOnSettings();
    }

    @Then("Done button is unlocked")
    public void done_unlocked() {
        String stepName = new Object(){}.getClass().getEnclosingMethod().getName().toUpperCase();
        Log.log(Level.FINE, "----STEP----: " + stepName);
        assertTrue(world.mainPage.isDoneUnlocked());
    }

    @Then("I see the following sections")
    public void sections_in_settings(DataTable table) {
        String stepName = new Object(){}.getClass().getEnclosingMethod().getName().toUpperCase();
        Log.log(Level.FINE, "----STEP----: " + stepName);
        List<List<String>> listItems = table.asLists();
        for (List<String> rows : listItems) {
            String section = rows.get(0);
            assertTrue(world.settingsPage.isSectionDisplayed(section));
        }
    }
}

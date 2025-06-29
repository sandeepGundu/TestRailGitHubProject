package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BusPage;
import utils.SeleniumUtils;

public class BusPageSteps {

    @Then("{string} for Bus page should be loaded")
    public void bus_page_should_be_loaded(String expectedTitle) {
        String actualTitle = SeleniumUtils.getPageTitle();
        if (!actualTitle.contains(expectedTitle)) {
            throw new AssertionError("Bus page did not load with the expected title: " + expectedTitle);
        }
    }

    @Then("FROM, TO, Travel Date, Today, Tomorrow fields should be displayed")
    public void fields_should_be_displayed() {
        BusPage busPage = new BusPage();
        if (!busPage.areFieldsDisplayed()) {
            throw new AssertionError("One or more fields are not displayed on the Bus page.");
        }
    }

    @When("user opts FROM value as {string}, {string}")
    public void user_opts_from_value(String city, String state) {
        BusPage busPage = new BusPage();
        busPage.selectFromValue(city, state);
    }

    @When("user opts TO value as {string}, {string}")
    public void user_opts_to_value(String city, String state) {
        BusPage busPage = new BusPage();
        busPage.selectToValue(city, state);
    }

    @When("user selects Travel Date month value as {string} and date value as {string} for the bus")
    public void user_selects_travel_date(String month, String date) {
        BusPage busPage = new BusPage();
        busPage.selectTravelDate(month, date);
    }

    @When("user clicks on search bus button")
    public void user_clicks_on_search_bus_button() {
        BusPage busPage = new BusPage();
        busPage.clickSearchBusButton();
    }

    @Then("bus search results section should be displayed")
    public void bus_search_results_section_should_be_displayed() {
        BusPage busPage = new BusPage();
        if (!busPage.isSearchResultsSectionDisplayed()) {
            throw new AssertionError("Bus search results section is not displayed.");
        }
    }
}
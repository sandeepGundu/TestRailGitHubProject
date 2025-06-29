package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.FlightsPage;

public class FlightsPageSteps {
    //WebDriver driver = Hooks.driver; // Access WebDriver from Hooks
    //HomePage homePage = new HomePage(driver); // Create an instance of LoginPage
    //SeleniumUtils seleniumUtils = new SeleniumUtils(driver); // Create an instance of SeleniumUtils
    FlightsPage flightsPage = new FlightsPage();

    @Then("{string} for flights page should be loaded")
    public void domestic_and_international_flights_page_should_be_loaded(String string) {
        boolean bStatus = flightsPage.verifyFlightsPageHeader();
        if (bStatus) {
            Assert.assertEquals(string, flightsPage.getPageHeaderText());
        }
    }

    @When("user selects {string} radio button")
    public void selectTripType(String tripType) {
        flightsPage.chooseTripType(tripType);
    }

    @Then("From, To, Departure, Travellers & Class dropdown should be displayed")
    public void from_to_departure_travellers_class_dropdown_should_be_displayed() {
        /*flightsPage.verifyFields(from);
        flightsPage.verifyFields(to);
        flightsPage.verifyDepartureFieldDisplayed(departure);
        flightsPage.verifyTravellersClassFieldDisplayed(travellersNClass);*/
        flightsPage.verifyFields("From");
        flightsPage.verifyFields("To");
        flightsPage.verifyFields("Departure");
        flightsPage.verifyFields("Travellers & Class");
    }

    /*@Then("{string}, {string}, {string}, {string}, {string} dropdown should be displayed")
    public void verify_expected_dropdown_should_be_displayed_RoundTrip(String from, String to, String departure, String returnFrom, String travellersNClass) {

        flightsPage.verifyFields(from);
        flightsPage.verifyFields(to);
        flightsPage.verifyFields(departure);
        flightsPage.verifyFields(returnFrom);
        flightsPage.verifyFields(travellersNClass);
    }*/

    @Then("From, To, Departure, Return, Travellers & Class dropdown should be displayed")
    public void verify_expected_dropdown_should_be_displayed_RoundTrip() {

        flightsPage.verifyFields("From");
        flightsPage.verifyFields("To");
        flightsPage.verifyFields("Departure");
        flightsPage.verifyFields("Return");
        flightsPage.verifyFields("Travellers & Class");
    }

    /*@When("the user selects {string} value as {string}")
    public void the_user_selects_value_as(String fromOrToField, String value) {
        // Write code here that turns the phrase above into concrete actions

        flightsPage.selectFromRToValues(fromOrToField, value);
    }*/
    @When("user selects From value as {string}")
    public void user_selects_From_value_as(String value) {
        flightsPage.selectFromValue(value);
    }

    @When("user selects To value as {string}")
    public void user_selects_To_value_as(String value) {
        flightsPage.selectToValue(value);
    }

    /*@When("the user selects {string} month value as {string} and date value as {string}")
    public void the_user_selects_month_value_as_and_date_value_as(String departure, String monthYear, String date) {
        // Write code here that turns the phrase above into concrete actions
        flightsPage.selectDepartureDate(departure, monthYear, date);
    }*/

    @When("user selects Departure month value as {string} and date value as {string}")
    public void user_selects_Departure_month_value_as_and_date_value_as(String monthYear, String date) {
        // Write code here that turns the phrase above into concrete actions
        flightsPage.selectDepartureDate(monthYear, date);
    }

    /*@When("the user selects traveller {string} value as {string}")
    public void the_user_selects_traveller_value_as(String travellerType, String value) {
        // Write code here that turns the phrase above into concrete actions

        flightsPage.selectTravellerCount(travellerType, value);
    }*/

    @When("user selects Return month value as {string} and date value as {string}")
    public void user_selects_Return_month_value_as_and_date_value_as(String monthYear, String date) {
        // Write code here that turns the phrase above into concrete actions
        flightsPage.selectReturnDate(monthYear, date);
    }

    @When("user selects traveller Adults value as {string}")
    public void user_selects_traveller_Adults_value_as(String value) {
        flightsPage.selectTravellerCount("Adults", value);
    }

    @When("user selects traveller Infants value as {string}")
    public void user_selects_traveller_Infants_value_as(String value) {
        flightsPage.selectTravellerCount("Infants", value);
    }

    @When("user clicks Travellers & Class dropdown")
    public void user_clicks_travellers_class_dropdown() {
        flightsPage.clickTravellersNClass("Travellers & Class");
    }

    @When("user clicks on {string} option")
    public void user_clicks_on_option(String classType) {
        flightsPage.selectTravelClassType(classType);
    }

    @When("user clicks on done button")
    public void user_clicks_on_done_button() {
        flightsPage.clickDoneButton_TravelNClass();
    }

    @When("user clicks on search flights button")
    public void user_clicks_on_search_flights_button() {
        flightsPage.clickSearchFlights();
    }

    @Then("search the results section should be displayed")
    public void search_the_results_section_should_be_displayed() {
        System.out.println(flightsPage.getSearchResultsHeaderText());
    }
}

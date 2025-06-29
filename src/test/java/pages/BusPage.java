package pages;

import org.openqa.selenium.By;
import utils.SeleniumUtils;

public class BusPage {

    private By fromField = By.id("fromField");
    private By toField = By.id("toField");
    private By travelDateField = By.id("travelDateField");
    private By searchButton = By.id("searchButton");
    private By resultsSection = By.id("resultsSection");

    public boolean areFieldsDisplayed() {
        return SeleniumUtils.isElementDisplayed(fromField) &&
               SeleniumUtils.isElementDisplayed(toField) &&
               SeleniumUtils.isElementDisplayed(travelDateField);
    }

    public void selectFromValue(String city, String state) {
        SeleniumUtils.sendText(fromField, city + ", " + state);
    }

    public void selectToValue(String city, String state) {
        SeleniumUtils.sendText(toField, city + ", " + state);
    }

    public void selectTravelDate(String month, String date) {
        SeleniumUtils.clickElement(travelDateField);
        SeleniumUtils.selectDateFromCalendar(month, date);
    }

    public void clickSearchBusButton() {
        SeleniumUtils.clickElement(searchButton);
    }

    public boolean isSearchResultsSectionDisplayed() {
        return SeleniumUtils.isElementDisplayed(resultsSection);
    }
}
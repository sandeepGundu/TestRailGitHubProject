package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import stepDefinitions.WebDriver_DriverManager;
import utils.SeleniumUtils;

public class FlightsPage
{
    /*WebDriver driver;

    // Constructor to initialize WebDriver
    public FlightsPage(WebDriver driver) {
        this.driver = driver;
    }

    SeleniumUtils seleniumUtils = new SeleniumUtils(driver); */// Create an instance of SeleniumUtils

    /*WebDriver driver = Hooks.driver; // Access WebDriver from Hooks
    SeleniumUtils seleniumUtils = new SeleniumUtils(driver); // Create an instance of SeleniumUtils
*/

    SeleniumUtils seleniumUtils;
    WebDriver driver = WebDriver_DriverManager.getDriver();

    public FlightsPage() {
        seleniumUtils = new SeleniumUtils(WebDriver_DriverManager.getDriver());
    }

    // Locators for the Flights page elements
    public By flightsPageHeader = By.xpath("//div[@data-id='flt-srch-wdgt']//h2");

    private By getTravelTypeOption(String travelType)
    {
        return By.xpath("//p[text()='" + travelType + "']/parent::li");
    }

    private By getGivenDropdownField(String fieldName)
    {
        return By.xpath("//span[text()='" + fieldName + "']/parent::div");
    }

    private By getFromToLocationField(String fromOrToLocationType)
    {
        return By.xpath("//span[text()='" + fromOrToLocationType + "']/following-sibling::input");
    }

    private By getFromLocationValueField(String fromLocationValue)
    {
        //return By.xpath("//ul[@id='autoSuggest-list']//li//span[contains(@class,'autoCompleteSubTitle')][contains(text(), 'HYD')]");
        return By.xpath("//ul[@id='autoSuggest-list']//span[@class='autoCompleteSubTitle' and normalize-space()='(" + fromLocationValue + ")']");
    }

    public By getDepartureDropdown(String departureField)
    {
        return By.xpath("//span[text()='" + departureField + "']/following-sibling::p");
    }

    private By departureDropdown = By.xpath("//span[text()='Departure']/following-sibling::p");

    private By getDepartureDateXpath(String monthYear, String date)
    {
        return By.xpath("//div[contains(text(), '" + monthYear + "')]/ancestor::div[@class='DayPicker-Month']//div[@class='DayPicker-Week']//div[contains(@class, 'DayPicker-Day') and @aria-disabled= 'false']//p[text()='" + date + "']");
    }

    private By travellersNClassDropdown = By.xpath("//span[contains(text(), 'Travellers & Class')]//following-sibling::p");

    private By getTravellersNClassDropdown(String travellerNClassLabel)
    {
        return By.xpath("//span[contains(text(), '" + travellerNClassLabel + "')]//following-sibling::p");
    }
    private By getTravellersIncrement(String travellerType)
    {
        return By.xpath("//p[text()='" + travellerType + "']//following-sibling::div//span[3]");
    }

    private By getTravellersDecrement(String travellerType)
    {
        return By.xpath("//p[text()='" + travellerType + "']//following-sibling::div//span[3]");
    }

    private By getTravellersCountXpath(String travellerType)
    {
        return By.xpath("//p[text()='" + travellerType + "']//following-sibling::div//span[2]");
    }

    private By getTravellersClassXpath(String travellerClass)
    {
        return By.xpath("//p[text()='Travel Class']//following-sibling::ul//li[text()='" + travellerClass + "']");
    }

    private By travellersNClass_doneBtn = By.xpath("//a[text()='Done']");

    private By travellersNClass_CancelBrn = By.xpath("//a[text()='Cancel']");

    private By searchFlightsBtn = By.xpath("//span[text()='SEARCH FLIGHTS']");

    private By flightsSearchResultTxt = By.xpath("//div[@class='listingRhs']//span");

    public boolean verifyFlightsPageHeader()
    {
        return seleniumUtils.isElementDisplayed(driver.findElement(flightsPageHeader));
    }

    public String getPageHeaderText()
    {
        return seleniumUtils.getElementText(driver.findElement(flightsPageHeader));
    }

    public void chooseTripType(String tripType)
    {
        seleniumUtils.clickElement(driver.findElement(getTravelTypeOption(tripType)));
    }

    public boolean verifyFields(String webElementName)
    {
        return seleniumUtils.isElementDisplayed(driver.findElement(getGivenDropdownField(webElementName)));
    }

    public boolean verifyDepartureFieldDisplayed(String webElementName)
    {
        return seleniumUtils.isElementDisplayed(driver.findElement(departureDropdown));
    }

    public boolean verifyTravellersClassFieldDisplayed(String webElementName)
    {
        return seleniumUtils.isElementDisplayed(driver.findElement(travellersNClassDropdown));
    }

    public void selectFromRToValues(String fromOrToField, String fromOrToValue)
    {
        seleniumUtils.waitForElementToBeVisible(getGivenDropdownField(fromOrToField), 5);
        if(fromOrToField.equalsIgnoreCase("From") || fromOrToField.equalsIgnoreCase("Where to"))
        {
            seleniumUtils.clickElement(driver.findElement(getGivenDropdownField(fromOrToField)));
        }

        seleniumUtils.sendText(driver.findElement(getFromToLocationField(fromOrToField)), fromOrToValue);
        seleniumUtils.clickElement(driver.findElement(getFromLocationValueField(fromOrToValue)));
    }

    public void selectFromValue(String value)
    {
        seleniumUtils.waitForElementToBeVisible(getGivenDropdownField("From"), 5);
        seleniumUtils.clickElement(driver.findElement(getGivenDropdownField("From")));
        seleniumUtils.sendText(driver.findElement(getFromToLocationField("From")), value);
        seleniumUtils.clickElement(driver.findElement(getFromLocationValueField(value)));
    }

    public void selectToValue(String value)
    {
        seleniumUtils.waitForElementToBeVisible(getFromToLocationField("To"), 5);
        seleniumUtils.clickElement(driver.findElement(getFromToLocationField("To")));
        seleniumUtils.sendText(driver.findElement(getFromToLocationField("To")), value);
        seleniumUtils.clickElement(driver.findElement(getFromLocationValueField(value)));
    }

    public void selectDepartureDate(String monthYear, String date)
    {
        seleniumUtils.clickElement(driver.findElement(getGivenDropdownField("Departure")));
        seleniumUtils.clickElement(driver.findElement(getDepartureDateXpath(monthYear, date)));
    }

    public void selectReturnDate(String monthYear, String date)
    {
        seleniumUtils.clickElement(driver.findElement(getGivenDropdownField("Return")));
        seleniumUtils.clickElement(driver.findElement(getDepartureDateXpath(monthYear, date)));
    }

    public void clickTravellersNClass(String travellersNClassField)
    {
        seleniumUtils.clickElement(driver.findElement(getGivenDropdownField(travellersNClassField)));
    }

    public void selectTravellerCount(String travellerType, String noOfTravellers)
    {
        String selectedCount = seleniumUtils.getElementText(driver.findElement(getTravellersCountXpath(travellerType)));
        if(!selectedCount.equals(noOfTravellers))
        {
            while (Integer.parseInt(selectedCount) != Integer.parseInt(noOfTravellers)){
                seleniumUtils.clickElement(driver.findElement(getTravellersIncrement(travellerType)));
                selectedCount = seleniumUtils.getElementText(driver.findElement(getTravellersCountXpath(travellerType)));
                if(Integer.parseInt(selectedCount) == Integer.parseInt(noOfTravellers))
                    break;
            }
        }
    }

    public void selectTravelClassType(String classType)
    {
        seleniumUtils.clickElement(driver.findElement(getTravellersClassXpath(classType)));
    }

    public void clickDoneButton_TravelNClass()
    {
        seleniumUtils.clickElement(driver.findElement(travellersNClass_doneBtn));
    }

    public void clickSearchFlights()
    {
        seleniumUtils.clickElement(driver.findElement(searchFlightsBtn));
    }

    public String getSearchResultsHeaderText()
    {
        return seleniumUtils.getElementText(driver.findElement(flightsSearchResultTxt));
    }
}

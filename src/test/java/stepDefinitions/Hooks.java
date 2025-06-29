package stepDefinitions;

//import com.aventstack.extentreports.gherkin.model.Scenario;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ReportManager;

import java.time.Duration;

public class Hooks
{
    // Declare WebDriver as a static variable so it can be shared across step definitions
    public static WebDriver driver;
    //private static ExtentReportManager reportManager;

    @Before(order = 0) // Ensure this runs before other @Before methods
    public void initializeReport() {
        // Initialize the ExtentReports instance
        ReportManager.initReport();
    }

    /**
     * This method initializes the WebDriver before each scenario.
     * It sets the WebDriver instance in the DriverManager for global access.
     */
    @Before(order = 1)
    public void setup() {

        // Set the path to the ChromeDriver executable
        //System.setProperty("webdriver.chrome.driver", "src/test/lib/chromedriver.exe");

        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver(); // Or use a factory for different browsers
        WebDriver_DriverManager.setDriver(driver);

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set an implicit wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("Browser launched successfully.");

    }

    /**
     * This method starts the reporting for the current scenario.
     * It initializes the ExtentReports test instance.
     */
    @Before(order = 2)
    public void beforeScenario(Scenario scenario) {
        // Start reporting for the scenario
        ReportManager.startTest(scenario.getName());
        ReportManager.logInfo("Starting scenario: " + scenario.getName());
    }

    /**
     * This method quits the WebDriver after each scenario.
     * It ensures proper cleanup of resources.
     */
    @After(order = 1)
    public void teardown() {

        WebDriver_DriverManager.quitDriver();

    }

    /**
     * This method logs the status of the scenario after execution.
     * It updates the ExtentReports with the scenario result.
     */
    @After(order = 2)
    public void afterScenario(Scenario scenario) {
        // Log scenario status
        if (scenario.isFailed()) {
            ReportManager.logFail("Scenario failed: " + scenario.getName());
        } else {
            ReportManager.logInfo("Scenario passed: " + scenario.getName());
        }


        ReportManager.flushReport();
    }
}

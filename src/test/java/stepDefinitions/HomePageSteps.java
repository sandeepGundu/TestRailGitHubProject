package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;
import utils.SeleniumUtils;

public class HomePageSteps
{
    //WebDriver driver = Hooks.driver; // Access WebDriver from Hooks
    HomePage homePage = new HomePage(); // Create an instance of LoginPage
    SeleniumUtils seleniumUtils = new SeleniumUtils(WebDriver_DriverManager.getDriver()); // Create an instance of SeleniumUtils

    @Given("user is on the home page")
    public void the_user_is_on_the_home_page() throws InterruptedException {
        // Navigate to the goibibo home page
        seleniumUtils.loadApp();
        homePage.verifyNCloseLoginAlert();
        System.out.println("Navigated to the goibibo home page.");
    }

    @When("user chooses {string} from main menu")
    public void the_user_chooses_from_main_menu(String mainMenuItem) throws InterruptedException {
        Thread.sleep(5000);
        homePage.clickMainMenuItem(mainMenuItem);
    }

}

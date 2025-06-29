package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import stepDefinitions.WebDriver_DriverManager;
import utils.SeleniumUtils;

public class HomePage
{
    /*WebDriver driver;

    // Constructor to initialize WebDriver
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }*/

    SeleniumUtils seleniumUtils;
    WebDriver driver = WebDriver_DriverManager.getDriver();

    public HomePage() {
        seleniumUtils = new SeleniumUtils(WebDriver_DriverManager.getDriver());
    }

    private By loginAlert_Close = By.xpath("//div[@data-id = 'auth-flow-section']//span[contains(@class, 'icClose')]");

    // Locators for the home page elements
    private By getHeaderMenuItem(String menuItemName)
    {
        return By.xpath("//header[contains(@class, 'header-sticky')]//span[contains(@class, 'header-sprite nav-icon')]/parent::div//following-sibling::span[contains(text(), '" + menuItemName + "')]/ancestor::a");
    }

    public void clickMainMenuItem(String menuItemName)
    {
        driver.findElement(getHeaderMenuItem(menuItemName)).click();
    }

    public void verifyNCloseLoginAlert() throws InterruptedException {
        boolean bStatus = seleniumUtils.isElementDisplayed(driver.findElement(loginAlert_Close));
        if(bStatus)
        {
            seleniumUtils.clickElement(driver.findElement(loginAlert_Close));
            Thread.sleep(300);
        }
    }
}

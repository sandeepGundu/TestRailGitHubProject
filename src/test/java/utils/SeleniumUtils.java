package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

public class SeleniumUtils
{
    WebDriver driver;
    WebDriverWait wait;

    // Constructor to initialize WebDriver
    public SeleniumUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Open given url page
    public void loadApp()
    {
        driver.get("https://www.goibibo.com/");
    }

    // Method to click on a web element
    public void clickElement(WebElement element) {
        try {
            element.click();
            System.out.println("Clicked on the element: " + element);
        } catch (Exception e) {
            System.err.println("Failed to click on element: " + element);
            throw e;
        }
    }

    // Method to send text to a web element
    public void sendText(WebElement element, String text) {
        try {
            element.clear(); // Clear any existing text
            element.sendKeys(text);
            System.out.println("Entered text: " + text);
        } catch (Exception e) {
            System.err.println("Failed to send text: " + element);
            throw e;
        }
    }

    // Method to wait for an element to be visible
    public WebElement waitForElementToBeVisible(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            System.out.println("Element is visible: " + locator);
            return element;
        } catch (Exception e) {
            System.out.println("Element not visible: " + e.getMessage());
            return null;
        }
    }

    // Method to wait for an element to be clickable
    public WebElement waitForElementToBeClickable(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            System.out.println("Element is clickable: " + locator);
            return element;
        } catch (Exception e) {
            System.out.println("Element not clickable: " + e.getMessage());
            return null;
        }
    }

    // Method to get the text of a web element
    public String getElementText(WebElement element) {
        try {
            String text = element.getText();
            System.out.println("Text of the element: " + text);
            return text;
        } catch (Exception e) {
            System.out.println("Failed to get text: " + e.getMessage());
            return null;
        }
    }

    public String getPageTitle()
    {
        try {
            String pageTitle = driver.getTitle();
            System.out.println("Page Title: " + pageTitle);
            return pageTitle;
        } catch (Exception e) {
            System.out.println("Failed to get text: " + e.getMessage());
            return null;
        }
    }

    public void scrollToElement(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            System.out.println("Scrolled to the element: " + element);
        } catch (Exception e) {
            System.out.println("Failed to scroll to the element: " + e.getMessage());
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            boolean isDisplayed = element.isDisplayed();
            System.out.println("Element is displayed: " + isDisplayed);
            return isDisplayed;
        } catch (Exception e) {
            System.out.println("Failed to check if element is displayed: " + e.getMessage());
            return false;
        }
    }

    public boolean isElementEnabled(WebElement element) {
        try {
            boolean isEnabled = element.isEnabled();
            System.out.println("Element is enabled: " + isEnabled);
            return isEnabled;
        } catch (Exception e) {
            System.out.println("Failed to check if element is enabled: " + e.getMessage());
            return false;
        }
    }

    public void selectDropdownByVisibleText(WebElement dropdownElement, String visibleText) {
        try {
            Select dropdown = new Select(dropdownElement);
            dropdown.selectByVisibleText(visibleText);
            System.out.println("Selected option: " + visibleText);
        } catch (Exception e) {
            System.out.println("Failed to select option: " + e.getMessage());
        }
    }

    public void selectDropdownByIndex(WebElement dropdownElement, int index) {
        try {
            Select dropdown = new Select(dropdownElement);
            dropdown.selectByIndex(index);
            System.out.println("Selected option at index: " + index);
        } catch (Exception e) {
            System.out.println("Failed to select option: " + e.getMessage());
        }
    }

    public void selectDropdownByValue(WebElement dropdownElement, String value) {
        try {
            Select dropdown = new Select(dropdownElement);
            dropdown.selectByValue(value);
            System.out.println("Selected option with value: " + value);
        } catch (Exception e) {
            System.out.println("Failed to select option: " + e.getMessage());
        }
    }

    public String getElementAttribute(WebElement element, String attribute) {
        try {
            String value = element.getAttribute(attribute);
            System.out.println("Attribute value: " + value);
            return value;
        } catch (Exception e) {
            System.out.println("Failed to get attribute value: " + e.getMessage());
            return null;
        }
    }

    public boolean waitForPageTitle(String expectedTitle, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        try {
            boolean isTitleMatched = wait.until(ExpectedConditions.titleIs(expectedTitle));
            System.out.println("Page title matched: " + expectedTitle);
            return isTitleMatched;
        } catch (Exception e) {
            System.out.println("Failed to match page title: " + e.getMessage());
            return false;
        }
    }

    public void switchToFrame(WebElement frameElement) {
        try {
            driver.switchTo().frame(frameElement);
            System.out.println("Switched to frame: " + frameElement);
        } catch (Exception e) {
            System.out.println("Failed to switch to frame: " + e.getMessage());
        }
    }

    public void switchToDefaultContent() {
        try {
            driver.switchTo().defaultContent();
            System.out.println("Switched back to default content.");
        } catch (Exception e) {
            System.out.println("Failed to switch to default content: " + e.getMessage());
        }
    }

    public void acceptAlert() {
        try {
            driver.switchTo().alert().accept();
            System.out.println("Alert accepted.");
        } catch (Exception e) {
            System.out.println("Failed to accept alert: " + e.getMessage());
        }
    }

    public void dismissAlert() {
        try {
            driver.switchTo().alert().dismiss();
            System.out.println("Alert dismissed.");
        } catch (Exception e) {
            System.out.println("Failed to dismiss alert: " + e.getMessage());
        }
    }

    public String getAlertText() {
        try {
            String alertText = driver.switchTo().alert().getText();
            System.out.println("Alert text: " + alertText);
            return alertText;
        } catch (Exception e) {
            System.out.println("Failed to get alert text: " + e.getMessage());
            return null;
        }
    }

    public void takeScreenshot(String filePath) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(filePath));
            System.out.println("Screenshot saved at: " + filePath);
        } catch (IOException e) {
            System.out.println("Failed to take screenshot: " + e.getMessage());
        }
    }

    public void takeScreenshot_NonCommons(String filePath) {
        try {
            // Capture the screenshot and save it as a file
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Use Java's Files class to copy the file
            Files.copy(screenshot.toPath(), new File(filePath).toPath());

            System.out.println("Screenshot saved at: " + filePath);
        } catch (IOException e) {
            System.out.println("Failed to take screenshot: " + e.getMessage());
        }
    }
}

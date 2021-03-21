package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

public class BaseFunc {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private WebDriver driver;
    private WebDriverWait wait;

    public BaseFunc() {
        LOGGER.info("Setting webdriver path");
        System.setProperty("webdriver.chrome.driver", "C://chromedriver/chromedriver.exe");

        LOGGER.info("Opening browser window");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10);
    }

    public void openUrl(String url) {
        LOGGER.info("Opening " + url + " web page");


        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }

        driver.get(url);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public void click(WebElement we) {
        wait.until(ExpectedConditions.elementToBeClickable(we));
        we.click();
    }

    public List<WebElement> findElements(By locator) {
        LOGGER.info("Getting all elements by: " + locator);
        return driver.findElements(locator);
    }

    public String getText(By locator) {
        LOGGER.info("Getting text of element by locator: " + locator);
        return findElement(locator).getText();
    }

    public String getText(By locator, int id) {
        LOGGER.info("Getting text of element Nr. " + id + "by locator: " + locator);
        List<WebElement> elements = findElements(locator);

        Assertions.assertFalse(elements.isEmpty(), "Element list is empty");
        Assertions.assertTrue(elements.size() > id, "There are less than " + id + 1 + " elements");
        return elements.get(id).getText();

    }

    public WebElement findElement(By locator) {
        LOGGER.info("Trying to find element by locator: " + locator);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public void closeBrowser() {
        LOGGER.info("Closing browser window");
        driver.close();
    }

    public void type(By locator, String text) {
        WebElement input = findElement(locator);
        input.clear();
        input.sendKeys(text);
    }

    public void select(By locator, String value) {
        Select select = new Select(findElement(locator));
        select.selectByValue(value);
    }

    public void waitForElementToBeVisible (By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean isElementPresents(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }

    }
    public void waitForElementDisappears(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TvnetTests {
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button");
    private final By LIST_OF_HEADLINES = By.xpath(".//*[@class = 'list-article__headline']");


    @Test
    public void firstTest() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tvnet.lv");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ACCEPT_COOKIES_BTN));

        WebElement acceptBtn = driver.findElement(ACCEPT_COOKIES_BTN);
        acceptBtn.click();

        driver.get("http://www.tvnet.lv/7126335/piektdien-794-jauni-covid-19-inficetie-11-mirusie");
        driver.get("http://www.tvnet.lv/7126335/piektdien-794-jauni-covid-19-inficetie-11-mirusie/comments");


    }
    @Test
    public void secondTest() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tvnet.lv");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ACCEPT_COOKIES_BTN));

        WebElement acceptBtn = driver.findElement(ACCEPT_COOKIES_BTN);
        acceptBtn.click();

        List listOfHeadlines = driver.findElements(LIST_OF_HEADLINES);
        System.out.println(listOfHeadlines);

    }
}



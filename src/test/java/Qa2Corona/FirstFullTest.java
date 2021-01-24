package Qa2Corona;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstFullTest {
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//div[contains(@class, 'button cookie')]");
    private final By ARTICLE = By.tagName("article");
    private final By ARTICLE_TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENTS_COUNT = By.xpath(".//a[@class = 'article-share__item article-share__item--comments article-share__item-with-count']/span[@class= 'article-share__item--count']");

    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[@itemprop = 'headline name']");

    private final Logger LOGGER = LogManager.getLogger(FirstFullTest.class);

    @Test
    public void titleCommentsCheck() {
        LOGGER.info("This test is checking titles and comments on TVNET page");
        System.setProperty("webdriver.chrome.driver", "C://chromedriver/chromedriver.exe");

        LOGGER.info("We are opening browser window");
        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.get("http://tvnet.lv");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ACCEPT_COOKIES_BTN));

        WebElement acceptBtn = driver.findElement(ACCEPT_COOKIES_BTN);
        acceptBtn.click();

        //Find article
        WebElement currentArticle = driver.findElements(ARTICLE).get(3);

        //Store title

        String titleToCheck = currentArticle.findElement(ARTICLE_TITLE).getText();
        //String titleToCheck1 = titleToCheck.replaceAll("[()]", "");


        //Store comments count
        int commentCount = 0;

        if (!currentArticle.findElements(COMMENTS_COUNT).isEmpty()) {
            String commentsToParse = currentArticle.findElement(COMMENTS_COUNT).getText(); // (36)
            commentsToParse = commentsToParse.substring(1, commentsToParse.length() - 1); // (36) -> 36
            commentCount = Integer.parseInt(commentsToParse);
        }

        //Open article
        currentArticle.findElement(ARTICLE_TITLE).click();

        //Find and chek title
        String articlePageTile = driver.findElement(ARTICLE_PAGE_TITLE).getText();
//        Assertions.assertEquals(titleToCheck, articlePageTile, "Incorrect title");
        Assertions.assertTrue(titleToCheck.startsWith(articlePageTile), "Incorrect title");


        //Find and chek comments count
//        int commentsCountInArticle = 0;

//        if (!currentArticle.findElements(COMMENTS_COUNT).isEmpty()) {
//            String commentsToParse = currentArticle.findElement(COMMENTS_COUNT).getText(); // (36)
//            commentsCountInArticle = Integer.parseInt(commentsToParse);
//        }
//        String commentsCountInArticle = currentArticle.findElement(COMMENTS_COUNT).getText();
//
//        Assertions.assertEquals(commentCount, commentsCountInArticle, "Incorrect count");


        //Open comments page

        //Find and check title

        //Find and check comments count
        //.//li[@class = 'article-comment']
    }
}

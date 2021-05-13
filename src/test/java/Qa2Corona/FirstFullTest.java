package Qa2Corona;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstFullTest {
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode ='primary']");
    private final By CLOSE_ADS_BTN = By.xpath(".//div[contains(@style, 'z-index: 61000;')]");
    private final By ARTICLE = By.tagName("article");
    private final By ARTICLE_TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENTS_COUNT = By.xpath(".//span[@class = 'list-article__headline']/span[contains(@class, 'list-article__com')]");

    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[@itemprop = 'headline name']");
    private final By COMMENTS_COUNT_IN_ARTICLE = By.xpath(".//a[contains(@class, 'article-share__item article-share__item--co')]/span[@class= 'article-share__item--count']");
    private final By ICON_OF_COMMENTS_IN_ARTICLE = By.xpath(".//span[contains(@class, 'article-share')]/img[@src ='/v5/img/icons/comment-v2.svg']");

    private final By ARTICLE_PAGE_TITLE_IN_COMMENTS = By.xpath(".//h1[@itemprop = 'headline name']");
    private final By COMMENT_IN_ARTICLE_COMMENTS = By.xpath(".//li[@class = 'article-comment']");

    private final Logger LOGGER = LogManager.getLogger(FirstFullTest.class);
    private WebDriver driver;

    @Test
    public void titleCommentsCheck() {
        LOGGER.info("This test is checking titles and comments on TVNET page");
        System.setProperty("webdriver.chrome.driver", "C://chromedriver/chromedriver.exe");

        LOGGER.info("We are opening browser window");
        driver = new ChromeDriver();

        LOGGER.info("Maximize window");
        driver.manage().window().maximize();
        LOGGER.info("Opening URL http://tvnet.lv");
        driver.get("http://tvnet.lv");

        LOGGER.info("Waiting until get visibility of button cookies");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ACCEPT_COOKIES_BTN));

        LOGGER.info("Click on btn accept cookies");
        WebElement acceptBtn = driver.findElement(ACCEPT_COOKIES_BTN);
        acceptBtn.click();

        LOGGER.info("Driver finds article by the list");
        WebElement currentArticle = driver.findElements(ARTICLE).get(0);

        LOGGER.info("Saving title of article");
        String titleToCheck = currentArticle.findElement(ARTICLE_TITLE).getText();

        LOGGER.info("If there is comments saves it count");
        int commentCount = 0;

        if (!currentArticle.findElements(COMMENTS_COUNT).isEmpty()) {
            String commentsToParse = currentArticle.findElement(COMMENTS_COUNT).getText();
            commentsToParse = commentsToParse.substring(1, commentsToParse.length() - 1);
            commentCount = Integer.parseInt(commentsToParse);
        }

        LOGGER.info("Wait until ads button visibility");
        WebDriverWait waitAds = new WebDriverWait(driver, 10);
        waitAds.until(ExpectedConditions.visibilityOfElementLocated(CLOSE_ADS_BTN));
        LOGGER.info("Click on advertising line if present");
        WebElement adsBtn = driver.findElement(CLOSE_ADS_BTN);
        adsBtn.click();

        LOGGER.info("Click on article title");
        currentArticle.findElement(ARTICLE_TITLE).click();

        LOGGER.info("Getting article title text");
        String articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();

        LOGGER.info("Compare title text");
        Assertions.assertTrue(titleToCheck.startsWith(articlePageTitle), "Incorrect title");

        int commentCountInArticle = 0;
        LOGGER.info("Find comment count in article if they present");
        if (!driver.findElements(COMMENTS_COUNT_IN_ARTICLE).isEmpty()) {
            String commentsToParseInArticle = driver.findElement(COMMENTS_COUNT_IN_ARTICLE).getText();
            commentCountInArticle = Integer.parseInt(commentsToParseInArticle);
            LOGGER.info("Compare comments count");
            Assertions.assertEquals(commentCount, commentCountInArticle, "Incorrect count");
        }

        LOGGER.info("Waiting until get visibility of button comments page");
        WebDriverWait wait2 = new WebDriverWait(driver, 20);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(ICON_OF_COMMENTS_IN_ARTICLE));

        LOGGER.info("Click on comments page");
        driver.findElement(ICON_OF_COMMENTS_IN_ARTICLE).click();

        LOGGER.info("Find title on comments page and saves it");
        String articlePageTileInComments = driver.findElement(ARTICLE_PAGE_TITLE_IN_COMMENTS).getText();
        LOGGER.info("Compare title text on comments page");
        Assertions.assertTrue(titleToCheck.startsWith(articlePageTileInComments), "Incorrect title on comments page");

        LOGGER.info("Find list of real comments and get number of it");
        int commentsCountInArticleComments = driver.findElements(COMMENT_IN_ARTICLE_COMMENTS).size();
        LOGGER.info("Compare comment count with real comments");
        Assertions.assertEquals(commentCount, commentsCountInArticleComments, "Incorrect count on comments page");

    }

        @AfterEach
    public void closeBrowser () {
        driver.close();
    }
}

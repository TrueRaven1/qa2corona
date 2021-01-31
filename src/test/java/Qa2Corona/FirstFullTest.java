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
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode ='primary']");
    private final By ARTICLE = By.tagName("article");
    private final By ARTICLE_TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENTS_COUNT = By.xpath(".//span[@class = 'list-article__headline']/span[@class= 'list-article__comment section-font-color']");

    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[@itemprop = 'headline name']");
    private final By COMMENTS_COUNT_IN_ARTICLE = By.xpath(".//a[@class = 'article-share__item article-share__item--comments article-share__item-with-count']/span[@class= 'article-share__item--count']");

    private final By ARTICLE_PAGE_TITLE_IN_COMMENTS = By.xpath(".//h1[@itemprop = 'headline name']");
    private final By COMMENT_IN_ARTICLE_COMMENTS = By.xpath(".//li[@class = 'article-comment']");

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
        WebElement currentArticle = driver.findElements(ARTICLE).get(2);

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
        int commentCountInArticle = 0;

            String commentsToParseInArticle = driver.findElement(COMMENTS_COUNT_IN_ARTICLE).getText(); // 36
            commentCountInArticle = Integer.parseInt(commentsToParseInArticle);

        Assertions.assertEquals(commentCount, commentCountInArticle, "Incorrect count");


        //Open comments page
        driver.findElement(COMMENTS_COUNT_IN_ARTICLE).click();

        //Find and check title

        String articlePageTileInComments = driver.findElement(ARTICLE_PAGE_TITLE_IN_COMMENTS).getText();
        Assertions.assertTrue(titleToCheck.startsWith(articlePageTileInComments), "Incorrect title");

        //Find and check comments count

//        int commentsCountInArticleComments = driver.findElements(COMMENT_IN_ARTICLE_COMMENTS).get();


        //.//li[@class = 'article-comment']
    }
}

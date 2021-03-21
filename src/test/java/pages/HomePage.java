package pages;

import helpers.CommentsHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class HomePage {
    private final By ACCEPT_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By ARTICLE = By.tagName("article");
    private final By COMMENT_COUNT = By.xpath(".//span[contains(@class, 'article__comment')]");
    private final By CLOSE_ADS_BTN = By.xpath(".//div[contains(@style, 'z-index: 61000;')]");
    private BaseFunc baseFunc;

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public HomePage(BaseFunc baseFunc) {

        this.baseFunc = baseFunc;

        if (baseFunc.isElementPresents(CLOSE_ADS_BTN)) {
            baseFunc.click(CLOSE_ADS_BTN);
        }
    }
    public void closeAdsBtn() {
        if (baseFunc.isElementPresents(CLOSE_ADS_BTN)) {
            baseFunc.click(CLOSE_ADS_BTN);
        }
    }

    public void acceptCookies() {
        baseFunc.click(ACCEPT_BTN);
    }

    public ArticlePage openArticleById(int id) {
        WebElement articleToClick = baseFunc.findElements(TITLE).get(id);
        baseFunc.click(articleToClick);
        return new ArticlePage(baseFunc);
    }

    public String getArticleTitleById(int id) {
        LOGGER.info("Getting articles Nr. " + id + " title");
        return baseFunc.getText(TITLE, id);
    }

    public int getCommentCountById(int id) {
        WebElement commentsCount = baseFunc.findElements(COMMENT_COUNT).get(id);

        CommentsHelper helper = new CommentsHelper();
        return helper.getCommentCount(commentsCount);
    }

    public List<WebElement> getTitles() {

        return baseFunc.findElements(TITLE);
    }

    public List<WebElement> getComments() {

        return baseFunc.findElements(COMMENT_COUNT);
    }

    public HashMap<String, Integer> getAllArticles () {
        List<WebElement> articles = baseFunc.findElements(ARTICLE);

        HashMap<String, Integer> allArticles = new HashMap<String, Integer>();

        for (WebElement we : articles) {
            if (we.findElement(TITLE).getText().length() != 0) {
            String title = we.findElement(TITLE).getText();
            Integer commentCount;

            if (we.findElements(COMMENT_COUNT).isEmpty()) {
            commentCount = 0;
            }
            else  {
                String commentsToParse = we.findElement(COMMENT_COUNT).getText();
                commentCount = Integer.parseInt(commentsToParse.substring(1, commentsToParse.length() - 1));
            }
            allArticles.put(title, commentCount);
            }


        }
        return allArticles;
    }


}

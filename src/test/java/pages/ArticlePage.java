package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePage {
    private BaseFunc baseFunc;

    private final By TITLE = By.xpath(".//h1[@itemprop = 'headline name']");
    private final By COMMENT_COUNT = By.xpath(".//a[@class = 'article-share__item article-share__item--comments article-share__item-with-count']/span[@class= 'article-share__item--count']");
    private final By ICON_OF_COMMENTS_IN_ARTICLE = By.xpath(".//span[@class =  'article-share__image-container social-button']/img[@src ='/v5/img/icons/comment-v2.svg']");
    private final By CLICK_BY_BLOCK = By.xpath(".//img[@style = 'display:block;']");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public ArticlePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitle() {
        LOGGER.info("Getting article title");
        return baseFunc.getText(TITLE);
    }

    int commentCountInArticle = 0;

    public int getCommentCountInArticle() {

        if (!baseFunc.findElements(COMMENT_COUNT).isEmpty()) {
            String commentToParseInArticle = baseFunc.findElement(COMMENT_COUNT).getText();
            commentCountInArticle = Integer.parseInt(commentToParseInArticle);
            
        }
        return commentCountInArticle;
    }
    public WebElement openCommentPage() {
        LOGGER.info("Try to open comments page");
        WebElement commentPageToClick = baseFunc.findElement(ICON_OF_COMMENTS_IN_ARTICLE);
        baseFunc.click(ICON_OF_COMMENTS_IN_ARTICLE);
        return commentPageToClick;

    }
    public void clickByBlock() {
        baseFunc.click(CLICK_BY_BLOCK);
    }


}

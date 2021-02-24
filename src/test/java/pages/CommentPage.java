package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class CommentPage {
    private BaseFunc baseFunc;

    private final By TITLE_IN_COMMENT_PAGE = By.xpath(".//h1[@itemprop = 'headline name']");
    private final By COMMENTS_IN_COMMENT_PAGE = By.xpath(".//li[@class = 'article-comment']");



    private final Logger LOGGER = LogManager.getLogger(this.getClass());



    public String getTitleInComments() {
        LOGGER.info("Getting article title in comments page");
        return baseFunc.getText(TITLE_IN_COMMENT_PAGE);
    }

    int commentCountInArticle = 0;

         public int getCommentCountInArticle() {
        LOGGER.info("Find list of real comments and get number of it");
        if (!baseFunc.findElements(COMMENTS_IN_COMMENT_PAGE).isEmpty()) {
            String commentsToParseInArticle = baseFunc.findElement(COMMENTS_IN_COMMENT_PAGE).getText(); // 36
            commentCountInArticle = Integer.parseInt(commentsToParseInArticle);
        }
        return commentCountInArticle;
    }


}

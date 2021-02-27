package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class CommentPage {

    private BaseFunc baseFunc;

    private final By TITLE_IN_COMMENT_PAGE = By.xpath(".//h1[@itemprop = 'headline name']");
    private final By COMMENTS_IN_COMMENT_PAGE = By.xpath(".//li[@class = 'article-comment']");


    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public CommentPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;

    }


    public String getTitleInComments() {
        LOGGER.info("Getting article title in comments page");
        return baseFunc.getText(TITLE_IN_COMMENT_PAGE);
    }

//    int commentCountInCommentPage = 0;

    public int getCommentCountInCommentPage() {
        LOGGER.info("Find list of real comments and get number of it");
        int commentCountInCommentPage = baseFunc.findElements(COMMENTS_IN_COMMENT_PAGE).size();
        return commentCountInCommentPage;
    }


}

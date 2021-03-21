import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.ArticlePage;
import pages.BaseFunc;
import pages.CommentPage;
import pages.HomePage;

import java.util.List;

public class PageObjectTest {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private int articleId = 2;
    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void tvnetPageObjectTest() {
        LOGGER.info("This test is checking article title and comment counts");

        baseFunc.openUrl("http://tvnet.lv");

        HomePage homePage = new HomePage(baseFunc);
        homePage.acceptCookies();
        homePage.closeAdsBtn();

        List<WebElement> titles = homePage.getTitles();
        List<WebElement> comments = homePage.getComments();

        for (int i = 0; i < titles.size(); i++){


            if (comments.size() > i) {
                System.out.println(titles.get(i).getText() + " :: " + comments.get(i).getText());
            } else {
                System.out.println(titles.get(i).getText() + " ------ ");
            }
        }

        String homePageTitle = homePage.getArticleTitleById(articleId);

        ArticlePage articlePage = homePage.openArticleById(articleId);
        articlePage.closeAdsBtn();
        String articlePageTitle = articlePage.getTitle();
        Assertions.assertTrue(homePageTitle.startsWith(articlePageTitle), "Titles are not the same");
        Integer commentsCountInArticlePage = articlePage.getCommentCountInArticle();

        articlePage.openCommentPage();
        CommentPage commentPage = new CommentPage(baseFunc);
        String articlePageTitleInComments = commentPage.getTitleInComments();
        Assertions.assertTrue(homePageTitle.startsWith(articlePageTitleInComments), "Title in comment page are not the same");
        Assertions.assertEquals(commentsCountInArticlePage, commentPage.getCommentCountInCommentPage(), "Incorrect count on comments page");

    }
//    @AfterEach
//    public void closeBrowser () {
//        baseFunc.closeBrowser();
//    }

}

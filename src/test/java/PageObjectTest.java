import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.ArticlePage;
import pages.BaseFunc;
import pages.CommentPage;
import pages.HomePage;

public class PageObjectTest {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private int articleId = 4;


    @Test
    public void tvnetPageObjectTest() {
        LOGGER.info("This test is checking article title and comment counts");

        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openUrl("http://tvnet.lv");

        HomePage homePage = new HomePage(baseFunc);
        homePage.acceptCookies();
//        homePage.clickByBlock();
        //Get article title on Home page
        String homePageTitle = homePage.getArticleTitleById(articleId);

//        homePage.openArticleById(articleId);
//
//        ArticlePage articlePage = new ArticlePage(baseFunc);
        ArticlePage articlePage = homePage.openArticleById(articleId);
//        Get article title on Article Page
        String articlePageTitle = articlePage.getTitle();
//        articlePage.clickByBlock();


        //        Compare article titles
//        Assertions.assertEquals(homePageTitle, articlePageTitle, "Titles are not the same");
        Assertions.assertTrue(homePageTitle.startsWith(articlePageTitle), "Titles are not the same");


        //Compare comments count
//        int commentsCountInArticle = articlePage.getCommentCountInArticle();
//
//        Assertions.assertEquals(homePageTitle.contentEquals(commentsCountInArticle), "Incorect count");


        //Open comments page
        articlePage.openCommentPage();
        CommentPage commentPage = new CommentPage(baseFunc);

        //Find and chek title

        String articlePageTitleInComments = commentPage.getTitleInComments();

        Assertions.assertTrue(homePageTitle.startsWith(articlePageTitleInComments), "Title in comment page are not the same");

        //Find and check comments count

        Assertions.assertEquals(articlePage.getCommentCountInArticle(), commentPage.getCommentCountInCommentPage(), "Incorrect count on comments page");

    }
}

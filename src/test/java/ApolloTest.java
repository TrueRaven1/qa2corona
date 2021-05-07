import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.ArticlePage;
import pages.BaseFunc;
import pages.HomePage;

import java.util.List;

public class ApolloTest {
    private final String URL = "apollo.lv";

    @Test
    public void commercialCloseTest () {
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openUrl(URL);

        HomePage homePage = new HomePage(baseFunc);
        homePage.acceptCookies();
        homePage.closeAdsBtn();

        List<WebElement> titles = homePage.getTitles();
        List<WebElement> comments = homePage.getComments();

        for (int i = 0; i < titles.size(); i++){


            if (comments.size() > i) {
                System.out.println(titles.get(i).getText() + " :: " + comments.get(i).getText());
            } else {
                System.out.println(titles.get(i).getText() + " :: ------ ");
            }
        }

        homePage.openArticleById(1);
//
//        ArticlePage articlePage = new ArticlePage(baseFunc);
//        System.out.println(articlePage.getTitle());
//        articlePage.waitForAds();
//
//        articlePage.openCommentPage();

    }
}

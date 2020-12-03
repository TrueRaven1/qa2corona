import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DelfiTests {
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode = 'primary']");

    @Test
    public void firstTest() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://delfi.lv");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ACCEPT_COOKIES_BTN));
        //zajti na tv net, s glavnoj stranici perejti na statju, i perejti na komentarii.
        //*perehodim na opredeljennuju statju po schetu (ispoljzuja spiski)
        //**perehodim na statjju po konkretno zadannomu zagalovku
        //***perehodja po stranicam, proverjaem chto zagolovki vezde odinakovie
        //****vmeste s zagolovkami proverjatj i kolichestvo komentariev(pri proverke ispoljzovatj Inti a ne stringi)
        //*****proverjaja kolichestvo komentariev (schetchik) proverjatj nalichie komentariev

        WebElement acceptBtn = driver.findElement(ACCEPT_COOKIES_BTN);
        acceptBtn.click();

    }



}

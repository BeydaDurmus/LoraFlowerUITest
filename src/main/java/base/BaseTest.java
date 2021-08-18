package base;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static base.Constants.BASE_URL;

public class BaseTest {
    protected static WebDriver driver;
    protected  static WebDriverWait wait;

    public static void setup(){
        System.out.println(System.getProperty("user.dir"));
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/drivers/chromedriver.exe");

        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        openBrowser();

    }
    public static  void openBrowser() {
        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }

    public static void downScroll() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void closeBrowser(){

        driver.close();
    }
}

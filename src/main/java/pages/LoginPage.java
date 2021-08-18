package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static base.Constants.BASE_URL;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;


    public LoginPage(WebDriver driver, WebDriverWait wait){

        this.driver= driver;
        this.wait=wait;

    }

    public void sendKeysInputs(String email,String password){ //Email ve Passwordleri ilgili inputlara yollarız.
        driver.get(BASE_URL);

        WebElement emailInput=driver.findElement(By.id("EmailLogin"));
        //WebElement emailInput= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EmailLogin")));
        emailInput.sendKeys(email);

        WebElement passwordInput=driver.findElement(By.id("Password"));
        passwordInput.sendKeys(password);
    }

    public WebElement assertLogin(){ // Başarlı şekilde login olunduğu zaman gerekli assertion kontrolünü sağlarız.
      WebElement element=  driver.findElement(By.xpath("//div[@class='header__right-col']//nav[@class='user-menu']//span[text()='My Account']"));
      return element;
    }

    public void clickButton(){
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
    }

    public String getEmailErrorMessage(){ //Burada email inputuna ait hata mesajlarını yakalıyoruz.
      String errorMessage=  driver.findElement(By.id("EmailLogin-error")).getText();
      return errorMessage;
    }

    public String getPasswordErrorMessage(){ //Burada password inputuna ait hata masajlarını yakalıyoruz.
        String errorMessage=  driver.findElement(By.id("Password-error")).getText();
        return errorMessage;
    }
}

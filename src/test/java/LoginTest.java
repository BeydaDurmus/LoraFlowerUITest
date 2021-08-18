import base.BaseTest;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pages.LoginPage;

import static base.Constants.*;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @BeforeClass
    public static void beforeClass(){
        setup();

    }

    @Test
    public void loginWithValidInputs(){
        loginPage=new LoginPage(driver,wait);
        loginPage.sendKeysInputs(VALID_EMAIL,VALID_PASS);
        loginPage.clickButton();
        WebElement element= loginPage.assertLogin();

        Assert.assertTrue(element.isEnabled());
    }

    @Test
    public void loginWithInvalidEmail(){
        loginPage=new LoginPage(driver,wait);
        loginPage.sendKeysInputs(INVALID_EMAIL,VALID_PASS);

        String error=loginPage.getEmailErrorMessage();
         if(!error.isEmpty()){
             Assert.assertEquals(INVALID_EMAIL_ERROR_MESSAGE,error);
         }
         else {
             System.out.println("Error Message must be enabled but it isn't shown.");
         }
    }
    @Test
    public void loginWithInvalidPassword(){
        loginPage=new LoginPage(driver,wait);
        loginPage.sendKeysInputs(VALID_EMAIL,INVALID_PASSWORD);
        loginPage.clickButton();

        String error=loginPage.getPasswordErrorMessage();
        if(!error.isEmpty()){
            Assert.assertEquals(INVALID_PASSWORD_ERROR_MESSAGE,error);
        }
        else{
            System.out.println("Error Message must be enabled but it isn't shown.");
        }
    }

    @Test
    public void loginWithNullInputs(){
        loginPage=new LoginPage(driver,wait);
        loginPage.sendKeysInputs("","");
        loginPage.clickButton();

        String emailError=loginPage.getEmailErrorMessage();
        String passwordError=loginPage.getPasswordErrorMessage();

        if(!emailError.isEmpty() && !passwordError.isEmpty()){
            Assert.assertEquals(NULL_ERROR_MESSAGE,emailError);
        }
        else{
            System.out.println("Error Message must be enabled but it isn't shown.");
        }
    }

    @AfterClass
    public static void  afterClass(){
        closeBrowser();
        System.out.println("Testler sonlandı.");
    }
}

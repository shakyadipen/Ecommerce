import TestUtilities.ReadExcel;
import ecommerce.Pages.LoginPage;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void VerifyLoginTest() throws IOException {
        LoginPage login = new LoginPage(driver);
       ReadExcel read =new ReadExcel();
        login.clickSignLink();
        String loginPageText=login.loginVerifyPage();
        try {
            assertTrue(loginPageText.contains("Customer Login"));
        }
        catch(Exception e){
            e.printStackTrace();

            }
        String email=read.getEmail("Login",0,2);
        String pass=read.getPassword("Login",1,2);
        login.setLoginDetails(email,pass);
        login.clickSigninButton();
        logger.info("Login Successful with email"+email);
        Reporter.log("Login Successfull with email"+email);


    }
}

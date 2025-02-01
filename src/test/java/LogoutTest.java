import ecommerce.Pages.LogoutPage;
import ecommerce.Pages.RegisterPage;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

public class LogoutTest extends BaseTest{
    @Test
public void VerifyFirstLogout(){
        LogoutPage logout=new LogoutPage(driver);
            RegisterPage register=new RegisterPage(driver);
        logout.clickLogout();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String logoutURL=driver.getCurrentUrl();
        assertTrue(logoutURL.contains("https://magento.softwaretestingboard.com/"));
        String name=RegisterTest.fullName;
        logger.info("The user "+name+"successfully logged out");
        Reporter.log("The user "+name+" successfully logged out");


}
@Test
    public void VerifySecondLogout(){
        LogoutPage logout2=new LogoutPage(driver);
       // RegisterPage register=new RegisterPage(driver);
        logout2.clickSecondLogout();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String logoutURL=driver.getCurrentUrl();
        assertTrue(logoutURL.contains("https://magento.softwaretestingboard.com/"));
        String name=RegisterTest.fullName;
        logger.info("The user "+name+"successfully logged out");
         Reporter.log("The user "+name+"successfully logged out");


    }
}

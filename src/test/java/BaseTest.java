import TestUtilities.ReadConfig;
import TestUtilities.ReadExcel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseTest {
    public static WebDriver driver;
    public static ReadConfig readFile=new ReadConfig();
    //*****************GetURL From Config.properties**********************************************//
    public static String url=readFile.getApplicationURL();

    public static Logger logger;
    @BeforeTest
    public static void setup(ITestContext context) throws IOException {
        logger=Logger.getLogger("Ecommerce Testing Started");

        //**************************Get Registration Details from Excel***************************
        ReadExcel readData=new ReadExcel();

        //********************************Webdriver Setup**********************************//
        /*
        *Webdriver manager will handle the browser.
        * No need to provide the browser locations and exe file at all
         */
        driver=new ChromeDriver();
        driver.get(url);
        //************************using the same driver instance into reporting class
        context.setAttribute("WebDriver",driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        logger.info("Browser Opened with provided URL:"+url);
        Reporter.log("Browser Opened with provided URL:"+url);

    }
    @AfterTest
    public void closePage(){
        driver.close();
        logger.info("The Webpage is closed");
        Reporter.log("Web Browser is closed");
    }
}

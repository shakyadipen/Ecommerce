package TestUtilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporting extends TestListenerAdapter {
    public ExtentReports extent;
    public ExtentHtmlReporter htmlReporter;
    public ExtentTest logger;
    WebDriver driver=null;

    public void onStart(ITestContext testContext) {

        String dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String ReportName = "Ecommerce" + dateFormat + ".html";
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + ReportName);
        htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-report-config.xml");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "LocalHost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User", "Shakya");

        htmlReporter.config().setDocumentTitle("Ecommerce WebApp Test");
        htmlReporter.config().setReportName("Functional Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
    }

    public void onTestSuccess(ITestResult tr){
        logger=extent.createTest(tr.getName());
        logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
//        try {
//            screenshot();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

    }
    public void onTestFailure (ITestResult tr){
        logger=extent.createTest(tr.getName());
        //***************Use same driver instance from basetest**************************//
        ITestContext context = tr.getTestContext();
        logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

        driver = (WebDriver) context.getAttribute("WebDriver");
        Date date=new Date();
        String destination=System.getProperty("user.dir");
        String timestamp=date.toString().replace(":","_");
        File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile,new File(destination+"\\Screenshots\\"+"Error"+timestamp+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
//    public void screenshot() throws IOException {
//
//        driver = (WebDriver) context.getAttribute("WebDriver");
//        Date date=new Date();
//        String destination=System.getProperty("user.dir");
//        String timestamp=date.toString().replace(":","_");
//        File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(screenshotFile,new File(destination+"\\Screenshots\\"+"Error"+timestamp+".png"));
//    }
    public void onTestSkip(ITestResult tr){
        logger=extent.createTest(tr.getName());
        logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.YELLOW));

    }
    public void onFinish(ITestContext testContext){
        extent.flush();

    }
}

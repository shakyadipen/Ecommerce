package ecommerce.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LogoutPage {
    public WebDriver driver;
    public LogoutPage(WebDriver driver){
        this.driver=driver;
    }
    private By dropDownLink= By.xpath("//button[@class=\"action switch\"]");
  //  private By secondDropDownLink=By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button");
    private By secondDropDownLink=By.xpath("//button[@class=\"action switch\"]");

    private By logoutLink=By.xpath("//a[contains(text(),('Sign Out'))]");
    public void clickLogout(){
        driver.findElement(dropDownLink).click();
        driver.findElement(logoutLink).click();
    }
    public void clickSecondLogout(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        wait.until(visibilityOf(driver.findElement(secondDropDownLink)));
        driver.findElement(secondDropDownLink).click();

        driver.findElement(logoutLink).click();
    }
}

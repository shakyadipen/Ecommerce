package ecommerce.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        driver.navigate().refresh();
        driver.findElement(secondDropDownLink).click();
        driver.findElement(logoutLink).click();
    }
}

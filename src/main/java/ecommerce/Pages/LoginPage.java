package ecommerce.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    private By signInLink= By.xpath("//a[contains(text(),'Sign In')]");
    private By loginPageVerify=By.xpath("//span[@class=\"base\"]");
    private By inputEmail=By.xpath("//input[@id=\"email\"]");
    private By inputPassword=By.xpath("//input[@id=\"pass\"]");
    private By loginButton=By.xpath("//button[@id=\"send2\"]");

    public void clickSignLink(){
        driver.findElement(signInLink).click();


    }
    public String loginVerifyPage(){
        String loginPageText=driver.findElement(loginPageVerify).getText();
        return loginPageText;
    }
    public void setLoginDetails(String email,String pass){
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).sendKeys(pass);
    }
    public void clickSigninButton(){
        driver.findElement(loginButton).click();
    }
}

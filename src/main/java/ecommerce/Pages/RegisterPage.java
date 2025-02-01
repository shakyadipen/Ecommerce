package ecommerce.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class RegisterPage {
    public  WebDriver driver;
    public RegisterPage(WebDriver driver){
        this.driver=driver;
    }
    private By registerLink= By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a");
    private By RegisterVerifyTitle=By.xpath("//*[@data-ui-id='page-title-wrapper']");
    private By firstName=By.xpath("//input[@id=\"firstname\"]");
    private By lastName=By.id("lastname");
    private By email=By.xpath("//input[@id=\"email_address\"]");
    private By password=By.xpath("//input[@id=\"password\"]");
    private By passwordConfirm=By.xpath("//input[@id=\"password-confirmation\"]");
    private By submitButton=By.xpath("//button[@class=\"action submit primary\"]");
    private By registrationVerify=By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div/div");
    public void clickRegister(){
        driver.findElement(registerLink).click();

    }
    public String registerTitleVerify(){
    String registerPageText=driver.findElement(RegisterVerifyTitle).getText();
    return registerPageText;
    }
    public void fillRegister(String fname,String lname,String emails,String pwd,String cpwd){
        driver.findElement(firstName).sendKeys(fname);
        driver.findElement(lastName).sendKeys(lname);
        driver.findElement(email).sendKeys(emails);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(passwordConfirm).sendKeys(cpwd);

    }
    public String setEmail(String providedEmail){
        Random randomNumb=new Random();
        int rand=randomNumb.nextInt(100);
        String email=providedEmail+rand+"@gmail.com";
        return email;
    }
    public void clickButton(){
        driver.findElement(submitButton).click();
    }
    public String welcomeRegistraionVerify(){
        String welcomeRegistrationText=driver.findElement(registrationVerify).getText();
        return welcomeRegistrationText;
    }
    public String getCompleteName(String firstname,String lastname){
        return(firstname+" "+lastname);

    }

}

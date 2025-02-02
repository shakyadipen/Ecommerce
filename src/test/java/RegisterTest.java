import TestUtilities.ReadExcel;
import ecommerce.Pages.RegisterPage;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;

public class RegisterTest extends BaseTest {

public static String fullName;
    @Test
public void VerifyRegisterTest() throws IOException {
        RegisterPage register=new RegisterPage(driver);
        //*****Get Registration Details from Exccel**********************************//
        ReadExcel read=new ReadExcel();
        register.clickRegister();
        var registerText=register.registerTitleVerify();

        try{
                assertTrue(register.registerTitleVerify().contains("Create New Customer Account"));
        }catch(Exception e){
                e.printStackTrace();

        }
        logger.info("User successfully reached to register page");
        String firstName=read.getFirstName("Registration",1,1);
        String lastName=read.getLastName("Registration",1,2);
        String email=read.getEmail("Registration",1,3);
        String fullEmail=register.setEmail(email);
        String password=read.getPassword("Registration",1,4);
        String confirmPassword=read.getConfirmPassword("Registration",1,5);
        register.fillRegister(firstName,lastName,fullEmail,password,confirmPassword);

        //*********Click Create Button**************************//
        register.clickButton();
        logger.info("Successfully clicked on the create button");

        //******************Account Creation Verification****************//
             fullName=register.getCompleteName(firstName,lastName);
        assertTrue(register.welcomeRegistraionVerify().contains("Thank you for registering with Main Website Store."));
        logger.info("Successfully created an account with email:"+fullEmail+"and full name:"+fullName);
            Reporter.log("Registration Successfull with account"+fullEmail+"and full name:"+fullName);
    }
}

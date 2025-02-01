package TestUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    Properties property;
    public ReadConfig() {

        try{
            FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"//Configuration/config.properties");
            property=new Properties();
            property.load(fs);
        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
    public String getApplicationURL(){
        //************************Reading url from config.properties file************************//
        String URL=property.getProperty("baseUrl");
        return URL;
    }
}

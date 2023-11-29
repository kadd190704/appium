package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class Hooks {
    // Driver class i Page lerde initializing hatasi verdi bu sebepten Hooks Class i ni create ettik
    public static AndroidDriver<AndroidElement> androidDriver;
    static DesiredCapabilities capabilities = new DesiredCapabilities();

    @BeforeMethod
    public void setUp(){
        try {
            //capabilities.setCapability("deviceName", ConfigReader.getProperty("deviceName"));
            //capabilities.setCapability("platformName", ConfigReader.getProperty("platformName"));
            //capabilities.setCapability("platformVersion", ConfigReader.getProperty("platformVersion"));
            //capabilities.setCapability("automationName", ConfigReader.getProperty("automationName"));
            //capabilities.setCapability("app", System.getProperty("user.dir") + ConfigReader.getProperty("app"));
            capabilities.setCapability("noReset", true);
            androidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723"),capabilities) ;
        }catch (MalformedURLException e){
            System.out.println("Malformed Url Exception:" + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown(){
        if (androidDriver != null) {
            androidDriver.closeApp();
            androidDriver = null;
        }
    }
}

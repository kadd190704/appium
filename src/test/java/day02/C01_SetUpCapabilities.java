package day02;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class C01_SetUpCapabilities {

    AndroidDriver<AndroidElement> androidDriver;

    DesiredCapabilities capabilities = new DesiredCapabilities();

    @Test
    public void setUpCalculator() throws MalformedURLException {
        capabilities.setCapability("deviceName", "Pixel 7 API 33");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "13.0");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", System.getProperty("user.dir") + "/app/Calculator.apk");
        androidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723"), capabilities);


    }


}

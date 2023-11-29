package day02;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class C02_DifferentDrivers {

    AppiumDriver<MobileElement> appiumDriver;
    DesiredCapabilities capabilities = new DesiredCapabilities();

    @Test
    public void isCalculatorAppInstalled() throws MalformedURLException {
        capabilities.setCapability("deviceName", "Pixel 7 API 33");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "13.0");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", System.getProperty("user.dir") + "/app/Calculator.apk");
        appiumDriver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723"), capabilities);
        Assert.assertTrue(appiumDriver.isAppInstalled("com.google.android.calculator"));
        // to test for isAppInstalled we should find the bundled id of the aplication
        // download Apk info from the apk pure website
    }

    @Test
    public void capabilityTypes() throws MalformedURLException {
        // Node.js kullanıyorsanız, Java'nın MobileCapabilityType'ını doğrudan access'i yoktur
        // Bu yüzden hata alma riski olabilir

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 7 API 33");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/app/Calculator.apk");
        appiumDriver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723"), capabilities);
    }
}

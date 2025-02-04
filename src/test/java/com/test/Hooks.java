package com.test;

import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Hooks {

    private static AppiumDriver<?> driver;

    public static AppiumDriver<?> validateDriver() throws MalformedURLException{

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app","C:\\Users\\PICHAU\\IdeaProjects\\Apium_Java_Cucumber\\apps\\app-debug.apk");
        cap.setCapability("deviceName","emulator-5554");
        cap.setCapability("platforName","Android");
        driver = new AndroidDriver( new URL("http://localhost:4723/wd/hub"),cap);
        return driver;



    }

    public static AppiumDriver<?> getDriver(){
        return driver;
    }

    public static void quitDriver(){
        if (driver != null){
            driver.quit();
        }
    }
    @Before

    public static void startProject() throws MalformedURLException{
        if (getDriver() != null){
            getDriver().launchApp();
        }else{
            validateDriver();
        }
    }
}

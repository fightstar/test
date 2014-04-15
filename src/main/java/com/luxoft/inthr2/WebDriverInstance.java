package com.luxoft.inthr2;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: ihnedysh
 * Date: 02.11.13
 * Time: 18:18
 * To change this template use File | Settings | File Templates.
 */

public class WebDriverInstance {
    private static WebDriver ourInstance;

    public static   WebDriver getInstance() {
        if (ourInstance == null){
        return ourInstance = Initialize();
        }
        return ourInstance;
    }

    private WebDriverInstance() {
    }

    private static WebDriver Initialize() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("network.automatic-ntlm-auth.trusted-uris", "luxoft.com,localhost");
        profile.setPreference("network.ntlm.send-lm-response", true);

        WebDriver driver = new FirefoxDriver(profile);    //get browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        WebDriverRunner.setWebDriver(driver); //SELENIDE
        System.out.println("WebDriverRunner.setWebDriver(driver);");
        Configuration.timeout = 50000;
        return driver;
    }



}

package com.luxoft.inthr2.pages;

import com.luxoft.inthr2.WebDriverInstance;
import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: ihnedysh
 * Date: 02.11.13
 * Time: 17:50
 * To change this template use File | Settings | File Templates.
 */

public class EnvironmentConfiguration {
    private boolean disposed = false;
    private String applicationUrl;
    private WebDriver driver;


    public  EnvironmentConfiguration(String applicationUrl) {
        this(applicationUrl, WebDriverInstance.getInstance());
    }

    public EnvironmentConfiguration(String applicationUrl, WebDriver driver) {
        this.applicationUrl = applicationUrl;
        this.driver = driver;
    }

    @Override
    protected void finalize() throws Throwable {
        Dispose();
        super.finalize();
    }

    public String getApplicationUrl() {
        return applicationUrl;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void Dispose() {
        if (!disposed) {
            driver.quit();
            driver = null;
            applicationUrl = null;
            disposed = true;

        }
    }
}

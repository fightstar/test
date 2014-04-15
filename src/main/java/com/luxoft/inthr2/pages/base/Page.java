package com.luxoft.inthr2.pages.base;

import com.luxoft.inthr2.pages.EnvironmentConfiguration;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;


/**
 * Created with IntelliJ IDEA.
 * User: ihnedysh
 * Date: 02.11.13
 * Time: 17:20
 * To change this template use File | Settings | File Templates.
 */
public abstract class Page implements IPage {
    protected EnvironmentConfiguration configuration;
    protected int pageOpenTimeout = 500;
    protected IPage prevPage;
    protected Logger l = Logger.getLogger(Page.class);

    public Page(EnvironmentConfiguration configuration) {
        if (configuration == null) {
            throw new IllegalArgumentException("configuration is null");
        }

        this.configuration = configuration;
    }

    public Page(EnvironmentConfiguration configuration, IPage prevPage) {
        this(configuration);

        if (prevPage.getClass() == Page.class) {
            Page page = (Page) prevPage;
            page.waitPageLoaded();
        }

        this.prevPage = prevPage;
    }



    public abstract String getTitle();

    public IPage clickMenu() {
        return null;
    }

    public IPage open() {
        com.codeborne.selenide.Selenide.open(configuration.getApplicationUrl() + getUrl());
        //configuration.getDriver().navigate().to(configuration.getApplicationUrl() + getUrl());
        l.info(configuration.getApplicationUrl()+getUrl());
        waitPageLoaded();
        return this;
    }

    public IPage close() {
        configuration.getDriver().close();
        return null;
    }

    public static void waitWhileLoaded() {

        while ($(By.className("k-loading-image")).exists()){
            sleep(200);
        }

    }

    public  String getUrl() {
        return "/";
    }

    protected void waitPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };

        Wait<WebDriver> wait = new WebDriverWait(configuration.getDriver(), pageOpenTimeout);
        wait.until(expectation);
    }
}

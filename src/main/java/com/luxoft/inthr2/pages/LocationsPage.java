package com.luxoft.inthr2.pages;

import com.luxoft.inthr2.pages.base.Page;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LocationsPage extends Page {
    private static String pageUrl = "/location/index";
    public LocationsPage(EnvironmentConfiguration configuration) {
        super(configuration);
    }

    @Override
    public String getTitle() {
        return $(By.xpath("//div[@id = 'mainContent']//h4")).text();
    }
    @Override
    public String getUrl() {
        return pageUrl;
    }
}

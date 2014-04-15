package com.luxoft.inthr2.pages;

import com.luxoft.inthr2.controls.Grid;
import com.luxoft.inthr2.controls.TextBox;
import com.luxoft.inthr2.pages.base.GridedPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created with IntelliJ IDEA.
 * User: vshevchenko
 * Date: 09.11.13
 * Time: 19:22
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeMonitoringPage extends GridedPage {
    private static String pageUrl = "/employee/staffList";

    public EmployeeMonitoringPage(EnvironmentConfiguration configuration) {
        super(configuration, "StaffListGrid");
    }

    @Override
    public String getTitle() {
        return $(By.xpath("//div[@id = 'mainContent']//h4")).getText();
    }

    @Override
    public String getUrl() {
        return pageUrl;
    }

    public TextBox getSearchEmployeeTextBox() {
        return new TextBox("search-by-last-name");
    }

    public Grid getEmployeeGrid() {
        return new Grid("StaffListGrid");
    }

}

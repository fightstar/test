package com.luxoft.inthr2.pages;

import com.luxoft.inthr2.controls.Button;
import com.luxoft.inthr2.controls.Grid;
import com.luxoft.inthr2.controls.TextBox;
import com.luxoft.inthr2.pages.base.GridedPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created with IntelliJ IDEA.
 * User: vshevchenko
 * Date: 14.11.13
 * Time: 13:49
 * To change this template use File | Settings | File Templates.
 */
public class TerminationMonitoringPage extends GridedPage {
    private static String pageUrl = "/terminationMonitoring/index";
    private final String gridId = "termination-monitoring-grid";

    public TerminationMonitoringPage(EnvironmentConfiguration configuration) {
        super(configuration, "termination-monitoring-grid");
    }

    public TextBox getSearchEmployeeTextBox() {
        return new TextBox("search-input");
    }

    public Grid getTerminationGrid() {
        return new Grid(gridId);
    }
    public Button getAddTerminationButton() {
        return new Button("termination-create");
    }
    public Button getOpenTerminationButton() {
        return new Button("termination-open");
    }
    @Override
    public String getUrl() {
        return pageUrl;
    }


    @Override
    public String getTitle() {
        return $(By.xpath("//div[@id = 'mainContent']//h4")).getText();
    }
}

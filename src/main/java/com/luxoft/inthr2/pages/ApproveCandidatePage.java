package com.luxoft.inthr2.pages;

import com.luxoft.inthr2.controls.Button;
import com.luxoft.inthr2.controls.DropDownList;
import com.luxoft.inthr2.pages.base.Page;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created with IntelliJ IDEA.
 * User: vshevchenko
 * Date: 22.11.13
 * Time: 16:55
 * To change this template use File | Settings | File Templates.
 */
public class ApproveCandidatePage extends Page {
    public ApproveCandidatePage(EnvironmentConfiguration configuration) {
        super(configuration);
    }

    public Button getApproveButton() {
        return new Button("btn_approve");
    }

    public Button getBackToMonitoringButton() {
        return new Button("btn_back_to_monitoring");
    }

    public DropDownList getManagementBU(){
        return new DropDownList("//select[@id = 'mbu']/ancestor::span");
    }
    public DropDownList getBudgetOnProbPeriod() {
        return new DropDownList("//select[@id = 'budget-on']/ancestor::span");
    }
    public DropDownList getBudgetAfterProbPeriod() {
        return new DropDownList("//select[@id = 'budget-after']/ancestor::span");
    }
    @Override
    public String getTitle() {
        return $(By.xpath("//div[@id = 'mainContent']//h4")).getText();
    }
}

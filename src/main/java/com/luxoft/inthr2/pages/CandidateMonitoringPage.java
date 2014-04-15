package com.luxoft.inthr2.pages;

import com.codeborne.selenide.Condition;
import com.luxoft.inthr2.controls.Button;
import com.luxoft.inthr2.controls.Grid;
import com.luxoft.inthr2.pages.base.GridedPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class CandidateMonitoringPage extends GridedPage {
    private static String pageUrl = "/employee/candidates";

    public CandidateMonitoringPage(EnvironmentConfiguration configuration) {
        super(configuration, "hiring-monitoring-grid");
    }

    @Override
    public String getTitle() { //this page has no title
        return $(By.xpath("")).getText();

    }


    public Grid getCandidatesGrid(){
        return new Grid("candidates-monitoring-grid");
    }
    public Grid getHiringMonitoringGrid () {
        return new Grid("hiring-monitoring-grid");
    }
    public Grid getCandidatesRequestGrid() {
        return new Grid("hrsys-candidates-monitoring-grid");
    }
    public void getHiringMonitoringTab() {
        $(By.id("hiring-monitoring-tab")).shouldBe(Condition.visible).click();
    }
    public void getCandidatesMonitoringTab() {
        $(By.id("candidates-tab")).shouldBe(Condition.visible).click();
    }
    public void getCandidatesRequestTab() {
        $(By.id("hrsys-candidates-tab")).shouldBe(Condition.visible).click();
    }
    public Button getTransferToEmployeeButton() {
        return new Button("transfer-candidate-to-employee");
    }
    public Button getProcessSalaryInformationButton() {
        return new Button("process-salary-information");
    }
    public Button getApproveCandidateButton() {
        return new Button("approve-candidate");
    }
    @Override
    public String getUrl() {
        return pageUrl;
    }

}

package com.luxoft.inthr2.pages;

import com.luxoft.inthr2.controls.*;
import com.luxoft.inthr2.pages.base.Page;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created with IntelliJ IDEA.
 * User: vshevchenko
 * Date: 14.11.13
 * Time: 16:40
 * To change this template use File | Settings | File Templates.
 */
public class TerminationPage extends Page {

    public TerminationPage(EnvironmentConfiguration configuration) {
        super(configuration);
    }
    public Button getCreateTerminationButton() {
          return new Button("Create Termination");
    }

    public DatePicker getTerminationDate() {
         return new DatePicker("terminatio-date");
    }

    public DropDownList getFormalTerminationReason() {
        return new DropDownList("//input[@id = 'formal-termination-reason']/ancestor::span");
    }

    public TextBox getCauseForTermination(){
        return new TextBox("cause-for-termination");
    }

    public TextBox getCommentsHRI() {
        return new TextBox("hri-comments");
    }

    public DropDownList getEmployeeValue() {
        return new DropDownList("//input[@id = 'employee-value']/ancestor::span");
    }

    public DropDownList getInformalTerminationReasonByLineManager() {
        return new DropDownList("//input[@id = 'informal-termination-reason']/ancestor::span");
    }

    public MultiSelect getRetentionActivity() {
        return new MultiSelect("//ul[@id = 'retention-activity_taglist']/following-sibling::input");
    }

    public TextBox getCommentsLineManager() {
        return new TextBox("line-manager-comments");
    }



    @Override
    public String getTitle() {
        return $(By.xpath("//div[@id = 'mainContent']//h4")).getText();
    }
}

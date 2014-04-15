package com.luxoft.inthr2.pages;

import com.luxoft.inthr2.controls.Button;
import com.luxoft.inthr2.controls.DatePicker;
import com.luxoft.inthr2.controls.DropDownList;
import com.luxoft.inthr2.controls.TextBox;
import com.luxoft.inthr2.pages.base.Page;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddIdentityCardPage extends Page {

    public DropDownList getIdentityCardType() {
        return new DropDownList("//select[@id = 'model.IdentityCardType']/ancestor::span");
    }
    public TextBox getPassportSeries() {
        return new TextBox("PassportSeries");
    }
    public TextBox getPassportNumber() {
        return new TextBox("PassportNumber");
    }
    public DatePicker getDateOfIssue() {
        return new DatePicker("DateOfIssue");
    }
    public TextBox getIssuedBy() {
        return new TextBox("IssuingAuthority");
    }
    public TextBox getSubdivisionCode() {
        return new TextBox("SubdivisionCode");
    }
    public DatePicker getDateOfRegistrationAtPlaceOfResidance() {
        return new DatePicker("DateOfRegistrationAtHabitataionAddress");
    }
    //TODO
    //public CheckBox

    public Button getSaveButton() {
        return new Button("IdentityCardGrid-grid_popup_SaveBtn");
    }
    public Button getCancelButton() {
        return new Button("IdentityCardGrid-grid_popup_CancelBtn");
    }

    public AddIdentityCardPage(EnvironmentConfiguration configuration) {
        super(configuration);
    }
    public void clickOnTitle() {
        $(By.xpath("//span[@class = 'k-window-title']")).click();
    }
    @Override
    public String getTitle() {
        return $(By.xpath("//span[@class = 'k-window-title']")).text();
    }
}

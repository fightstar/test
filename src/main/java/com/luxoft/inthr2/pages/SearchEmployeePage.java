package com.luxoft.inthr2.pages;

import com.luxoft.inthr2.controls.Button;
import com.luxoft.inthr2.controls.TextBox;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created with IntelliJ IDEA.
 * User: vshevchenko
 * Date: 25.11.13
 * Time: 19:05
 * To change this template use File | Settings | File Templates.
 */
public class SearchEmployeePage  {

    public TextBox getSearchEmployeeTextBox() {
        return new TextBox("employe-search-form-input-name");
    }

    public Button getSearchEmployeeButton() {
        return new Button("search-employee-button");
    }

    public Button  getAcceptEmployeeButton() {
        return new Button("accept-employee");
    }

    public void clickOnSelectedEmployee(String fullNameNative) {
        $(By.xpath("//div[@id = 'search-employees-grid']" +
                "//div[@class = 'media']//h5[contains(text(), '"+fullNameNative+"')]")).click();
    }

}

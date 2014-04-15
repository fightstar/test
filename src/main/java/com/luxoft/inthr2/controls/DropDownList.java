package com.luxoft.inthr2.controls;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.executeJavaScript;

/**
 * Created with IntelliJ IDEA.
 * User: vshevchenko
 * Date: 22.11.13
 * Time: 19:12
 * To change this template use File | Settings | File Templates.
 */
public class DropDownList extends Control {
    private String selectId;
    public DropDownList(String xpath){
        this(By.xpath(xpath));
    }

    public DropDownList(By by) {
        super(by);
    }

    public void setValue(String value){
        Element.sendKeys(value);
    }
    public DropDownList(String xpath , String selectId){
        this(By.xpath(xpath));
        this.selectId = selectId;
    }
    public void setExistingValue(String itemNumber){

        executeJavaScript("var q=$('#"+selectId+"').data('kendoIntHrDropDownList');" +
                " q.select("+itemNumber+");" +
                " q.trigger('change');");


    }
}

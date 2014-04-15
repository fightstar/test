package com.luxoft.inthr2.controls;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created with IntelliJ IDEA.
 * User: vshevchenko
 * Date: 23.11.13
 * Time: 15:20
 * To change this template use File | Settings | File Templates.
 */
public class NumericTextBox {
    private String numericTextBoxXpath;
    private String increaseValue;
    private String decreaseValue;

    public NumericTextBox(String numericTextBoxXpath) {
        this.numericTextBoxXpath = numericTextBoxXpath;
    }
    public NumericTextBox(String increaseValue, String decreaseValue){
        this.increaseValue = increaseValue;
        this.decreaseValue = decreaseValue;
    }
    public void setValue(String value){
        $(By.xpath(numericTextBoxXpath)).clear();
        $(By.xpath(numericTextBoxXpath)).sendKeys(value);
        $(By.xpath(numericTextBoxXpath)).pressEnter();

    }
    public void increaseValue(int value){
       for(int i = 0; i < value; i++ ){
           $(By.xpath(increaseValue)).click();

        }
    }
    public void decreaseValue(int value){
        for(int i = 0; i < value; i++ ){
            $(By.xpath(decreaseValue)).click();

        }
    }
}

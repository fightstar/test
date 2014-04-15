package com.luxoft.inthr2.controls;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created with IntelliJ IDEA.
 * User: ihnedysh
 * Date: 26.11.13
 * Time: 19:05
 * To change this template use File | Settings | File Templates.
 */
public class Control {
    protected SelenideElement Element;

    public Control(By by){
        Element = $(by);
        if(Element == null){
            throw new IllegalArgumentException("invalid By provided");
        }
    }
}

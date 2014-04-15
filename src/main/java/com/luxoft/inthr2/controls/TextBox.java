package com.luxoft.inthr2.controls;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created with IntelliJ IDEA.
 * User: vshevchenko
 * Date: 09.11.13
 * Time: 19:06
 * To change this template use File | Settings | File Templates.
 */
public class TextBox  {
    private By by;



    public TextBox(String id) {

        this.by = By.id(id);
    }

    public TextBox(By by){
        this.by = by;

    }




    public void setText(String text){
        $(by).setValue(text);
    }

}

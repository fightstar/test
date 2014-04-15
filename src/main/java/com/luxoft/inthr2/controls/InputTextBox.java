package com.luxoft.inthr2.controls;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class InputTextBox extends TextBox {
    private String xpath;

    public InputTextBox(By by) {
        super(by);
    }

    public InputTextBox(String xpath, String id){
        super(id);
        this.xpath = xpath;

    }

    @Override
    public void setText(String text){
       $(By.xpath(xpath)).click();
       super.setText(text);

    }
}

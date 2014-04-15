package com.luxoft.inthr2.controls;

import com.codeborne.selenide.Condition;
import com.luxoft.inthr2.pages.base.IPage;
import org.openqa.selenium.By;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created with IntelliJ IDEA.
 * User: ihnedysh
 * Date: 02.11.13
 * Time: 23:23
 * To change this template use File | Settings | File Templates.
 */
public class Button {
    private String buttonId;

    public Button(String id) {
        this.buttonId = id;
    }

    public boolean  getEnabled(){
        return true;
    }

    public boolean  getText(){
        throw new NotImplementedException();
    }

    public IPage click(){

        $(By.id(buttonId)).shouldBe(Condition.enabled).click();
        return null;
    }
}

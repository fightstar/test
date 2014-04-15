package com.luxoft.inthr2.controls;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created with IntelliJ IDEA.
 * User: vshevchenko
 * Date: 04.12.13
 * Time: 18:17
 * To change this template use File | Settings | File Templates.
 */
public class MultiSelect {
    private String multiSelectXpath;

    public MultiSelect(String multiSelectXpath) {
        this.multiSelectXpath = multiSelectXpath;
    }

    public void setValue(String value) {
        $(multiSelectXpath).shouldBe(Condition.visible).click();
        $(By.xpath("//div[@id = 'retention-activity-list']/ul/li[contains(text(), '" +value+"')]")).shouldBe(Condition.visible).click();

    }
}

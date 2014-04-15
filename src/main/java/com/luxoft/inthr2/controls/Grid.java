package com.luxoft.inthr2.controls;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.luxoft.inthr2.pages.base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created with IntelliJ IDEA.
 * User: ihnedysh
 * Date: 02.11.13
 * Time: 23:21
 * To change this template use File | Settings | File Templates.
 */
public class Grid {

    private String id;
    protected WebElement menu;
    protected WebElement rows;

    public Grid(String id){
        this.id = id;

    }


    public void filter(String fieldName, String expression, String value){


        Page.waitWhileLoaded();

        SelenideElement filter  =
                $(By.xpath("//div[@id  = '"+id+"']/div[@class = 'k-grid-header']//table//tr/th[@data-title = '"+fieldName+"']/a[1]"));

        filter.click();

        SelenideElement condition =
                $(By.xpath("//div[@class = 'k-animation-container'][contains (@style, 'overflow: visible')]//span[1]/span[1]/span[1]/ancestor::span[1]/ancestor::span"));
        SelenideElement input =
                $(By.xpath("//div[@class = 'k-animation-container'][contains (@style, 'overflow: visible')]//span[1]/span[1]/span[1]/ancestor::span[1]/ancestor::span/following-sibling::input[1]"));
        SelenideElement filterSubmitButton = $(By.xpath("//div[@class = 'k-animation-container'][contains (@style, 'overflow: visible')]//button[@type = 'submit']"));

        condition.shouldBe(Condition.visible).sendKeys(expression);
        input.shouldBe(Condition.visible).sendKeys(value);
        filterSubmitButton.shouldBe(Condition.enabled).click();


    }




    public void clickOnFirstRow() {
        $(By.xpath("//div[@id = '"+ id +"']//tbody/tr[1]")).click();
    }
    public void clearFilter() {
        $(By.xpath("//div[@id = '"+ id +"']//button[@id = 'grid-dropFilters']")).shouldBe(Condition.visible).click();
    }
    public void clickOnRow(String rowNumber){
        $(By.xpath("//div[@id = '"+ id +"']//tbody/tr["+rowNumber+"]")).click();

    }

    public Map<String, String> getFirstRowData() {

        Map<String, String> getTableData = new HashMap<String, String>();
        ElementsCollection allHeaders = $$(By.xpath("//div[@id = '"+ id +"']//thead/tr/th"));
        ElementsCollection allCellsInFirstRow = $$(By.xpath("//div[@id = '"+ id +"']//tbody/tr[1]/td"));
        int size=allHeaders.size()< allCellsInFirstRow.size() ? allHeaders.size() :allCellsInFirstRow.size();
        for(int i = 0; i < size; i++){
            String key = allHeaders.get(i).getText(); //если getText() для кея  может быть NULL больше 1 раза - то последующий будет перекрывать первого
            String value = allCellsInFirstRow.get(i).getText();
            getTableData.put(key,value);
        }
        return getTableData;
    }
}

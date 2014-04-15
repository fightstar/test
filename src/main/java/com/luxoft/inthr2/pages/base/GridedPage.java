package com.luxoft.inthr2.pages.base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.luxoft.inthr2.pages.EnvironmentConfiguration;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


/**
 * Created with IntelliJ IDEA.
 * User: ihnedysh
 * Date: 02.11.13
 * Time: 17:20
 * To change this template use File | Settings | File Templates.
 */
public abstract class GridedPage extends Page {

    protected String mainGridId;


    public GridedPage(EnvironmentConfiguration configuration, String mainGridId) {
        super(configuration);

        if (mainGridId == null || mainGridId == "") {
            throw new IllegalArgumentException("mainGridId is null");
        }
        this.mainGridId = mainGridId;

    }




    @Override
    protected void waitPageLoaded() {

        // put your Ruslan script here

        super.waitPageLoaded();

        SelenideElement mainGrid = $(By.id(mainGridId));
        mainGrid.should(Condition.appear);    ///?????

        SelenideElement firstGridRow = $(By.xpath("//div[@id = '"+mainGridId+"']//tbody/tr[1]"));
        firstGridRow.should(Condition.appear);
    }

}

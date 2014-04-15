package com.luxoft.inthr2.pages;

import com.luxoft.inthr2.pages.base.Page;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created with IntelliJ IDEA.
 * User: vshevchenko
 * Date: 13.11.13
 * Time: 21:51
 * To change this template use File | Settings | File Templates.
 */
public class EmployeePersonalDataPage extends Page {

    public EmployeePersonalDataPage(EnvironmentConfiguration configuration) {
        super(configuration);
    }

    public String getGeneralDataLocationText() {
        return $("#Location").getText();

    }



    @Override
    public String getTitle() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

}

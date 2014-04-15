package com.luxoft.inthr2.pages.base;

/**
 * Created with IntelliJ IDEA.
 * User: ihnedysh
 * Date: 02.11.13
 * Time: 17:20
 * To change this template use File | Settings | File Templates.
 */
public interface IPage {
    String getTitle();
    String getUrl();
    IPage open();
    IPage close();
    IPage clickMenu();
}

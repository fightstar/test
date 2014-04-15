package com.luxoft.inthr2.controls;

import org.openqa.selenium.By;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created with IntelliJ IDEA.
 * User: vshevchenko
 * Date: 22.11.13
 * Time: 18:34
 * To change this template use File | Settings | File Templates.
 */
public class DatePicker {
    private String datePickerId;


    public DatePicker(String datePickerId) {
        this.datePickerId = datePickerId;
    }

    public void setDate(Date date){
        DateFormat dateFormat = new SimpleDateFormat("dd MMM YYYY", Locale.ENGLISH);
        String formattedDate = dateFormat.format(date);
        $(By.id(datePickerId)).setValue(formattedDate);
    }
    public void addDateToCurrent(int date){
        DateFormat dateFormat = new SimpleDateFormat("dd MMM YYYY", Locale.ENGLISH);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, date);
        String formattedDate  = dateFormat.format(calendar.getTime());
        $(By.id(datePickerId)).setValue(formattedDate);
        System.out.println(formattedDate);
    }
    public void setSimpleDate(String formattedDate) {   //just set formatted date "dd MMM YYYY"
        $(By.id(datePickerId)).setValue(formattedDate);
    }
    public void setCurrentDate() {
        setDate(new Date());
    }



}

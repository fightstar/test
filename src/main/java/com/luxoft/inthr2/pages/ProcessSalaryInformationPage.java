package com.luxoft.inthr2.pages;

import com.luxoft.inthr2.controls.Button;
import com.luxoft.inthr2.controls.DropDownList;
import com.luxoft.inthr2.controls.NumericTextBox;
import com.luxoft.inthr2.pages.base.Page;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created with IntelliJ IDEA.
 * User: vshevchenko
 * Date: 23.11.13
 * Time: 15:02
 * To change this template use File | Settings | File Templates.
 */
public class ProcessSalaryInformationPage extends Page {


    public ProcessSalaryInformationPage(EnvironmentConfiguration configuration) {
        super(configuration);
    }

    public DropDownList getRegistrationType() {
        return new DropDownList("//select[@id = 'salary_processing_registration_type']/ancestor::span");
    }

    public DropDownList getHRDepartment() {
        return new DropDownList("//select[@id = 'dep']/ancestor::span");
    }

    public DropDownList getPosition() {
        return new DropDownList("//select[@id = 'dropdownlist_position']/ancestor::span");
    }

    public NumericTextBox getSalary() {
        return new NumericTextBox("//input[@id = 'salaryInput']/preceding-sibling::input");
    }
    public NumericTextBox getSalaryArrows() {
        return new NumericTextBox("//div[@class = 'controls']//span[@class = 'k-link']/span[@title = 'Increase value']",
                "//div[@class = 'controls']//span[@class = 'k-link']/span[@title = 'Decrease value']");
    }
    public DropDownList getCurrency() {
        return new DropDownList("//select[@id = 'salaryCurreny']/ancestor::span");
    }

    public DropDownList getGrossNet() {
        return new DropDownList("//select[@id = 'salaryGrossNet']/ancestor::span");
    }

    public DropDownList getPaymentPeriod() {
        return new DropDownList("//select[@id = 'curreny']/ancestor::span");
    }

    public Button getSaveSalaryProcessingButton() {
        return new Button("Save Salary Processing");
    }
    public void clickOnTitle(){
        $(By.xpath("//div/span[contains(., 'Process Salary Information')]")).click();
    }
    public Button getCamcelButton() {
        return new Button("btn_cancel_salary_processing");

    }
    @Override
    public String getTitle() {
        return null;
    }
}

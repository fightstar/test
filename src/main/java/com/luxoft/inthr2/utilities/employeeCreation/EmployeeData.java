package com.luxoft.inthr2.utilities.employeeCreation;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: ihnedysh
 * Date: 26.11.13
 * Time: 19:16
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeData implements Serializable {
    public String firstName;
    public String lastName;
    public String middleName;
    public int pin;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}

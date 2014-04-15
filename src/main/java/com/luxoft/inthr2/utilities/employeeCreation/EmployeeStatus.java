package com.luxoft.inthr2.utilities.employeeCreation;

/**
 * Created with IntelliJ IDEA.
 * User: ihnedysh
 * Date: 26.11.13
 * Time: 19:52
 * To change this template use File | Settings | File Templates.
 */

public enum EmployeeStatus{

    CandidateRequest(1),
    Candidate(3),
    Employee(7),
    Terminated(15);

    private final int statusFlagValue;

    EmployeeStatus(int i) {
        this.statusFlagValue = i;
    }

    public int getValue() {
        return statusFlagValue;
    }

    public boolean hasFlag(EmployeeStatus status){
        if((this.getValue() & status.getValue()) == status.getValue()){
            return true;
        }
        else{
            return false;
        }
    }
}

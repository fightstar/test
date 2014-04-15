package com.luxoft.inthr2.utilities.employeeCreation;

/**
 * Created with IntelliJ IDEA.
 * User: ihnedysh
 * Date: 26.11.13
 * Time: 19:53
 * To change this template use File | Settings | File Templates.
 */
public interface IEmployeeCreationChainElement {
    EmployeeData Process(EmployeeData data);
    void PipeNext(IEmployeeCreationChainElement element);
}

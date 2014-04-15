package com.luxoft.inthr2.test.steps;

import com.luxoft.inthr2.pages.EnvironmentConfiguration;
import com.luxoft.inthr2.test.commons.AbstractSteps;
import com.luxoft.inthr2.utilities.employeeCreation.EmployeeFactory;
import com.luxoft.inthr2.utilities.employeeCreation.EmployeeStatus;
import org.jbehave.core.annotations.Given;

public class EmployeeFactoryGivenSteps extends AbstractSteps{

    public EmployeeFactoryGivenSteps(EnvironmentConfiguration config) {
        super(config);
    }

    @Given("Employee in status CandidateRequest")
    public void givenEmployeeStatus() {
        EmployeeFactory.createEmployee(configString, EmployeeStatus.CandidateRequest,getConfig());

    }
    @Given("Employee in status Candidate")
    public void givenEmployeeStatusCandidate() {
        EmployeeFactory.createEmployee(configString, EmployeeStatus.Candidate, getConfig());
    }
    @Given("Employee in status Employee")
    public void  givenEmployeeInStatusEmployee(){

        EmployeeFactory.createEmployee(configString, EmployeeStatus.Employee, getConfig());
    }


}

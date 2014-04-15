package com.luxoft.inthr2.test.steps;

import com.luxoft.inthr2.pages.CandidateMonitoringPage;
import com.luxoft.inthr2.pages.EmployeeMonitoringPage;
import com.luxoft.inthr2.test.commons.AbstractStories;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static junit.framework.Assert.assertEquals;

public class CreateEmployeeSteps extends AbstractStories {
    EmployeeMonitoringPage employeeMonitoringPage;
    CandidateMonitoringPage candidateMonitoringPage;

    @When("Employee Monitoring page is opened")
    public void whenEmployeeMonitoringPageIsOpened() {
        employeeMonitoringPage = new EmployeeMonitoringPage(getEnvironmentConfiguration());
        employeeMonitoringPage.open();
    }
    @When("we set $name in Search Employee")
    public void whenWeSetNameInSearchBox(@Named("name") String name) {
        employeeMonitoringPage.getSearchEmployeeTextBox().setText(name);
        employeeMonitoringPage.waitWhileLoaded();
    }
    @Then("verify that Employee $fullName was created")
    public void thenVerifyThatEmployeeWasCreated(@Named("fullName") String fullName) {
        String candidateName = employeeMonitoringPage.getEmployeeGrid().getFirstRowData().get("Full Name Native");
        assertEquals(fullName, candidateName);

    }

}

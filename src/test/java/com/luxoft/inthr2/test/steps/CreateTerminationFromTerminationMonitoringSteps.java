package com.luxoft.inthr2.test.steps;

import com.luxoft.inthr2.pages.SearchEmployeePage;
import com.luxoft.inthr2.pages.TerminationMonitoringPage;
import com.luxoft.inthr2.pages.TerminationPage;
import com.luxoft.inthr2.test.commons.AbstractStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static junit.framework.Assert.assertEquals;

public class CreateTerminationFromTerminationMonitoringSteps extends AbstractStories {
    TerminationMonitoringPage terminationMonitoringPage;
    SearchEmployeePage searchEmployeePage;
    TerminationPage terminationPage;
    @Given("Termination Monitoring page is opened")
    public void  givenTerminationMonitoringPageOpen() {
        terminationMonitoringPage = new TerminationMonitoringPage(getEnvironmentConfiguration());
        terminationMonitoringPage.open();
        terminationMonitoringPage.waitWhileLoaded();
    }

    @When("we click Add Termonation and search $employeeFullName")
    public void whenClickAddTerminationButtonAndSearchEmployee(@Named("employeeFullName") String employeeFullName) {
        terminationMonitoringPage.getAddTerminationButton().click();
        terminationMonitoringPage.waitWhileLoaded();
        searchEmployeePage.getSearchEmployeeTextBox().setText(employeeFullName);
        searchEmployeePage.clickOnSelectedEmployee(employeeFullName);
        searchEmployeePage.getAcceptEmployeeButton().click();
        terminationPage.waitWhileLoaded();

     }
    @When("fill out Termination form with valid data")
    public void whenFillOutTerminationFormWithValidData() {
        terminationPage.getTerminationDate().addDateToCurrent(30);
        terminationPage.getFormalTerminationReason().setValue("за угодою сторін, п.1 ст. 36 КЗпП України");
        terminationPage.getCauseForTermination().setText("test cause 123333");
        terminationPage.getEmployeeValue().setValue("Avg");
        terminationPage.getInformalTerminationReasonByLineManager().setValue("Money");

    }
    @When("click Create Termination button")
    public void whenClickCreateTerminationButton() {
        terminationPage.getCreateTerminationButton().click();
        terminationPage.waitWhileLoaded();
    }
    @Then("terminated $employeeFullName have status $expectedStatus")
    public void thenVerifyThatEmployeeHasStatus(@Named("employeeFullName") String fullName, @Named("expectedStatus") String expectedStatus) {
        terminationMonitoringPage.getSearchEmployeeTextBox().setText(fullName);
        terminationMonitoringPage.waitWhileLoaded();
        String actualStatus = terminationMonitoringPage.getTerminationGrid().getFirstRowData().get("Status");
        assertEquals(expectedStatus, actualStatus);

    }
}

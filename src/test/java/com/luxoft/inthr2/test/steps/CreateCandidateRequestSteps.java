package com.luxoft.inthr2.test.steps;

import com.luxoft.inthr2.pages.CandidateMonitoringPage;
import com.luxoft.inthr2.pages.EnvironmentConfiguration;
import com.luxoft.inthr2.test.commons.AbstractSteps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static junit.framework.Assert.assertEquals;

public class CreateCandidateRequestSteps extends AbstractSteps {
    CandidateMonitoringPage candidateMonitoringPage;

    public CreateCandidateRequestSteps(EnvironmentConfiguration config) {
        super(config);
    }


    @When("I open candidateMonitoringPage")
    public void whenOpenСandidateMonitoringPage() {
        candidateMonitoringPage = new CandidateMonitoringPage(getConfig());
        candidateMonitoringPage.open();
        candidateMonitoringPage.waitWhileLoaded();
    }
    @When("get CandidatesRequestTab")
    public void whenGetCandidatesRequestTab() {
        candidateMonitoringPage = new CandidateMonitoringPage(getConfig());
        candidateMonitoringPage.getCandidatesRequestTab();
    }
    @When("filter FullNameNative StartsWith to Рылов")
    public void whenFilter(){
        candidateMonitoringPage = new CandidateMonitoringPage(getConfig());
        candidateMonitoringPage.getCandidatesRequestGrid().clearFilter();
        candidateMonitoringPage.getCandidatesRequestGrid().filter("Full Name Native", "Starts with", "Рылов");
        candidateMonitoringPage.waitWhileLoaded();
    }
    @Then("I see that request was successfully created")
    public void thenAssert() {
        candidateMonitoringPage = new CandidateMonitoringPage(getConfig());
        String candidateName = candidateMonitoringPage.getCandidatesRequestGrid().getFirstRowData().get("Full Name Native");


        assertEquals("Рылов, Аркадий Александрович", candidateName);
        System.out.println("Candidate Request " +candidateMonitoringPage.getCandidatesRequestGrid().getFirstRowData().get("Full Name Native")+" created");
    }



}

package com.luxoft.inthr2.test.steps;

import com.luxoft.inthr2.pages.CandidateMonitoringPage;
import com.luxoft.inthr2.pages.EnvironmentConfiguration;
import com.luxoft.inthr2.test.commons.AbstractSteps;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.Assert.assertEquals;

public class CreateCandidateSteps extends AbstractSteps {
    CandidateMonitoringPage candidateMonitoringPage;

    public CreateCandidateSteps(EnvironmentConfiguration config) {
        super(config);
    }

    @When("Candidate Monitoring page is opened")
    public void whenCandidatePageIsOpened() {
        candidateMonitoringPage  = new CandidateMonitoringPage(getConfig());
        candidateMonitoringPage.waitWhileLoaded();

    }
    @Then("verify that $name is created")
    public void thenVerifyThatCandidateIsCreated(@Named("name") String name){
        candidateMonitoringPage.getCandidatesMonitoringTab();
        candidateMonitoringPage.waitWhileLoaded();
        sleep(20000);
        candidateMonitoringPage.getCandidatesGrid().filter("Full Name Native", "Starts with", "Рылов");
        candidateMonitoringPage.waitWhileLoaded();
        String candidateName   = candidateMonitoringPage.getCandidatesGrid().getFirstRowData().get("Full Name Native");
        assertEquals("Candidate wasn't found", name, candidateName);
    }
}

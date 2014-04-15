package com.luxoft.inthr2.test.steps;

import com.luxoft.inthr2.pages.LocationsPage;
import com.luxoft.inthr2.test.commons.AbstractStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;

import static junit.framework.Assert.assertEquals;

public class JBehaveTestSteps extends AbstractStories {
    LocationsPage locationsPage;

    @Given("Locations is opened")
    public void givenLocationIsOpened() {
        locationsPage = new LocationsPage(getEnvironmentConfiguration());
        locationsPage.open();
    }
   /* @When("nothing")
    public void whenNothing(){

    }*/

    @Then("title is $title")
    public void thenLocationTitleShould(@Named("title") String title) {
        assertEquals("Title is incorect","Locations", title);
    }

}

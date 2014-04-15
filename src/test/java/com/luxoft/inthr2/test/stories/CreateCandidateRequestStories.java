package com.luxoft.inthr2.test.stories ;

import com.luxoft.inthr2.pages.EnvironmentConfiguration;
import com.luxoft.inthr2.test.commons.AbstractStories;
import com.luxoft.inthr2.test.steps.CreateCandidateRequestSteps;
import com.luxoft.inthr2.test.steps.EmployeeFactoryGivenSteps;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.util.List;

public class CreateCandidateRequestStories extends AbstractStories {

    @Override
    public InjectableStepsFactory stepsFactory() {
        EnvironmentConfiguration config = getEnvironmentConfiguration();
        return new InstanceStepsFactory(configuration(),
                new EmployeeFactoryGivenSteps(config),
                new CreateCandidateRequestSteps(config));
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(org.jbehave.core.io.CodeLocations.codeLocationFromPath("src/test/resources"), "**/create_candidate_request_stories.story", "");
    }
}

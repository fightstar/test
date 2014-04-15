package com.luxoft.inthr2.test.stories;

import com.luxoft.inthr2.test.commons.AbstractStories;
import com.luxoft.inthr2.test.steps.JBehaveTestSteps;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.util.List;

public class JBehaveTestStories extends AbstractStories{
    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new JBehaveTestSteps());
    }
    @Override
    protected List<String> storyPaths() {
        return new StoryFinder()
                .findPaths(org.jbehave.core.io.CodeLocations.codeLocationFromPath("src/test/resources"), "**/jbehave_test_stories.story", "");
    }

}

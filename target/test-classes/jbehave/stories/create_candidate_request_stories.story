Scenario: Verify that Candidate request successfully created
Description:  some comments
Given Employee in status CandidateRequest
When I open candidateMonitoringPage
And get CandidatesRequestTab
And filter FullNameNative StartsWith to Рылов
Then I see that request was successfully created
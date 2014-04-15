Scenario: Verify that candidate created
Discription: after candidate request

Given Employee in status Candidate
When Candidate Monitoring page is opened
Then verify that Рылов, Аркадий Александрович is created

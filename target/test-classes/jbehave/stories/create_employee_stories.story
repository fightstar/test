Scenario: Verify that employee created
Description: Candidate request (Approve) --> Candidate (SalaryProcessing)--> Create Employee

Given Employee in status Employee
When Employee Monitoring page is opened
And we set Рылов, Аркадий in Search Employee
Then verify that Employee Рылов, Аркадий Александрович was created

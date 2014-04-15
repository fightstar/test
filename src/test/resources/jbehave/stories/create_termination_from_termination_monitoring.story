Scenario: Verify that user can provide termination using Termination Monitoring form
Description: we  try to terminate existing Employee and verify that terminated Employee appear
in status Current

Given Employee in status Employee
And Termination Monitoring page is opened

When we click Add Termonation and search Рылов Аркадий Александрович
And fill out Termination form with valid data
And click Create Termination button

Then terminated Рылов Аркадий Александрович have status Current




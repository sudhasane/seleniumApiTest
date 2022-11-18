Feature: Customer details

  @test
  Scenario: Verify customer details
  Given I read customerId from excel
  And I search for customer in UI
  And I verify customer details
  Then I write results to excel
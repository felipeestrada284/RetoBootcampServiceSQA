Feature: Update user


  Scenario: Update user successfully.
    When I consume the service and I send the information to update the user
    Then I can validate the service response code
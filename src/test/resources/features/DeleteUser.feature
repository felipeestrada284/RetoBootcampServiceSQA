Feature: Delete user


  Scenario: Delete user successfully.
    When I consume the service and send the user ID
    Then I can validate the data in the service response
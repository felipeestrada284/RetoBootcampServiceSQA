Feature: Create user

  @PostUser
  Scenario: Create user successfully.
    When I consume the service and I send the user information
    Then I can validate the response service

  @PutUser
  Scenario: Update user successfully.
    When I consume the service and I send the information to update the user
    Then I can validate the service response code

  @DeleteUser
  Scenario: Delete user successfully.
    When I consume the service and send the user ID
    Then I can validate the data in the service response
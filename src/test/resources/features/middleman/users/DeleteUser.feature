Feature: Delete user

  @DeleteUser @Positive @TokenUser
  Scenario: Delete user with valid token
    Given DELETE User with valid token
    When Send DELETE User
    Then Status code should be 200 OK
    And Response body should display delete user message "success delete data"
    And Validate delete user with JSON Schema "DeleteUserSchema.json"

  @DeleteUser @Negative
  Scenario: Delete user with invalid token
    Given DELETE User with invalid token
    When Send DELETE User
    Then Status code should be 401 Unauthorized
    And Response body should display delete user error message "invalid or expired jwt"
    And Validate delete user with JSON Schema "DeleteUserInvalidTokenSchema.json"
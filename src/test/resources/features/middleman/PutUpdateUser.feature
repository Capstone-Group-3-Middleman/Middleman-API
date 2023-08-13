Feature: Update user

  @UpdateUser @Positive @TokenUser
  Scenario: Update user with valid token and valid data
    Given PUT Update User with "valid" token and "valid" data
    When Send PUT Update User
    Then Status code should be 200 OK
    And Response body should display update user message "success update data"
    And Validate update user with JSON Schema "UpdateUserSchema.json"
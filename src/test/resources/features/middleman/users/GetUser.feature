Feature: Get User Profile

  @Users @Positive @TokenUser
  Scenario: Get user with valid path and valid token
    Given GET user with "valid" path and "valid" token
    When Send GET user
    Then Status code should be 200 OK
    And Response body should display user message "get data success"
    And Validate user with JSON Schema "UserSchema.json"

  @Users @Negative
  Scenario: Get user with valid path and invalid token
    Given GET user with "valid" path and "invalid" token
    When Send GET user
    Then Status code should be 401 Unauthorized
    And Response body should display user error message "invalid or expired jwt"
    And Validate user with JSON Schema "InvalidTokenUserSchema.json"

  @Users @Negative @TokenUser
  Scenario:Get user with invalid path and valid token
    Given GET user with "invalid" path and "valid" token
    When Send GET user
    Then Status code should be 404 Not Found
    And Response body should display user error message "Not Found"
    And Validate user with JSON Schema "InvalidPathUserSchema.json"

  @Users @Negative
  Scenario:Get user with invalid path and invalid token
    Given GET user with "invalid" path and "invalid" token
    When Send GET user
    Then Status code should be 404 Not Found
    And Response body should display user error message "Not Found"
    And Validate user with JSON Schema "InvalidPathAndTokenUserSchema.json"
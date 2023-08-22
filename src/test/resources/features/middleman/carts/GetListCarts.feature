Feature: List Carts

  @CartGet @Positive @TokenUser
  Scenario: Get list cart with valid token and valid path
    Given GET List Cart with "valid" token and "valid" path
    When Send GET List Cart
    Then Status code should be 200 OK

  @CartGet @Negative @TokenUser
  Scenario: Get list cart with valid token and invalid path
    Given GET List Cart with "valid" token and "invalid" path
    When Send GET List Cart
    Then Status code should be 404 Not Found
    And Response body should display list cart error message "Not Found"
    And Validate list cart with JSON Schema "InvalidPathListCartSchema.json"

  @CartGet @Negative
  Scenario: Get list cart with invalid token and valid path
    Given GET List Cart with "invalid" token and "valid" path
    When Send GET List Cart
    Then Status code should be 401 Unauthorized
    And Response body should display list cart error message "invalid or expired jwt"
    And Validate list cart with JSON Schema "InvalidTokenListCartSchema.json"

  @CartGet @Negative
  Scenario: Get list cart with invalid token and invalid path
    Given GET List Cart with "invalid" token and "invalid" path
    When Send GET List Cart
    Then Status code should be 404 Not Found
    And Response body should display list cart error message "Not Found"
    And Validate list cart with JSON Schema "InvalidTokenPathListCartSchema.json"
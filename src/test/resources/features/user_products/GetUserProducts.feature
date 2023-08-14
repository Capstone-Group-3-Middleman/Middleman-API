Feature: Get User Products

  @ListUserProduct @Positive @TokenUser
  Scenario: Get list user product with valid path and valid token
    Given GET List User Product with "valid" path and "valid" token
    When Send GET List User Product
    Then Status code should be 200 OK
    And Response body should display user product message "get data success"
    And Validate user product with JSON Schema "UserProductSchema.json"

  @ListUserProduct @Negative
  Scenario: Get list user product with valid path invalid token
    Given GET List User Product with "valid" path and "invalid" token
    When Send GET List User Product
    Then Status code should be 401 Unauthorized
    And Response body should display user product error message "invalid or expired jwt"
    And Validate user product with JSON Schema "InvalidTokenUserProdSchema.json"

  @ListUserProduct @Negative @TokenUser
  Scenario: Get list user product with invalid path and valid token
    Given GET List User Product with "invalid" path and "valid" token
    When Send GET List User Product
    Then Status code should be 404 Not Found
    And Response body should display user product error message "Not Found"
    And Validate user product with JSON Schema "InvalidPathUserProdSchema.json"

  @ListUserProduct @Negative
  Scenario: Get list user product with invalid path and invalid token
    Given GET List User Product with "invalid" path and "invalid" token
    When Send GET List User Product
    Then Status code should be 404 Not Found
    And Response body should display user product error message "Not Found"
    And Validate user product with JSON Schema "InvalidPathTokenUserProdSchema.json"
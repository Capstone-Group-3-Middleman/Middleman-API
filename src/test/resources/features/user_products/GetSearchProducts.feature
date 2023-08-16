Feature: Search User Product

  @SearchUserProduct @Positive @TokenUser
  Scenario: Get Search user product with valid token and valid parameter product name
    Given GET Search product with "valid" token and "valid" parameter product name "telur"
    When Send GET Search product
    Then Status code should be 200 OK
    And Response body should display search user product name "Telur"
    And Validate search user product with JSON Schema "SearchUserProductSchema.json"

  @SearchUserProduct @Negative
  Scenario: Get Search user product with invalid token and valid parameter product name
    Given GET Search product with "invalid" token and "valid" parameter product name "telur"
    When Send GET Search product
    Then Status code should be 401 Unauthorized
    And Response body should display search user product error message "invalid or expired jwt"
    And Validate search user product with JSON Schema "InvalidTokenSearchUserProdSchema.json"

  @SearchUserProduct @Negative @TokenUser
  Scenario: Get Search user product with valid token and invalid parameter product name
    Given GET Search product with "valid" token and "invalid" parameter product name "^%$"
    When Send GET Search product
    Then Status code should be 400 Bad Request

  @SearchUserProduct @Negative
  Scenario: Get Search user product with invalid token and invalid parameter product name
    Given GET Search product with "invalid" token and "invalid" parameter product name "^%$"
    When Send GET Search product
    Then Status code should be 401 Unauthorized
    And Response body should display search user product error message "invalid or expired jwt"
    And Validate search user product with JSON Schema "InvalidTokenParamSearchUserProdSchema.json"

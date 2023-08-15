Feature: Delete Carts

  @DeleteCarts @Positive @TokenUser
  Scenario: Delete Cart with valid token and valid parameter id product
    Given DELETE Cart with "valid" token and "valid" id product
    When Send DELETE Cart
    Then Status code should be 204 No Content

  @DeleteCarts @Negative @TokenUser
  Scenario: Delete Cart with valid token and invalid parameter id product
    Given DELETE Cart with "valid" token and "invalid" id product
    When Send DELETE Cart
    Then Status code should be 404 Not Found
    And Response body should display delete cart error message "product data not found"
    And Validate delete cart with JSON Schema "InvalidIDDeleteCartSchema.json"

  @DeleteCarts @Negative
  Scenario: Delete Cart with invalid token and valid parameter id product
    Given DELETE Cart with "invalid" token and "valid" id product
    When Send DELETE Cart
    Then Status code should be 401 Unauthorized
    And Response body should display delete cart error message "invalid or expired jwt"
    And Validate delete cart with JSON Schema "InvalidTokenDeleteCartSchema.json"

  @DeleteCarts @Negative
  Scenario: Delete Cart with invalid token and invalid parameter id product
    Given DELETE Cart with "invalid" token and "invalid" id product
    When Send DELETE Cart
    Then Status code should be 401 Unauthorized
    And Response body should display delete cart error message "invalid or expired jwt"
    And Validate delete cart with JSON Schema "InvalidTokenIDDeleteCartSchema.json"
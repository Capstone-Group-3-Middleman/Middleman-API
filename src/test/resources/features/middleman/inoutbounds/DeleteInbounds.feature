Feature: Delete product by id in carts for stock user (out) and admin (in)

  @InoutboundsDelete @Negative
  Scenario: Delete product to cart without auth token [DL-01]
    Given Login inoutbounds with "without" token
    When Delete invalid product id "24" inoutbounds
    And Send delete request inoutbounds
    Then Status code should be 400 Bad Request
    And Response body should display inoutbounds error message "missing or malformed jwt"
    And Validate response inoutbounds with JSON Schema "JSONschemaDeleteError.json"

  @InoutboundsDelete @Negative @TokenInvalid
  Scenario: User delete inoutbounds with invalid token [DL-02]
    Given Login inoutbounds with "invalid" token
    When Delete invalid product id "24" Inoutbounds
    And Send delete request inoutbounds
    Then Status code should be 401 Unauthorized
    And Response body should display inoutbounds error message "invalid or expired jwt"
    And Validate response inoutbounds with JSON Schema "JSONschemaDeleteError.json"

  @InoutboundsDelete @Negative @TokenUser
  Scenario: User delete product to cart with id product found [DL-03]
    Given Login inoutbounds with "valid user" token
    When User delete valid product id "24" inoutbounds
    And Send delete request inoutbounds
    Then Status code should be 204 No Content

  @InoutboundsDelete @Negative @TokenUser
  Scenario: User delete product to cart with id product invalid [DL-04]
    Given Login inoutbounds with "user" token
    When User delete valid product id "24" inoutbounds
    And Send delete request inoutbounds
    Then Status code should be 404 Not Found
    And Response body should display inoutbounds error message "data not found"
    And Validate response inoutbounds with JSON Schema "JSONschemaDeleteError.json"

  @InoutboundsDelete @Negative @TokenUser
  Scenario: User delete product added to cart with products that no longer exist [DL-05]
    Given Login inoutbounds with "user" token
    When User delete valid product id "none" inoutbounds
    And Send delete request inoutbounds
    Then Status code should be 404 Not Found
    And Response body should display inoutbounds error message "data not found"
    And Validate response inoutbounds with JSON Schema "JSONschemaDeleteError.json"

  @InoutboundsDelete @Negative @TokenAdmin
  Scenario: Admin delete product to cart with id product found [DL-06]
    Given Login inoutbounds with "admin" token
    When Admin delete valid product id "2" inoutbounds
    And Send delete request inoutbounds
    Then Status code should be 204 No Content

  @InoutboundsDelete @Negative @TokenAdmin
  Scenario: Admin delete product to cart with id product invalid [DL-07]
    Given Login inoutbounds with "admin" token
    When Admin delete valid product id "24" inoutbounds
    And Send delete request inoutbounds
    Then Status code should be 404 Not Found
    And Response body should display inoutbounds error message "data not found"
    And Validate response inoutbounds with JSON Schema "JSONschemaDeleteError.json"

  @InoutboundsDelete @Negative @TokenAdmin
  Scenario: Admin delete product to cart with id product not found [DL-08]
    Given Login inoutbounds with "admin" token
    When Admin delete valid product id "100" inoutbounds
    And Send delete request inoutbounds
    Then Status code should be 404 Not Found
    And Response body should display inoutbounds error message "data not found"
    And Validate response inoutbounds with JSON Schema "JSONschemaDeleteError.json"
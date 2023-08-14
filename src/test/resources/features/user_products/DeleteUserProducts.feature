Feature: Delete User Products

  @DeleteUserProducts @Positive @TokenUser
  Scenario: Delete User Product with valid token and valid parameter id product
    Given DELETE User Product with "valid" token and "valid" id "20"
    When Send DELETE User Product
    Then Status code should be 204 No Content

  @DeleteUserProducts @Negative @TokenUser
  Scenario: Delete User Product with valid token and invalid parameter id product
    Given DELETE User Product with "valid" token and "invalid" id "xyz"
    When Send DELETE User Product
    Then Status code should be 500 Internal Server Error
    And Response body should display delete user product error message "cant convert to int"
    And Validate delete user product with JSON Schema "InvalidIdDeleteUsrProdSch.json"

  @DeleteUserProducts @Negative @TokenUser
  Scenario: Delete User Product with valid token and uncreated parameter id product
    Given DELETE User Product with "valid" token and "invalid" id "9999"
    When Send DELETE User Product
    Then Status code should be 404 Not Found
    And Response body should display delete user product error message "data not found"
    And Validate delete user product with JSON Schema "UncreatedIdDeleteUsrProdSch.json"

  @DeleteUserProducts @Negative
  Scenario: Delete User Product with invalid token and valid parameter id product
    Given DELETE User Product with "invalid" token and "valid" id "22"
    When Send DELETE User Product
    Then Status code should be 401 Unauthorized
    And Response body should display delete user product error message "invalid or expired jwt"
    And Validate delete user product with JSON Schema "InvalidTokenDeleteUsrProdSch.json"

  @DeleteUserProducts @Negative
  Scenario: Delete User Product with invalid token and invalid parameter id product
    Given DELETE User Product with "invalid" token and "invalid" id "xyz"
    When Send DELETE User Product
    Then Status code should be 401 Unauthorized
    And Response body should display delete user product error message "invalid or expired jwt"
    And Validate delete user product with JSON Schema "InvalidTokenIdDeleteUsrProdSch.json"
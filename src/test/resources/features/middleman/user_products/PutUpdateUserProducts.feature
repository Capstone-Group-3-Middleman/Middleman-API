Feature: Update User Products

  @UpdateUserProduct @Positive @TokenUser
  Scenario: Put Update User Product with valid token and valid parameter id product
    Given PUT Update User Product with valid token and valid id "23"
    When Send PUT Update User Product
    Then Status code should be 200 OK
    And Response body should display update user product success message "success update data"
    And Validate update user product with JSON Schema "UpdateUserProdSchema.json"

  @UpdateUserProduct @Negative
  Scenario: Put Update User Product with invalid token and valid parameter id product
    Given PUT Update User Product with invalid token and valid id "23"
    When Send PUT Update User Product
    Then Status code should be 401 Unauthorized
    And Response body should display update user product error message "invalid or expired jwt"
    And Validate update user product with JSON Schema "InvalidTokenUpdateUserProdSchema.json"

  @UpdateUserProduct @Negative @TokenUser
  Scenario: Put Update User Product with valid token and invalid parameter id product
    Given PUT Update User Product with valid token and invalid id "xyz"
    When Send PUT Update User Product
    Then Status code should be 400 Bad Request
    And Response body should display update user product error message "wrong input"
    And Validate update user product with JSON Schema "InvalidIdUpdateUserProdSchema.json"

  @UpdateUserProduct @Negative @TokenUser
  Scenario: Put Update User Product with valid token and uncreated parameter id product
    Given PUT Update User Product with valid token and invalid id "9999"
    When Send PUT Update User Product
    Then Status code should be 404 Bad Request
    And Response body should display update user product error message "data not found"
    And Validate update user product with JSON Schema "UncreatedIdUpdateUsrProdSchema.json"

  @UpdateUserProduct @Negative @TokenUser
  Scenario Outline: Put Update User Product with valid token and invalid data
    Given PUT Update User Product with valid token and JSON file <jsonName>
    When Send PUT Update User Product
    Then Status code should be <statusCode> Bad Request
    And Response body should display update user product error message <errorMsg>
    And Validate update user product with JSON Schema <jsonSchName>
    Examples:
      | jsonName                        | statusCode | errorMsg      | jsonSchName                           |
      | "EmptyNameUpdateUserProd.json"  | 400        | "wrong input" | "EmptyNameUpdateUserProdSchema.json"  |
      | "EmptyUnitUpdateUserProd.json"  | 400        | "wrong input" | "EmptyUnitUpdateUserProdSchema.json"  |
      | "EmptyStockUpdateUserProd.json" | 400        | "wrong input" | "EmptyStockUpdateUserProdSchema.json" |
      | "EmptyPriceUpdateUserProd.json" | 400        | "wrong input" | "EmptyPriceUpdateUserProdSchema.json" |

  @UpdateUserProduct @Negative @TokenUser
  Scenario Outline: Put Update User Product with valid token and invalid data
    Given PUT Update User Product with valid token and JSON <jsonName>
    When Send PUT Update User Product
    Then Status code should be <statusCode> Bad Request
    And Response body should display update user product error message <errorMsg>
    And Validate update user product with JSON Schema <jsonSchName>
    Examples:
      | jsonName                        | statusCode | errorMsg             | jsonSchName                           |
      | "EmptyImageUpdateUserProd.json" | 400        | "wrong input"        | "EmptyImageUpdateUserProdSchema.json" |
      | "AllEmptyUpdateUserProd.json"   | 400        | "insufficient stock" | "AllEmptyUpdateUserProdSchema.json"   |
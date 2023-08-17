Feature: Create User Products

  @CreateUserProduct @Positive @TokenUser
  Scenario: Post Create user product with valid token and valid data
    Given POST Create new user product with valid token and JSON file "CreateUserProd.json"
    When Send POST Create User Product
    Then Status code should be 201 Created
    And Response body should display create user product message "success create product"
    And Validate create user product with JSON Schema "CreateProdSchema.json"

  @CreateUserProduct @Negative
  Scenario: Post Create user product with invalid token and valid data
    Given POST Create new user product with invalid token and JSON file "CreateUserProd.json"
    When Send POST Create User Product
    Then Status code should be 401 Unauthorized
    And Response body should display create user product error message "invalid or expired jwt"
    And Validate create user product with JSON Schema "InvalidTokenCreateProdSchema.json"

  @CreateUserProduct @Negative @TokenUser
  Scenario Outline: Post Create user product with valid token and invalid data
    Given POST Create new user product with valid token and JSON file <jsonName>
    When Send POST Create User Product
    Then Status code should be <statusCode> Bad Request
    And Response body should display create user product error message <errorMsg>
    And Validate create user product with JSON Schema <jsonSchName>
    Examples:
      | jsonName                         | statusCode | errorMsg      | jsonSchName                            |
      | "EmptyNameCreateProd.json"       | 400        | "wrong input" | "EmpNameCreateProdSchema.json"         |
      | "EmptyUnitCreateProd.json"       | 400        | "wrong input" | "EmptyUnitCreateProdSchema.json"       |
      | "EmptyStockCreateProd.json"      | 400        | "wrong input" | "EmptyStockCreateProdSchema.json"      |
      | "StringTypeStockCreateProd.json" | 400        | "wrong input" | "StringTypeStockCreateProdSchema.json" |
      | "EmptyPriceCreateProd.json"      | 400        | "wrong input" | "EmptyPriceCreateProdSchema.json"      |
      | "StringTypePriceCreateProd.json" | 400        | "wrong input" | "StringTypePriceCreateProdSchema.json" |

  @CreateUserProduct @Negative @TokenUser
  Scenario: Post Create user product with valid token and add empty product image to request body
    Given POST Create new user product with valid token and request body product_image is empty
    When Send POST Create User Product
    Then Status code should be 500 Internal Server Error
    And Response body should display create user product error message "failed to get file"
    And Validate create user product with JSON Schema "EmptyImageCreateProdSchema.json"
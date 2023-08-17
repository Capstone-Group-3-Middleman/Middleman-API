Feature: Create product to carts

  @Cart @Negative
  Scenario: [CNC-01] User create new poduct to cart without token
    Given Post Cart with "without" token
    When Send post List Cart
    Then Status code should be 400 Bad Request
    And Response body should display list cart error message "missing or malformed jwt"
    And Validate list cart with JSON Schema "InvalidPathListCartSchema.json"

  @Cart @Negative @TokenUser
  Scenario: [CNC-02] User create new poduct to cart with invalid token
    Given Post Cart with "invalid" token
    When Send post List Cart
    Then Status code should be 401 Unauthorized
    And Response body should display list cart error message "invalid or expired jwt"
    And Validate list cart with JSON Schema "InvalidPathListCartSchema.json"

  @Cart @Positive @TokenUser
  Scenario: [CNC-03] User create new product to cart with valid id
    Given Post Cart with "valid" token
    When User post cart with JSON file "ReqPost.json"
    And Send post List Cart
    Then Status code should be 201 Created
    And Response body should display message "success"
    And Validate cart with JSON Schema "JSONschemaPostSuccess.json"

  @Cart @Negative @TokenUser
  Scenario: [CNC-04] User create new products to cart with unavailable product id
    Given Post Cart with "valid" token
    When User post cart with JSON file "ReqPostUnavailableId.json"
    And Send post List Cart
    Then Status code should be 404 Not Found
    And Response body should display message "data product not found"
    And Validate cart with JSON Schema "JSONschemaPostError.json"

  @Cart @Negative @TokenUser
  Scenario: [CNC-05] User create new product to cart with valid product id and qty exceeds stock product
    Given Post Cart with "valid" token
    When User post cart with JSON file "ReqPostExceedsQTY.json"
    And Send post List Cart
    Then Status code should be 400 Bad Request
    And Response body should display message "qty exceeds product stock"
    And Validate cart with JSON Schema "JSONschemaPostError.json"

  @Cart @Positive @TokenAdmin
  Scenario: [CNC-06] Admin create new product to cart with valid product id and multiple qty
    Given Post Cart with "admin" token
    When Admin post cart with JSON file "ReqPost.json"
    And Send post List Cart
    Then Status code should be 201 Created
    And Response body should display message "success"
    And Validate cart with JSON Schema "JSONschemaPostSuccess.json"

  @Cart @Positive @TokenAdmin
  Scenario: [CNC-07] Admin create new product to cart with empty qty
    Given Post Cart with "admin" token
    When Admin post cart with JSON file "ReqPostEmptyQTY.json"
    And Send post List Cart
    Then Status code should be 400 Bad Request
    And Response body should display message "please make sure all fields are filled in correctly"
    And Validate cart with JSON Schema "JSONschemaEmpty.json"

  @Cart @Positive @TokenAdmin
  Scenario: [CNC-08] Admin create new product to cart without qty key value
    Given Post Cart with "admin" token
    When Admin post cart with JSON file "ReqBodyWithoutQTY.json"
    And Send post List Cart
    Then Status code should be 400 Bad Request
    And Response body should display message "please make sure all fields are filled in correctly"
    And Validate cart with JSON Schema "JSONschemaEmpty.json"

  @Cart @Positive @TokenAdmin
  Scenario: [CNC-09] Create new product to cart with invalid path
    Given Post Cart with "admin" token and "invalid" path
    When Admin post cart with JSON file "ReqBodyWithoutQTY.json"
    And Send post List Carts
    Then Status code should be 404 Not Found
    And Response body should display message "Not Found"
    And Validate cart with JSON Schema "JSONschemaEmpty.json"
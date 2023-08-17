Feature: Post Carts

  @Cart @Negative
  Scenario: Post cart without toke [CNC-01]
    Given Post Cart with "without" token
    When Send post List Cart
    Then Status code should be 400 Bad Request
    And Response body should display list cart error message "missing or malformed jwt"
    And Validate list cart with JSON Schema "InvalidPathListCartSchema.json"

  @Cart @Negative @TokenUser
  Scenario: Post cart invalid toke [CNC-02]
    Given Post Cart with "invalid" token
    When Send post List Cart
    Then Status code should be 401 Unauthorized
    And Response body should display list cart error message "invalid or expired jwt"
    And Validate list cart with JSON Schema "InvalidPathListCartSchema.json"

  @Cart @Positive @TokenUser
  Scenario: Post cart valid token [CNC-03]
    Given Post Cart with "valid" token
    When User post cart with JSON file "ReqPost.json"
    And Send post List Cart
    Then Status code should be 201 Created
    And Response body should display message "success"
    And Validate cart with JSON Schema "JSONschemaPostSuccess.json"

  @Cart @Negative @TokenUser
  Scenario: Post cart valid token [CNC-04]
    Given Post Cart with "valid" token
    When User post cart with JSON file "ReqPostUnavailableId.json"
    And Send post List Cart
    Then Status code should be 404 Not Found
    And Response body should display message "data product not found"
    And Validate cart with JSON Schema "JSONschemaPostError.json"

  @Cart @Negative @TokenUser
  Scenario: Post cart valid token [CNC-05]
    Given Post Cart with "valid" token
    When User post cart with JSON file "ReqPostExceedsQTY.json"
    And Send post List Cart
    Then Status code should be 400 Bad Request
    And Response body should display message "qty exceeds product stock"
    And Validate cart with JSON Schema "JSONschemaPostError.json"

  @Cart @Positive @TokenAdmin
  Scenario: Admin Post cart valid token [CNC-06]
    Given Post Cart with "admin" token
    When Admin post cart with JSON file "ReqPost.json"
    And Send post List Cart
    Then Status code should be 201 Created
    And Response body should display message "success"
    And Validate cart with JSON Schema "JSONschemaPostSuccess.json"

  @Cart @Positive @TokenAdmin
  Scenario: Admin Post cart valid token [CNC-07]
    Given Post Cart with "admin" token
    When Admin post cart with JSON file "ReqPostEmptyQTY.json"
    And Send post List Cart
    Then Status code should be 400 Bad Request
    And Response body should display message "please make sure all fields are filled in correctly"
    And Validate cart with JSON Schema "JSONschemaEmpty.json"

  @Cart @Positive @TokenAdmin
  Scenario: Admin Post cart valid token [CNC-08]
    Given Post Cart with "admin" token
    When Admin post cart with JSON file "ReqBodyWithoutQTY.json"
    And Send post List Cart
    Then Status code should be 400 Bad Request
    And Response body should display message "please make sure all fields are filled in correctly"
    And Validate cart with JSON Schema "JSONschemaEmpty.json"

  @Cart @Positive @TokenAdmin
  Scenario: Admin Post cart valid token [CNC-09]
    Given Post Cart with "admin" token and "invalid" path
    When Admin post cart with JSON file "ReqBodyWithoutQTY.json"
    And Send post List Carts
    Then Status code should be 404 Not Found
    And Response body should display message "Not Found"
    And Validate cart with JSON Schema "JSONschemaEmpty.json"
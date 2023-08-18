Feature: Update quantity product in carts

  @Cart @Negative
  Scenario: [UQP-01] Update qty of poduct to cart without token
    Given Put Cart with "without" token
    When Send put cart
    Then Status code should be 400 Bad Request
    And Response body should display list cart error message "missing or malformed jwt"
    And Validate list cart with JSON Schema "InvalidPathListCartSchema.json"

  @Cart @Negative
  Scenario: [UQP-02] Update qty of poduct to cart with invalid token
    Given Put Cart with "invalid" token
    When Send put cart
    Then Status code should be 401 Unauthorized
    And Response body should display list cart error message "invalid or expired jwt"
    And Validate list cart with JSON Schema "InvalidPathListCartSchema.json"

  @Cart @Negative @TokenUser
  Scenario: [UQP-03] Update qty of poduct to cart with invalid path
    Given Put Cart with "valid" token
    When Send put carts
    Then Status code should be 404 Not Found
    And Response body should display list cart error message "Not Found"
    And Validate list cart with JSON Schema "InvalidPathListCartSchema.json"

  @Cart @Positive @TokenUser @BUG
  Scenario: [UQP-04] User update qty of products added in cart
    Given Put Cart with "valid" token
    When Send put cart
    Then Status code should be 200 OK
    And Response body should display list cart error message "success"
    And Validate list cart with JSON Schema "InvalidPathListCartSchema.json"

  @Cart @Negative @TokenUser
  Scenario: [UQP-05] Update qty of products added in cart (authorized user) with invalid product id
    Given Put Cart with "valid" token
    When Update invalid product id "@" carts and send with JSON file "ReqBodyEmpty.json"
    And Send put cart string
    Then Status code should be 404 Not Found
    And Response body should display list cart error message "there is no cart with product id 0"
    And Validate list cart with JSON Schema "InvalidPathListCartSchema.json"

  @Cart @Negative @TokenUser
  Scenario: [UQP-06] Update qty of products added in cart (authorized user) without product id
    Given Put Cart with "valid" token
    When Update invalid product id "" carts and send with JSON file "ReqBodyEmpty.json"
    And Send put cart string
    Then Status code should be 404 Not Found
    And Response body should display list cart error message "Not Found"
    And Validate list cart with JSON Schema "InvalidPathListCartSchema.json"

  @Cart @Negative @TokenUser
  Scenario: [UQP-07] Update qty of products added in cart (authorized user) with empty body request
    Given Put Cart with "valid" token
    When Update invalid product id "1" carts and send with JSON file "ReqBodyBlank.json"
    And Send put cart string
    Then Status code should be 400 Bad Request
    And Response body should display list cart error message "qty must be filled more than 0"
    And Validate list cart with JSON Schema "InvalidPathListCartSchema.json"
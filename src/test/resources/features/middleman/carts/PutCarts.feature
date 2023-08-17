Feature: Put Carts

  @Cart @Negative
  Scenario: Put cart without token [CNC-01]
    Given Put Cart with "without" token
    When Send put cart
    Then Status code should be 400 Bad Request
    And Response body should display list cart error message "missing or malformed jwt"
    And Validate list cart with JSON Schema "InvalidPathListCartSchema.json"

  @Cart @Negative
  Scenario: Put cart without token [CNC-02]
    Given Put Cart with "invalid" token
    When Send put cart
    Then Status code should be 401 Unauthorized
    And Response body should display list cart error message "invalid or expired jwt"
    And Validate list cart with JSON Schema "InvalidPathListCartSchema.json"

  @Cart @Negative @TokenUser
  Scenario: Put cart without token [CNC-03]
    Given Put Cart with "valid" token
    When Send put carts
    Then Status code should be 404 Not Found
    And Response body should display list cart error message "Not Found"
    And Validate list cart with JSON Schema "InvalidPathListCartSchema.json"

  @Cart @Positive @TokenUser @BUG
  Scenario: Put cart without token [CNC-04]
    Given Put Cart with "valid" token
    When Send put cart
    Then Status code should be 200 OK
    And Response body should display list cart error message "success"
    And Validate list cart with JSON Schema "InvalidPathListCartSchema.json"

  @Cart @Negative @TokenUser
  Scenario: Put cart without token [CNC-05]
    Given Put Cart with "valid" token
    When Update invalid product id "@" carts and send with JSON file "ReqBodyEmpty.json"
    And Send put cart string
    Then Status code should be 404 Not Found
    And Response body should display list cart error message "there is no cart with product id 0"
    And Validate list cart with JSON Schema "InvalidPathListCartSchema.json"

  @Cart @Negative @TokenUser
  Scenario: Put cart without token [CNC-06]
    Given Put Cart with "valid" token
    When Update invalid product id "" carts and send with JSON file "ReqBodyEmpty.json"
    And Send put cart string
    Then Status code should be 404 Not Found
    And Response body should display list cart error message "Not Found"
    And Validate list cart with JSON Schema "InvalidPathListCartSchema.json"

  @Cart @Negative @TokenUser
  Scenario: Put cart without token [CNC-07]
    Given Put Cart with "valid" token
    When Update invalid product id "1" carts and send with JSON file "ReqBodyBlank.json"
    And Send put cart string
    Then Status code should be 400 Bad Request
    And Response body should display list cart error message "qty must be filled more than 0"
    And Validate list cart with JSON Schema "InvalidPathListCartSchema.json"
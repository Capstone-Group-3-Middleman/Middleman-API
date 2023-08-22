Feature: Users inventory Get

  @InventoriesGet @Negative
  Scenario: [GET-01] Get all form products inventory user (OUT) without auth token
    Given Login inventory with "without" token
    When Send get request inventory user
    Then Status code should be 400 Bad Request
    And Response body should display inventory error message "missing or malformed jwt"
    And Validate get response inventory with JSON Schema "JSONschemaGetError.json"

  @InventoriesGet @TokenInvalid @Negative
  Scenario: [GET-02] User Get all form products inventory(OUT) with expired token
    Given Login inventory with "invalid" token
    When Send get request inventory user
    Then Status code should be 401 Unauthorized
    And Response body should display inventory error message "invalid or expired jwt"
    And Validate get response inventory with JSON Schema "JSONschemaGetError.json"

  @InventoriesGet @Positive @TokenUser
  Scenario: [GET-03] User Get all form products inventory(OUT) with valid data and auth token
    Given Login inventory with "user" token
    When Send get request inventory user
    Then Status code should be 200 OK
    And Response body should display inventory success message "get data success"
    And Validate get response inventory with JSON Schema "JSONschemaGetSuccesss.json"

  @InventoriesGet @Negative @TokenUser
  Scenario: [GET-04] User Get all form products inventory(OUT) with invalid path
    Given Login inventory with "user" token
    When User update invalid inventory parameter "none"
    And Send get request inventory users
    Then Status code should be 404 Not Found
    And Response body should display inventory error message "not found"
    And Validate get response inventory with JSON Schema "JSONschemaGetError.json"

  @InventoriesGet @Negative @TokenUser
  Scenario: [GET-05] Get detail form product inventory (OUT)
    Given Login inventory with "user" token
    When User update invalid inventory id "21312"
    And Send get request inventory users
    Then Status code should be 404 Not Found
    And Response body should display inventory error message "not found"
    And Validate get response inventory with JSON Schema "JSONschemaGetError.json"

  @InventoriesGet @Negative @TokenUser
  Scenario: [GET-06] Get detail form product inventory (OUT) with invalid inventory id
    Given Login inventory with "user" token
    When User update invalid inventory id ""
    And Send get request inventory users
    Then Status code should be 404 Not Found
    And Response body should display inventory error message "Not Found"
    And Validate get response inventory with JSON Schema "JSONschemaGetError.json"

  @InventoriesGet @Negative @TokenUser
  Scenario: [GET-07] Get detail form product inventory (OUT) with invalid token
    Given Login inventory with "invalid" token
    When User update invalid inventory id ""
    And Send get request inventory users
    Then Status code should be 404 Not Found
    And Response body should display inventory error message "Not Found"
    And Validate get response inventory with JSON Schema "JSONschemaGetError.json"
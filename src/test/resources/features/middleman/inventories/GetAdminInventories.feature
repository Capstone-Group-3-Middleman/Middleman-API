Feature: Get Admin Inventory

  @InventoriesGet @Positive @TokenAdmin
  Scenario: [GETL-01] Get detail form product inventory admins (IN)
    Given Login inventory with "admin" token
    When Send get request inventory admin
    Then Status code should be 200 OK
    And Response body should display inventory success message "get data success"
    And Validate get response inventory with JSON Schema "JSONschemaGetSuccesss.json"

  @InventoriesGet @Negative @TokenAdmin
  Scenario: [GETL-02] Get detail form products inventory admins (IN) with invalid inventory id
    Given Login inventory with "admin" token
    When Admin update invalid inventory parameter "none"
    And Send get request inventory admins
    Then Status code should be 404 Not Found
    And Response body should display inventory error message "not found"
    And Validate get response inventory with JSON Schema "JSONschemaGetError.json"

  @InventoriesGet @Negative @TokenAdmin
  Scenario: [GETL-03] Get detail form products inventory admins (IN) with invalid path
    Given Login inventory with "admin" token
    When Admin update invalid inventory parameter "none"
    And Send get request inventory admins
    Then Status code should be 404 Not Found
    And Response body should display inventory error message "not found"
    And Validate get response inventory with JSON Schema "JSONschemaGetError.json"

  @InventoriesGet @Negative
  Scenario: [GETL-04] Get detail form products inventory admins (IN) with invalid bearer token
    Given Login inventory with "invalid" token
    When Admin update invalid inventory parameters "134235"
    And Send get request inventory admins
    Then Status code should be 401 Unauthorized
    And Response body should display inventory error message "invalid or expired jwt"
    And Validate get response inventory with JSON Schema "JSONschemaGetError.json"

  @InventoriesGet @Negative
  Scenario: [GETL-05] Get detail form products inventory admins (IN) without bearer token
    Given Login inventory with "without" token
    When Admin update invalids inventory parameters "134235"
    And Send get request inventory admins
    Then Status code should be 400 Bad Request
    And Response body should display inventory error message "missing or malformed jwt"
    And Validate get response inventory with JSON Schema "JSONschemaGetError.json"
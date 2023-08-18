Feature: Users inventory

  @Inventories @Negative
  Scenario: [PST-01] User create a form to list product (OUT) without auth token
    Given Login inventory with "without" token
    When Send post request inventory
    Then Status code should be 400 Bad Request
    And Response body should display inventory error message "missing or malformed jwt"
    And Validate response inventory with JSON Schema "JSONschemaPostError.json"

  @Inventories @Negative
  Scenario: [PST-02] User create a form to list product (OUT) with expired token
    Given Login inventory with "invalid" token
    When Send post request inventory
    Then Status code should be 401 Unauthorized
    And Response body should display inventory error message "invalid or expired jwt"
    And Validate response inventory with JSON Schema "JSONschemaPostError.json"

  @Inventories @Negative @TokenUser
  Scenario: [PST-03] User create a form to list product (OUT) with auth token
    Given Login inventory with "user" token
    When Users Post inventory with JSON file "ReqBodyEmpty.json"
    And Send post request inventory
    Then Status code should be 404 Not Found
    And Response body should display inventory error message "please check your outbounds, it must have a data"
    And Validate response inventory with JSON Schema "JSONschemaPostError.json"

  @Inventories @Negative @TokenUser
  Scenario: [PST-04] User create a form to list product (OUT) with auth token and empty request body
    Given Login inventory with "user" token
    When Users Post inventory with JSON file "ReqBodyEmptyValue.json"
    And Send post request inventory
    Then Status code should be 404 Not Found
    And Response body should display inventory error message "please check your outbounds, it must have a data"
    And Validate response inventory with JSON Schema "JSONschemaPostError.json"

  @Inventories @Positive @TokenUser
  Scenario: [PST-05] User create a form to list product (OUT) with valid request body
    Given Login inventory with "user" token
    When Users Post inventory with JSON file "ReqBodyPostInventory.json"
    And Send post request inventory
    Then Status code should be 201 Created
    And Response body should display inventory success message "success input data"
    And Validate response inventory with JSON Schema "JSONSchemaSucces.json"

  @Inventories @Negative @TokenUser
  Scenario: [PST-06] User create a form to list product (OUT) without unit
    Given Login inventory with "user" token
    When Users Post inventory with JSON file "ReqBodyWithoutUnit.json"
    And Send post request inventory
    Then Status code should be 404 Not Found
    And Response body should display inventory error message "please check your outbounds, it must have a data"
    And Validate response inventory with JSON Schema "JSONschemaPostError.json"

  @Inventories @Negative @TokenUser
  Scenario: [PST-07] User create a form to list product (OUT) without qty
    Given Login inventory with "user" token
    When Users Post inventory with JSON file "ReqBodyWithoutQty.json"
    And Send post request inventory
    Then Status code should be 404 Not Found
    And Response body should display inventory error message "please check your outbounds, it must have a data"
    And Validate response inventory with JSON Schema "JSONschemaPostError.json"

  @Inventories @Negative @TokenUser
  Scenario: [PST-08] User create a form to list product (OUT) with invalid path
    Given Login inventory with "user" token
    When Users Post inventory with JSON file "ReqBodyWithoutQty.json"
    And Send post request inventorys
    Then Status code should be 404 Not Found
    And Response body should display inventory error message "please check your outbounds, it must have a data"
    And Validate response inventory with JSON Schema "JSONschemaPostError.json"


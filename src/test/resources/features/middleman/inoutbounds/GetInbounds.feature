Feature: to get cart for stock user (out) and admin (in)

  @Inoutbounds @Negative
  Scenario: Get cart without auth token [PPA-01]
    Given Login inoutbounds with "without" token
    When Send get request inoutbounds
    Then Status code should be 400 Bad Request
    And Response body should display inoutbounds error message "missing or malformed jwt"
    And Validate get response inoutbounds with JSON Schema "JSONschemaGetError.json"

  @Inoutbounds @Negative @TokenInvalid
  Scenario: Get cart with expired token [PPA-02]
    Given Login inoutbounds with "invalid" token
    When Send get request inoutbounds
    Then Status code should be 401 Unauthorized
    And Response body should display inoutbounds error message "invalid or expired jwt"
    And Validate get response inoutbounds with JSON Schema "JSONschemaGetError.json"

  @Inoutbounds @Negative @TokenUser
  Scenario: User get cart [PPA-03]
    Given Login inoutbounds with "user" token
    When Send get request inoutbounds
    Then Status code should be 200 OK
    And Response body should display inoutbounds error message "get data success"
    And Validate get response inoutbounds with JSON Schema "JSONschemaGetSuccess.json"

  @Inoutbounds @Negative @TokenAdmin
  Scenario: Admin get cart [PPA-04]
    Given Login inoutbounds with "admin" token
    When Send get request inoutbounds
    Then Status code should be 200 OK
    And Response body should display inoutbounds error message "get data success"
    And Validate get response inoutbounds with JSON Schema "JSONschemaGetSuccess.json"

  @Inoutbounds @Negative @TokenAdmin
  Scenario: Get cart on invalid path [PPA-05]
    Given Admin get login inoutbounds with "user" path and "invalid" token
    When Send get request inoutbounds invalid path
    Then Status code should be 404 Not Found
    And Response body should display inoutbounds error message "Not Found"
    And Validate get response inoutbounds with JSON Schema "JSONschemaGetError.json"
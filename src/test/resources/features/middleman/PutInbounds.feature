Feature: to update quantity product in carts for stock user (out) and admin (in)

#  USER
  @Inoutbounds @Negative
  Scenario: Update qty product cart without auth token [PUT-01]
    Given Login inoutbounds with "without" token
    When Put product id "5" inoutbounds
    And Send put request inoutbounds
    Then Status code should be 400 Bad Request
    And Response body should display inoutbounds error message "missing or malformed jwt"
    And Validate response inoutbounds with JSON Schema "JSONschemaPutError.json"

  @Inoutbounds @Negative @TokenInvalid
  Scenario: Update qty product cart with expired auth token [PUT-02]
    Given Login inoutbounds with "invalid" token
    When Update valid product id "5" inoutbounds
    And Send put request inoutbounds
    Then Status code should be 401 Unauthorized
    And Response body should display inoutbounds error message "invalid or expired jwt"
    And Validate put response inoutbounds with JSON Schema "JSONschemaPutError.json"

  @Inoutbounds @Positive @TokenUser
#    BUG Because you cannot change the quantity beyond 3."
  Scenario: User update qty of product added to cart with valid id_product [PUT-03]
    Given Login inoutbounds with "user" token
    When Update valid product id "10" inoutbounds and send with JSON file "ReqPut.json"
    And Send put request inoutbounds
    Then Status code should be 200 OK
    And Response body should display inoutbounds message "success update quantity"
    And Validate put response inoutbounds with JSON Schema "JSONschemaPutSuccess.json"

  @Inoutbounds @Negative @TokenUser
  Scenario: User update qty of product added to cart with invalid id_product string value [PUT-04]
    Given Login inoutbounds with "user" token
    When Update valid product id "none" inoutbounds and send with JSON file "ReqPut.json"
    And Send put request inoutbounds
    Then Status code should be 404 Not Found
    And Response body should display inoutbounds message "data not found"
    And Validate put response inoutbounds with JSON Schema "JSONschemaPutError.json"

  @Inoutbounds @Negative @TokenUser
  Scenario: User update qty of product added to cart with empty body request [PUT-05]
    Given Login inoutbounds with "user" token
    When Update valid product id "5" inoutbounds and send with JSON file "ReqEmptyRequest.json"
    And Send put request inoutbounds
    Then Status code should be 400 Bad Request
    And Response body should display inoutbounds message "insufficient stock"
    And Validate put response inoutbounds with JSON Schema "JSONschemaPutError.json"

  @Inoutbounds @Negative @TokenUser
  Scenario: User update qty of product added to cart with string value request qty  [PUT-06]
    Given Login inoutbounds with "user" token
    When Update valid product id "5" inoutbounds and send with JSON file "ReqPutStringValue.json"
    And Send put request inoutbounds
    Then Status code should be 400 Bad Request
    And Response body should display inoutbounds message "wrong input"
    And Validate put response inoutbounds with JSON Schema "JSONschemaPutError.json"

#    ADMIN
  @Inoutbounds @Positive @TokenAdmin
  Scenario: Admin update qty of product added to cart with valid id_product [PUT-07]
    Given Login inoutbounds with "admin" token
    When Admin update valid product id "2" inoutbounds and send with JSON file "ReqPutQty.json"
    And Send put request inoutbounds
    Then Status code should be 200 OK
    And Response body should display inoutbounds message "success update quantity"
    And Validate put response inoutbounds with JSON Schema "JSONschemaPutSuccess.json"

  @Inoutbounds @Negative @TokenAdmin
  Scenario: Admin update qty of product added to cart with valid id_product [PUT-08]
    Given Login inoutbounds with "admin" token
    When Admin update valid product id "none" inoutbounds and send with JSON file "ReqPutQty.json"
    And Send put request inoutbounds
    Then Status code should be 404 Not Found
    And Response body should display inoutbounds message "data not found"
    And Validate put response inoutbounds with JSON Schema "JSONschemaPutError.json"

  @Inoutbounds @Negative @TokenAdmin
  Scenario: Admin update qty of product added to cart with empty body request [PUT-09]
    Given Login inoutbounds with "admin" token
    When Admin update valid product id "5" inoutbounds and send with JSON file "ReqEmptyRequest.json"
    And Send put request inoutbounds
    Then Status code should be 400 Bad Request
    And Response body should display inoutbounds message "insufficient stock"
    And Validate put response inoutbounds with JSON Schema "JSONschemaPutError.json"

  @Inoutbounds @Negative @TokenAdmin
  Scenario: Admin update qty of product added to cart with string value request qty [PUT-10]
    Given Login inoutbounds with "admin" token
    When Admin update valid product id "5" inoutbounds and send with JSON file "ReqPutStringValue.json"
    And Send put request inoutbounds
    Then Status code should be 400 Bad Request
    And Response body should display inoutbounds message "wrong input"
    And Validate put response inoutbounds with JSON Schema "JSONschemaPutError.json"
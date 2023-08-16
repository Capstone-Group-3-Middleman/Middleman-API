Feature: Post product added to cart on endpoint inoutbounds

#USER
  @Inoutbounds @Negative
  Scenario: Create cart without auth token [PPA-01]
    Given  Login inoutbounds with "without" token
    And Send post request inoutbounds
    Then Status code should be 400 Bad Request
    And Response body should display inoutbounds error message "missing or malformed jwt"
    And Validate response inoutbounds with JSON Schema "JSONschemaPostError.json"

  @Inoutbounds @Negative @TokenInvalid
  Scenario: User create cart with auth token and without request body [PPA-02]
    Given Login inoutbounds with "user" token
    When Send post request inoutbounds
    Then Status code should be 400 Bad Request
    And Response body should display inoutbounds error message "wrong input"
    And Validate response inoutbounds with JSON Schema "JSONschemaPostError.json"

  @Inoutbounds @Postive @TokenUser
  Scenario: User create cart with valid request body [PPA-03]
    Given Login inoutbounds with "user" token
    When "User" post inoutbounds with JSON file "ReqPostUser.json"
    And Send post request inoutbounds
    Then Status code should be 201 Created
    And Response body should display inoutbounds error message "success create product"
    And Validate response inoutbounds with JSON Schema "JSONschemaPostSuccess.json"

  @Inoutbounds @Negative @TokenUser
  Scenario: User create cart with exceeds product_id request body [PPA-04]
    Given Login inoutbounds with "user" token
    When "User" post inoutbounds with JSON file "ReqPostExceedsProductId.json"
    And Send post request inoutbounds
    Then Status code should be 404 Not Found
    And Response body should display inoutbounds error message "data not found"
    And Validate response inoutbounds with JSON Schema "JSONschemaPostError.json"

  @Inoutbounds @Negative @TokenUser
  Scenario: User create cart without product_id key and value request body [PPA-05]
    Given Login inoutbounds with "user" token
    When "User" post inoutbounds with JSON file "ReqPostWithoutProductId.json"
    When Send post request inoutbounds
    Then Status code should be 400 Bad Request
    And Response body should display inoutbounds error message "wrong input"
    And Validate response inoutbounds with JSON Schema "JSONschemaPostError.json"

  @Inoutbounds @Negative @TokenUser
  Scenario: User create cart without qty key and value request body [PPA-06]
    Given Login inoutbounds with "user" token
    When "User" post inoutbounds with JSON file "ReqPostWithoutQty.json"
    When Send post request inoutbounds
    Then Status code should be 400 Bad Request
    And Response body should display inoutbounds error message "wrong input"
    And Validate response inoutbounds with JSON Schema "JSONschemaPostError.json"

  @Inoutbounds @Negative @TokenUser
  Scenario: User create cart with qty string value request body [PPA-07]
    Given Login inoutbounds with "user" token
    When "User" post inoutbounds with JSON file "ReqPostStringValue.json"
    When Send post request inoutbounds
    Then Status code should be 400 Bad Request
    And Response body should display inoutbounds error message "wrong input"
    And Validate response inoutbounds with JSON Schema "JSONschemaPostError.json"

  @Inoutbounds @Negative @TokenUser
  Scenario: User create cart with product_id string value request body [PPA-08]
    Given Login inoutbounds with "user" token
    When "User" post inoutbounds with JSON file "ReqPostIdStringValue.json"
    When Send post request inoutbounds
    Then Status code should be 400 Bad Request
    And Response body should display inoutbounds error message "wrong input"
    And Validate response inoutbounds with JSON Schema "JSONschemaPostError.json"

#   ADMIN
  @Inoutbounds @Negative @TokenAdmin
  Scenario: Admin create cart with auth token and empty request body [PPA-09]
    Given Login inoutbounds with "admin" token
    When Send post request inoutbounds
    Then Status code should be 400 Bad Request
    And Response body should display inoutbounds error message "wrong input"
    And Validate response inoutbounds with JSON Schema "JSONschemaPostError.json"

  @Inoutbounds @Postive @TokenAdmin
  Scenario: Admin create cart with valid request body [PPA-10]
    Given Login inoutbounds with "admin" token
    When "Admin" post inoutbounds with JSON file "ReqPostAdmin.json"
    And Send post request inoutbounds
    Then Status code should be 201 Created
    And Response body should display inoutbounds error message "success create product"
    And Validate response inoutbounds with JSON Schema "JSONschemaPostSuccess.json"

  @Inoutbounds @Negative @TokenAdmin
  Scenario: Admin create cart with exceeds product_id request body [PPA-11]
    Given Login inoutbounds with "admin" token
    When "Admin" post inoutbounds with JSON file "ReqPostExceedsProductId.json"
    And Send post request inoutbounds
    Then Status code should be 404 Not Found
    And Response body should display inoutbounds error message "data not found"
    And Validate response inoutbounds with JSON Schema "JSONschemaPostError.json"

  @Inoutbounds @Negative @TokenAdmin
  Scenario: Admin create cart without product_id key and value request body [PPA-12]
    Given Login inoutbounds with "admin" token
    When "Admin" post inoutbounds with JSON file "ReqPostWithoutProductId.json"
    And Send post request inoutbounds
    Then Status code should be 400 Bad Request
    And Response body should display inoutbounds error message "wrong input"
    And Validate response inoutbounds with JSON Schema "JSONschemaPostError.json"

  @Inoutbounds @Negative @TokenAdmin
  Scenario: Admin create cart without qty key and value request body [PPA-13]
    Given Login inoutbounds with "admin" token
    When "Admin" post inoutbounds with JSON file "ReqPostWithoutQty.json"
    And Send post request inoutbounds
    Then Status code should be 400 Bad Request
    And Response body should display inoutbounds error message "wrong input"
    And Validate response inoutbounds with JSON Schema "JSONschemaPostError.json"

  @Inoutbounds @Negative @TokenAdmin
  Scenario: Admin create cart with qty string value request body [PPA-14]
    Given Login inoutbounds with "admin" token
    When "Admin" post inoutbounds with JSON file "ReqPostIdStringValue.json"
    And Send post request inoutbounds
    Then Status code should be 400 Bad Request
    And Response body should display inoutbounds error message "wrong input"
    And Validate response inoutbounds with JSON Schema "JSONschemaPostError.json"

  @Inoutbounds @Negative @TokenAdmin
  Scenario: Admin create cart with product_id string value request body [PPA-15]
    Given Login inoutbounds with "admin" token
    When "Admin" post inoutbounds with JSON file "ReqPostStringValue.json"
    And Send post request inoutbounds
    Then Status code should be 400 Bad Request
    And Response body should display inoutbounds error message "wrong input"
    And Validate response inoutbounds with JSON Schema "JSONschemaPostError.json"
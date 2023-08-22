Feature: Admin Inventory Post

  @InventoriesPost @Positive @TokenAdmin
  Scenario: [PSTL-01] Post create a form to list product admins (IN) with valid data
    Given Login inventory with "admin" token
    When Admin Post inventory with JSON file "ReqBodyInputDataInventoryAdmin.json"
    And Send post request inventory admin
    Then Status code should be 201 Created
    And Response body should display inventory success message "success input data"
    And Validate response inventory with JSON Schema "JSONschemaPostError.json"

  @InventoriesPost @Negative @TokenAdmin
  Scenario: [PSTL-02] Post create a form to list product admins (IN) with invalid qty
    Given Login inventory with "admin" token
    When Admin Post inventory with JSON file "ReqBodyInputDataInventoryAdminQtyString.json"
    And Send post request inventory admin
    Then Status code should be 400 Bad Request
    And Response body should display inventory error message "wrong input"
    And Validate response inventory with JSON Schema "JSONschemaPostError.json"

  @InventoriesPost @Negative @TokenAdmin
  Scenario: [PSTL-03] Post create a form to list product admins (IN) without qty
    Given Login inventory with "admin" token
    When Admin Post inventory with JSON file "ReqBodyPostWithoutQty.json"
    And Send post request inventory admin
    Then Status code should be 404 Not Found
    And Response body should display inventory error message "please check your inbounds, it must have a data"
    And Validate response inventory with JSON Schema "JSONschemaPostError.json"

  @InventoriesPost @Negative @TokenAdmin
  Scenario: [PSTL-04] Post create a form to list product admins (IN) without product id
    Given Login inventory with "admin" token
    When Admin Post inventory with JSON file "ReqBodyPostInventoryWithoutUnit.json"
    And Send post request inventory admin
    Then Status code should be 404 Not Found
    And Response body should display inventory error message "please check your inbounds, it must have a data"
    And Validate response inventory with JSON Schema "JSONschemaPostError.json"

  @InventoriesPost @Negative @TokenAdmin
  Scenario: [PSTL-05] Post create a form to list product admins (IN) without unit
    Given Login inventory with "admin" token
    When Admin Post inventory with JSON file "ReqBodyPostInventoryWithQtyString.json"
    And Send post request inventory admin
    Then Status code should be 400 Bad Request
    And Response body should display inventory error message "wrong input"
    And Validate response inventory with JSON Schema "JSONschemaPostError.json"

  @InventoriesPost @Negative @TokenAdmin
  Scenario: [PSTL-06] Post create a form to list product admins (IN) with invalid path
    Given Login inventory with "admin" token
    When Admin Post inventory with JSON file "ReqBodyPostInventoryWithQtyString.json"
    And Send post request inventory admins
    Then Status code should be 404 Not Found
    And Response body should display inventory error message "Not Found"
    And Validate response inventory with JSON Schema "JSONschemaPostError.json"

  @InventoriesPost @Negative @TokenAdmin
  Scenario: [PSTL-07] Post create a form to list product admins (IN) with invalid bearer token
    Given Login inventory with "invalid" token
    When Admin Post inventory with JSON file "ReqBodyPostInventoryWithQtyString.json"
    And Send post request inventory admins
    Then Status code should be 404 Not Found
    And Response body should display inventory error message "Not Found"
    And Validate response inventory with JSON Schema "JSONschemaPostError.json"

  @InventoriesPost @Negative @TokenAdmin
  Scenario: Post create a form to list product admins (IN) without bearer token [PSTL-08]
    Given Login inventory with "without" token
    When Admin Post inventory with JSON file "ReqBodyPostInventoryWithQtyString.json"
    And Send post request inventory admins
    Then Status code should be 404 Not Found
    And Response body should display inventory error message "Not Found"
    And Validate response inventory with JSON Schema "JSONschemaPostError.json"
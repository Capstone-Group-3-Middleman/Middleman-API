Feature: List Admin Products

  @ListAdminProducts @Positive
  Scenario: Get list admin product with valid path
    Given GET List Admin Product with valid path and valid token
    When Send GET List Admin Product
    Then Status code should be 200 OK
    And Response body should display admin product message "get data success"
    And Validate admin product with JSON Schema "ListAdminSchema.json"
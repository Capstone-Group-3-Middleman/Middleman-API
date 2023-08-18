Feature: Search Admin Products

  @SearchAdminProducts @Positive
  Scenario: Get Search Admin Product with valid parameter product name
    Given GET Search admin product with valid parameter product name "sabun"
    When Send GET Search admin product
    Then Status code should be 200 OK
    And Response body should display search admin product name "sabun"
    And Validate search admin product with JSON Schema "SearchAdminProductSchema.json"
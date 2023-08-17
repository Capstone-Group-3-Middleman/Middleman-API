Feature: Update Admin Products

  @UpdateAdminProduct @Positive @TokenAdmin
  Scenario: Put Update Admin Product with valid token and valid parameter id product
    Given PUT Update Admin Product with valid token and valid id "9"
    When Send PUT Update Admin Product
    Then Status code should be 200 OK
    And Response body should display update admin product success message "success update data"
    And Validate update admin product with JSON Schema "UpdateAdminProductSchema.json"
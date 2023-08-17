Feature: Create Admin Products

  @CreateAdminProducts @Positive @TokenAdmin
  Scenario: Post create new admin product with valid token and valid data
    Given POST Create new admin product with valid token and JSON file "CreateAdminProduct.json"
    When Send POST Create admin Product
    Then Status code should be 201 Created
    And Response body should display create admin product message "success adding a product"
    And Validate create admin product with JSON Schema "CreateProductAdminSchema.json"
Feature: Delete Admin Product

  @DeleteAdminProduct @Positive @TokenAdmin
  Scenario: Delete Admin Product with valid token and valid parameter id product
    Given DELETE Admin Product with valid token and valid id "2"
    When Send DELETE Admin Product
    Then Status code should be 204 No Content
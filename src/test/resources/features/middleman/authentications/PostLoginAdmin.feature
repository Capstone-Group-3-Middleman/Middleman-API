Feature: Login Admin

  @Login @Positive
  Scenario: Post Login admin with valid data
    Given POST Login with JSON file "ValidLoginAdmin.json"
    When Send POST Login
    Then Status code should be 200 OK
    And Response body should display login message "login success"
    And Validate login with JSON Schema "LoginAdminSchema.json"

  @Login @Negative
  Scenario Outline: Post Login admin with invalid data
    Given POST Login with JSON file <jsonName>
    When Send POST Login
    Then Status code should be <statusCode> Bad Request
    And Response body should display login error message <errorMsg>
    And Validate login with JSON Schema <jsonSchName>
    Examples:
      | jsonName                          | statusCode | errorMsg                      | jsonSchName                           |
      | "InvalidPassLoginAdmin.json"      | 400        | "email or password incorrect" | "InvalidPassLogAdminSchema.json"      |
      | "InvalidEmailLoginAdmin.json"     | 400        | "email or password incorrect" | "InvalidEmailLogAdminSchema.json"     |
      | "InvalidEmailPassLoginAdmin.json" | 400        | "email or password incorrect" | "InvalidEmailPassLogAdminSchema.json" |
      | "EmptyEmailLoginAdmin.json"       | 400        | "email or password incorrect" | "EmptyEmailLogAdminSchema.json"       |
      | "EmptyPassLoginAdmin.json"        | 400        | "email or password incorrect" | "EmptyPassLogAdminSchema.json"        |
      | "EmptyEmailPassLoginAdmin.json"   | 400        | "email or password incorrect" | "EmptyEmailPassLogAdminSchema.json"   |

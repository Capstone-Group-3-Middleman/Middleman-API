Feature: Login User

  @Login @Positive
  Scenario: Post Login user with valid data
    Given POST Login with JSON file "ValidLoginUser.json"
    When Send POST Login
    Then Status code should be 200 OK
    And Response body should display login message "login success"
    And Validate login with JSON Schema "LoginUserSchema.json"

  @Login @Negative
  Scenario Outline: Post Login user with invalid data
    Given POST Login with JSON file <jsonName>
    When Send POST Login
    Then Status code should be <statusCode> Bad Request
    And Response body should display login error message <errorMsg>
    And Validate login with JSON Schema <jsonSchName>
    Examples:
      | jsonName                         | statusCode | errorMsg                      | jsonSchName                          |
      | "InvalidPassLoginUser.json"      | 400        | "email or password incorrect" | "InvalidPassLogUserSchema.json"      |
      | "InvalidEmailLoginUser.json"     | 400        | "email or password incorrect" | "InvalidEmailLogUserSchema.json"     |
      | "InvalidEmailPassLoginUser.json" | 400        | "email or password incorrect" | "InvalidEmailPassLogUserSchema.json" |
      | "EmptyEmailLoginUser.json"       | 400        | "email or password incorrect" | "EmptyEmailLogUserSchema.json"       |
      | "EmptyPassLoginUser.json"        | 400        | "email or password incorrect" | "EmptyPassLogUserSchema.json"        |
      | "EmptyEmailPassLoginUser.json"   | 400        | "email or password incorrect" | "EmptyEmailPassLogUserSchema.json"   |

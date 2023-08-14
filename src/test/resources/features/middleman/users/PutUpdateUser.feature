Feature: Update user

  @UpdateUser @Positive @TokenUser
  Scenario: Update user with valid token and valid data
    Given PUT Update User with "valid" token and "valid" data
    When Send PUT Update User
    Then Status code should be 200 OK
    And Response body should display update user message "success update data"
    And Validate update user with JSON Schema "UpdateUserSchema.json"

  @UpdateUser @Negative
  Scenario: Update user with invalid token and valid data
    Given PUT Update User with "invalid" token and "valid" data
    When Send PUT Update User
    Then Status code should be 401 Unauthorized
    And Response body should display update user message "invalid or expired jwt"
    And Validate update user with JSON Schema "InvalidTokenUpdateUserSchema.json"

  @UpdateUser @Negative @TokenUser
  Scenario Outline: Update user with valid token and invalid data
    Given PUT Update User with valid token and JSON file <jsonName>
    When Send PUT Update User
    Then Status code should be <statusCode> Bad Request
    And Response body should display update user error message <errorMsg>
    And Validate update user with JSON Schema <jsonSchName>
    Examples:
      | jsonName                  | statusCode | errorMsg                             | jsonSchName                       |
      | "UpdateEmptyName.json"    | 400        | "name minimum format 2 characters"   | "EmptyNameUpdateUserSchema.json"  |
      | "UpdateEmptyEmail.json"   | 400        | "your format email is wrong"         | "EmptyEmailUpdateUserSchema.json" |
      | "UpdateEmptyPhone.json"   | 400        | "phone minimum format 10 characters" | "EmptyPhoneUpdateUserSchema.json" |
      | "UpdateEmptyPass.json"    | 400        | "your format password is wrong"      | "EmptyPassUpdateUserSchema.json"  |
      | "UpdateEmptyAddress.json" | 400        | "address can't be empty"             | "EmptyAddressUpdateSchema.json"   |

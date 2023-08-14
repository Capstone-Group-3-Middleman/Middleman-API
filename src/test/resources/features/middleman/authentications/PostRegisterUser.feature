Feature: Register User

  @Register @Positive
  Scenario: Post Register user with valid data
    Given POST Register user with JSON file "ValidRegister.json"
    When Send POST Register user
    Then Status code should be 201 Created
    And Response body should display register message "register success"
    And Validate register user with JSON Schema "ValidRegSchema.json"

  @Register @Negative
  Scenario Outline: Post Register user with invalid data
    Given POST Register user with JSON file <jsonName>
    When Send POST Register user
    Then Status code should be <statusCode> Bad Request
    And Response body should display register error message <errorMsg>
    And Validate register user with JSON Schema <jsonSchName>
    Examples:
      | jsonName                    | statusCode | errorMsg                                               | jsonSchName                  |
      | "EmpNameRegister.json"      | 400        | "name minimum format 2 characters"                     | "EmpNameRegSchema.json"      |
      | "EmpEmailRegister.json"     | 400        | "your email or handphone number is already registered" | "EmpEmailRegSchema.json"     |
      | "EmpPassRegister.json"      | 400        | "please make sure all fields are filled in correctly"  | "EmpPassRegSchema.json"      |
      | "EmpPhoneRegister.json"     | 400        | "phone minimum format 10 characters"                   | "EmpPhoneRegSchema.json"     |
      | "EmpAddrRegister.json"      | 400        | "please make sure all fields are filled in correctly"  | "EmpAddrRegSchema.json"      |
      | "ValidRegister.json"        | 400        | "your email or handphone number is already registered" | "AlreadyRegSchema.json"      |
      | "InvalidEmailRegister.json" | 400        | "your email or handphone number is already registered" | "InvalidEmailRegSchema.json" |
      | "InvalidPhoneRegister.json" | 400        | "your email or handphone number is already registered" | "InvalidPhoneRegSchema.json" |

  @Register @Negative
  Scenario: Post Register user with invalid path
    Given POST Register user with JSON file "ValidRegister.json"
    When Send POST Register user with invalid path
    Then Status code should be 404 Not Found
    And Response body should display register error message "Not Found"
    And Validate register user with JSON Schema "InvalidPathRegSchema.json"

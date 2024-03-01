@RegisterFunctionality
Feature: Validate Register Functionality

  @withallmandatoryfields
  Scenario: verify user is able to register with mandatory fields filled
    Given goto application registration page
    When user enters the following details with unique emailid
    |  firstname   |  ishu   |
    |  lastname    |  verma  |
    |  telephone   | 9999286634 |
    |  password    |  demo |
    | confirmpassword |  demo |
    And user select the policy checkbox
    And user click on continue button
    Then user account should be created successfully
    
    @withduplicateEmail
  Scenario: verify user is not able to register with duplicate EmailID
    Given goto application registration page 
    When user enters the following details with duplicate emailid
    |  firstname   |  ishu   |
    |  lastname    |  verma  |
    |  emailid     | renu.singh@gmail.com |
    |  telephone   | 9999286634 |
    |  password    |  demo |
    | confirmpassword |  demo |
    And user select the policy checkbox
    And user click on continue button
    And user should get duplicate email warning message
    
    @withoutprivacypolicy
  Scenario: verify if user is not able to register without privacy checkbox
    Given goto application registration page 
    When user enters the following details with unique emailid
    |  firstname   |  ishu   |
    |  lastname    |  verma  |
    |  telephone   | 9999286634 |
    |  password    |  demo |
    | confirmpassword |  demo |
    And user click on continue button
    And user should get proper warning message for privacy selection
   
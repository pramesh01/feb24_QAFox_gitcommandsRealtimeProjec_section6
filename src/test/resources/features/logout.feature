@LogOutFunctionality
Feature: Validating the LogOut functionlity 

  @logOut
  Scenario: verify logout scenario
    Given goto application login page
    When enter valid useremail bloggerdelhi123@gmail.com
    And enter valid password demo
    And click on login button
    Then user should be logged in to website successfully
    When click on logOUT link from breadcrumb
    And user should be logout from the application successfully

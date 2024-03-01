@LoginFunctionality
Feature: Verify login functionality
  I want to validate Login Functionality for different type of credentials

  @valid
  Scenario Outline: verifying Login for valid credentials
    Given goto application login page
    When enter valid useremail <username>
    And enter valid password <password>
    And click on login button
   Then user should be logged in to website successfully
   
   Examples:
   |            username         |      password   |
   |  bloggerdelhi123@gmail.com  |       demo      |
   |    renu.singh@gmail.com     |       demo      |
   |  bloggerdelhi123@gmail.com  |     demo        | 
   
    
    @InValid
  Scenario: verifying Login for invalid credentials
    Given goto application login page
    When enter invalid useremail "bloggerdelhi629@gmail.com"
    And enter invalid password "12345"
    And click on login button
    Then user should be prevented to be logged in to website and proper eroor message be displayed
    
    @InValidpassword
  Scenario: verifying Login for valid emailID and invalid password
    Given goto application login page
    When enter valid useremail "bloggerdelhi123@gmail.com"
    And enter invalid password "12345"
    And click on login button
    Then user should be prevented to be logged in to website and proper eroor message be displayed
    
     @InValiduseremail
  Scenario: verifying Login for Invalid emailID and Valid password
    Given goto application login page
    When enter invalid useremail "blogger.delhi111@gmail.com"
    And enter valid password "demo"
    And click on login button
    Then user should be prevented to be logged in to website and proper eroor message be displayed
    
     @withoutemailpassword
  Scenario: verifying Login for blank email and password
    Given goto application login page
    When enter blank useremail
    And enter blank password
   And click on login button
    Then user should be prevented to be logged in to website and proper eroor message be displayed

  #@tag2
  #Scenario Outline: Title of your scenario outline
   # Given I want to write a step with <name>
    #When I check for the <value> in step
   # Then I verify the <status> in step

    #Examples: 
     # | name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |

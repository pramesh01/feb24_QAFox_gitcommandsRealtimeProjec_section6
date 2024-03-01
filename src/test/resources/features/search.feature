@SearchFunctionality
Feature: Validating Search functionality

  @searchforvalidItem
  Scenario: user searched for valid product
    Given goto application primary search page 
    When user enters the product "HP" in searchbox
    And user clicks on search button
    Then user should get the product displayed in search results
    
    @searchforInvalidItem
  Scenario: user searched for invalid product
    Given goto application primary search page 
    When user enters the product "makeup" in searchbox
    And user clicks on search button
    Then user should get the proper warning message item not available
    

  #@tag2
  #Scenario Outline: Title of your scenario outline
   # Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step

    #Examples: 
     # | name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
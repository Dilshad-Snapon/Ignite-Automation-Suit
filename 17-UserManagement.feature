Feature: User management

   @Run17
  Scenario: Validate User management page
    Given User is at Dashboard page
    When User select User Management from admin dropdown
    Then User Management page should be open succesfully
    
     @Run17
  Scenario: Validate Search user option for existing user
    Given User is at Dashboard page
    When User search existing user
    Then User should be able to edit searched user
    
     @Run17
  Scenario: Validate create user functionality
    Given User is at Dashboard page
    When User click on create user button
    Then User should be able to create user
    
     @Run17
  Scenario: Validate Clone user functionality
    Given User is at Dashboard page
    When User click on Clone button
    Then User should be able to clone user
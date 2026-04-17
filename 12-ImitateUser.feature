Feature: Imitate User


 @Run12
  Scenario: Imitate User option in user setting
    Given User is at Dashboard page
    When User click on user setting 
    Then User should see imitate option
    
     @Run12
  Scenario: Imitate User 
    Given User is at Dashboard page
    When User enter user for imitate
    Then User should be able to imitate user 
    
     @Run12
  Scenario: Browse component for user through imitate
    Given User is at Dashboard page
    When User move to component
    Then User should be able to perform operation on selected component
    
     @Run12
  Scenario: Exit imitate
    Given User is at Dashboard page
    When User click on remove user option from imitate
    Then User should be able to navigate back to NSC user
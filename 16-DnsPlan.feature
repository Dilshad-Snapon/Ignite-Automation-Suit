Feature: DNS Plan

   @Run16
  Scenario: Validate DNS plan page
    Given User is at Dashboard page
    When User select Dns plan from menu button
    Then Dns Plan page should be open succesfully
    
     @Run16
  Scenario: Validate DNS plan appear for Global selection
    Given User is at Dashboard page
    When User select global from network hierarchy for DNS Plan
    Then Dns Plan page should be open succesfully
    
         @Run16
  Scenario: Validate DNS plan appear for Market selection
    Given User is at Dashboard page
    When User select market from network hierarchy for DNS Plan
    Then Dns Plan page should be open succesfully
    
         @Run16
  Scenario: Validate DNS plan appear for Dealer selection
    Given User is at Dashboard page
    When User select dealer from network hierarchy for DNS Plan
    Then Dns Plan page should be open succesfully
    
   
     @Run16
  Scenario: Validate planType selection
    Given User is at Dns plan page
    When  User select year for plan
    Then Selected year plan should be available 
    
     @Run16
  Scenario: Validate new plan creation
    Given User is at Dns plan page
    When  User create new plan
    Then New Plan should be created succesfully
    
       @Run16#
  Scenario: Validate plan savAs functionalty 
    Given User is at Dns plan page
    When  User click on saveAs plan
    Then New plan with different name should be created
    
     @Run16#
  Scenario: Validate plan excel download
    Given User is at Dns plan page
    When  User click on excel button
    Then  Plan should be downloaded in excel format
    
     @Run16#
  Scenario: Validate plan PDF download
    Given User is at Dns plan page
    When  User click on PDF button
    Then  Plan should be downloaded in PDF format
    
     @Run16#
  Scenario: Validate plan Session control functionality
    Given User is at Dns plan page
    When  User click on session control button
    Then  User should see option to give access to other user
    
     @Run16#
  Scenario: Validate select currency for plan
    Given User is at Dns plan page
    When  User click on select currency
    Then  User should see option to select currency 
    
    @Run16#
  Scenario: Validate close plan option
    Given User is at Dns plan page
    When  User click on close plan button
    Then  Plan should be closed
    
     @Run16#
  Scenario: Validate Clear plan data option
    Given User is at Dns plan page
    When  User click on clear plan items
    Then  User entered data should be removed from plan
    
     @Run16#
  Scenario: Validate Screens selection
    Given User is at Dns plan page
    When  User select screen
    Then Screen should be selected succesfully
    
    @Run16#
  Scenario: Validate plan delete functionality
    Given User is at Dns plan page
    When  User click on delete plan button
    Then Plan should be deleted succesfully
    
          @Run16#
  Scenario: Validate plan submit functionality
    Given User is at Dns plan page
    When  User click on submit plan
    Then Plan should be submit succesfully
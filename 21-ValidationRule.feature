Feature: Validation Rule Editor 

  @Run21
  Scenario: Validate Validation Rule Editor page
    Given User is at Dashboard Page
    When User move to Validation Rule Editor page
    Then Validation Rule Editor page should open successfully
  
    
    
  @Run21
  Scenario: Validate edit
   Given User is at Dashboard Page
  When User edit validation rule
  Then User should be able to edit rule  
  
    
  @Run21
  Scenario: Validate Search
   Given User is at Dashboard Page
  When User Search Validation
  Then User should be able to search
  
    @Run21
  Scenario: Validate Download
   Given User is at Dashboard Page
  When User Downlaod Validation
  Then User should be able to Download Vaidation
  
  
  
   @Run21
  Scenario: Validate Save
   Given User is at Dashboard Page
  When User Save Validation
  Then User should be able to Save Validation
  
   @Run21
  Scenario: Validate Cancel
   Given User is at Dashboard Page
  When User Cancel Validation
  Then User should be able to Cancel Validation
  
  
   @Run21
  Scenario: Validate Filter
   Given User is at Dashboard Page
  When User Filter Validation Rule
  Then User should be able to Filter Validation Rule
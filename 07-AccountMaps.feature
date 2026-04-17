#Author: dilshad.a.chauhan@snapon.com

Feature: Account Maps Scenarios

  @Run7
  Scenario: Validate account maps page
    Given User is at Dashboard page
    When User move to Account maps page
    Then account maps page should open successfully
    
  @Run7
  Scenario: Validate new charts of accounts creation
    Given User is at Account maps page
    When User create new charts of accounts
    Then charts of accounts created successfully
    
    @Run7
  Scenario: Validate new map creation
    Given User is at Account maps page
    When User create new map 
    Then new map created successfully
    
     @Run7
  Scenario: Validate edit account map functionality
    Given User is at Account maps page
    When User edit account map 
    Then account map shoud be edit and close successfully
    
     @Run7
  Scenario: Validate Download functionality
    Given User is at Account maps page
    When User download account map 
    Then account map should be downloaded 
    
     
     @Run71
  Scenario: Validate Assign functionality
    Given User is at Account maps page
    When User click on assign button 
    Then account map assign details should open 
    
   @Run7
  Scenario: Validate Map delete functionality
    Given User is at Account maps page
    When User delete account map 
    Then account map should be deleted 
    
     @Run7
  Scenario: Validate Chart delete functionality
    Given User is at Account maps page
    When User delete Chart of account
    Then Chart of account should be deleted 
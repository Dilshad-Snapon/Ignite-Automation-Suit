#Author: dilshad.a.chaihan@snapon.com


Feature: Validate DNS Submit Scenarios

  @Run5
  Scenario: Validate DNS Submit page is avilable to perform its opertions
    Given User is at Dashboard page
    When User navigate to DNS submit page
    Then DNS submit page open successfully
    
  @Run5
  Scenario: Validate Period Selector in DNS Submit
    Given User is at DNS submit page
    When User select period from period selector
    Then User should be able select period
    
    @Run5
  Scenario: Validate View Close Dates in DNS Submit
    Given User is at DNS submit page
    When User click on View Close Dates button
    Then User should be able see and close it
    
      @Run#
  Scenario: Validate Input Options in DNS Submit
    Given User is at DNS submit page
    When User click on input options button
    Then User should be able perform all input options functionality
    
       @Run5
  Scenario: Validate Carry forward in DNS Submit
    Given User is at DNS submit page
    When User click on Carry forward button
    Then User should be able perform Carry forward scenarios
    
     @Run5
  Scenario: Validate Input form in DNS Submit
    Given User is at DNS submit page
    When User edit input form for selected period
    Then User should be able perform input form operations

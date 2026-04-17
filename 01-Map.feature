#Author: dilshad.a.chauhan@snapon.com
Feature: Map

  @Run1A
  Scenario: Map view is accessable for Global user
    Given User is at Dashboard page
    When User move to map view from Global selection
    Then Map should be accessable Global user

  @Run1
  Scenario: Map view is accessable for market user
    Given User is at Dashboard page
    When User move to map view from market selection
    Then Map should be accessable to Market user

  @Run1
  Scenario: Map view is accessable for dealer through NSC User
    Given User is at Dashboard page
    When User move to map view from dealer selection
    Then Map should not be accessable to dealer user

  @Run1
  Scenario: Map view at full page
    Given User is at Map page
    When User click on full page map view button
    Then Map should be view at full page

  @Run1
  Scenario: Department selection in map
    Given User is at Map page
    When User click on department options
    Then selected department should visible

  @Run1
  Scenario: KPI selection in map
    Given User is at Map page
    When User click on department KPI options
    Then selected department kpi should visible
    
    @Run1
  Scenario: Map Zoom In and Zoom Out
    Given User is at Map page
    When User click on Zoom in and Zoom out Btn
    Then Map size should be changed accordingly
    
     @Run1
  Scenario: Select Market on map 
    Given User is at Map page
    When User click on any market on map
    Then selected country details should appear on dashboard
    
     @Run1
  Scenario: Select Dealer on map 
    Given User is at Map page
    When User click on any dealer
    Then selected dealer details should appear on dashboard
    
     @Run1
  Scenario: Navigate to dashboard page
    Given User is at Map page
    When User click on dasboard page button
    Then User should move back to dashboard page
    
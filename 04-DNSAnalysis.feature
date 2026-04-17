Feature: DNS Analysis Scenarios

  @Run4
  Scenario: Validate Dns Analysis page
    Given User is at Dashboard page
    When User move to Dns analysis page
    Then Dns Analysis should open successfully
    
      @Run4
  Scenario: Validate Market selection for Analysis
    Given User is at Dns Analysis page
    When User select market from dropdown
    Then Market should be selected successfully
    
         @Run4
  Scenario: Validate Tools selection for Analysis
    Given User is at Dns Analysis page
    When User select tools from dropdown
    Then Tools should be selected successfully
    
     @Run4
  Scenario: Validate Grid selection for Analysis
    Given User is at Dns Analysis page
    When User select grid for Selection
    Then Grid should be selected successfully
    
     @Run4
  Scenario: Validate Network selection 
    Given User is at Dns Analysis page
    When User click on Network column
    Then user should be able to select network
    
     @Run4
  Scenario: Validate Items row for Analysis
    Given User is at Dns Analysis page
    When User click on item row
    Then Item should be added into grid
    
     @Run4
  Scenario: Validate report picker item selection
    Given User is at Dns Analysis page
    When User click on item in report picker
    Then Item should be added into grid from report picker
    
      @Run4
  Scenario: Validate Period selection 
    Given User is at Dns Analysis page
    When User click on period column
    Then user should be able to select Analysis period
    
     @Run4
  Scenario: Validate Measure selection 
    Given User is at Dns Analysis page
    When User click on Measure column
    Then user should be able to select Measure
    
     @Run4
  Scenario: Validate excel download of analysis grid
    Given User is at Dns Analysis page
    When User click on excel btn
    Then Excel should be downloaded successfully 
    
      @Run4
  Scenario: Validate custom composite Manager
    Given User is at Dns Analysis page
    When User select custom composite manager
    Then User should be able to create custom composite
    
      @Run4
  Scenario: Validate custom composite delete
    Given User is at Dns Analysis page
    When User delete custom composite
    Then User should be able to delete custom composite
    
       @Run4
  Scenario: Validate Bulk data dump tool selection
    Given User is at Dns Analysis page
    When User click on tool dropdown btn
    Then User should be able to select Bulk data dump tool
    
           @Run4
  Scenario: Validate measure selection in Bulk data tool
    Given User is at Dns Analysis page
    When User click on measure btn
    Then User should be able to select measure
    
           @Run4
  Scenario: Validate Dealer selection in Bulk data tool
    Given User is at Dns Analysis page
    When User click on Dealer btn
    Then User should be able to select Dealer for Bulk data
     @Run4
  Scenario: Validate Item selection in Bulk data tool
    Given User is at Dns Analysis page
    When User click on Item btn
    Then User should be able to select Item
     @Run4
  Scenario: Validate Period selection in Bulk data tool
    Given User is at Dns Analysis page
    When User click on Period btn
    Then User should be able to select Period
     @Run4
  Scenario: Validate Bulk data Excel Download
    Given User is at Dns Analysis page
    When User click on Excel file
    Then User should be able to download file
    

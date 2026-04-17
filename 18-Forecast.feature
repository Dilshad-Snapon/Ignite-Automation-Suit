Feature: Forecast 

  @Run18
  Scenario: Validate DNS Forecast page
    Given User is at Dashboard page
    When User select Forecast tool
    Then Forecast page should be open succesfully
    
     @Run18
  Scenario: Validate forecast appear for Global selection
    Given User is at Dashboard page
    When User select global from network hierarchy for Forecast
    Then Forecast page should be open succesfully
    
         @Run18
  Scenario: Validate forecast appear for Market selection
    Given User is at Dashboard page
    When User select market from network hierarchy for Forecast
    Then Forecast page should be open succesfully
    
         @Run18
  Scenario: Validate forecast appear for Dealer selection
    Given User is at Dashboard page
    When User select dealer from network hierarchy for Forecast
    Then Forecast page should be open succesfully
    
     @Run18
  Scenario: Validate Network and Model selection
    Given User is at DNS Forecast page
    When User select dealer and model from forecast page
    Then Dealer and model should be selected successfully
    
    
     @Run18
    Scenario: Validate create forecast for dealer
    Given User is at DNS Forecast page
    When  User create forecast for dealer
    Then Forecast should created successfully 
    
      @Run18
    Scenario: Validate Save and Save As option for forecast
    Given User is at DNS Forecast page
    When  User click on save and Save As buttons 
    Then Forecast Should be saved successfully
    
    @Run18
    Scenario: Validate excel download of forecast
    Given User is at DNS Forecast page
    When  User open forecast for dealer and click on excel btn
    Then Excel report should downloaded successfully
    
    
    @Run18
  Scenario: Validate create forecast for next year
    Given User is at DNS Forecast page
    When  User open forecast for dealer and click on next year forecast
    Then Next year forecast should created successfully
    
    @Run18
  Scenario: Validate reset forcast functionality
    Given User is at DNS Forecast page
    When  User click reset button 
    Then Entered Forecast Data shoule be cleared
    
    @Run18
  Scenario: Validate Private and Published forecast functionality
    Given User is at DNS Forecast page
    When  User click on private and Published buttons 
    Then  Forecast should be private and published
    
     @Run18
  Scenario: Validate Delete forecast functionality
    Given User is at DNS Forecast page
    When  User  click on delete button 
    Then  Forecast should be deleted
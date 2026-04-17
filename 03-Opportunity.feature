Feature: Opportunity


     @Run3
  Scenario: Opportunity details are appearing for selected Dealer
    Given User is at Dashboard page
    When User select Dealer from network hierarchy for Opportunity
    Then Opportunity should appear for selected dealer
    
     @Run3
  Scenario: Opportunity details are appearing for different average selection
    Given User is at Dashboard page
    When User select average for opportunity
    Then Opportunity should appear for selected average
    
     @Run3
  Scenario: Opportunity details are appearing for different department selection
    Given User is at Dashboard page
    When User select department for opportunity
    Then Opportunity should appear for selected department
    
     @Run3
  Scenario: Opportunity details are appearing for different period selection
    Given User is at Dashboard page
    When User select period for opportuniy
    Then Opportunity should appear for selected period
    
    @Run3
  Scenario: Close network selector dropdown
    Given User is at Dashboard page
    When User click on network selector filter buton
    Then User should be able to close network selector
#Author: dilshad.a.chauhan@snapon.com

Feature: Dealer Profile

  @Run8
  Scenario: Validate dealer profile is accessable and viewable 
    Given User is at Dashboard page
    When User select dealer profile from menu button
    Then User profile shoule be open succesfully
    
  @Run8
  Scenario: Validate dealer profile is available to edit 
    Given User is at Dealer profile page
    When User edit dealer profile
    Then User profile shoule be save successfully
Feature: Geo Generator


 @Run19
  Scenario: NSC user can open Geo Generator
    Given User is at Dashboard page
    When User selects Administration and goes to Geo Generator
    Then Geo Generator should appear                                                
 
  @Run19#
  Scenario: Non-admin cannot see Geo Generator in menu
    Given User is at Dashboard page as NON_ADMIN
    When User looks for Geo Generator option in Administration
    Then Geo Generator menu should not be visible
 
  @Run19#
  Scenario: Non-admin blocked from direct URL access
    Given User is at Dashboard page as NON_ADMIN
    When User opens Geo Generator via direct URL
    Then Authorization error or redirect should appear
   
   @Run19
  Scenario: Reload clears resolved records
    Given User is at Dashboard page
    When User clicks Reload
    Then Grid should refresh and show zero records if all resolved
 
  @Run19
  Scenario: Fetch locations for all listed dealers succeeds
    Given User is at Dashboard page
    When User selects Administration and fetch Geo Generator locations
    Then Latitude and Longitude should be populated for each row
    
 
  @Run19
  Scenario: Save populated coordinates succeeds
    Given User is at Dashboard page
    When User clicks Save
    Then Coordinates should be saved successfully
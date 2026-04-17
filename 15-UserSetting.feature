Feature: User Application Setting

  @Run15
  Scenario: User application setting
    Given User is at Dashboard page
    When User click on setting button
    Then User settings should open
    
    @Run15
  Scenario: Change Password
    Given User is at Dashboard page
    When User click on change password button
    Then Change password pop up should appear
    
     @Run15
  Scenario: Setting button
    Given User is at Dashboard page
    When User click on setting button
    Then User should be able to change application setting
    
      @Run15
  Scenario: Help and Support
    Given User is at Dashboard page
    When User click on help and support button
    Then User should be able to change application setting
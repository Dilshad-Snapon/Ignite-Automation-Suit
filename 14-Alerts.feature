Feature: Alerts
 
   @Run14
  Scenario: Validate Alert page
   Given User is at Dashboard page
    When The user click on alert button
    Then User should be able to see alert page
    
  @Run14
  Scenario: Validate alert message/Description
   Given User is at alert page
    When The user click on alert name
    Then User should be able to see alert message
    
  @Run14
  Scenario: Validate Read alerts
   Given User is at alert page
    When The user mark alert as read
    Then Alert should move to Read section
    
  @Run14
  Scenario: Validate Flagged alert
   Given User is at alert page
    When The user mark alerts as flagged
    Then Alert should move to flagged section
    
  @Run14
  Scenario: Validate Critical alert
   Given User is at alert page
    When The user mark alerts as critical
    Then Alert should move to critical section
    
  @Run14
  Scenario: Validate delete alert
   Given User is at alert page
    When The user mark alerts as hide
    Then Alert should move to deleted section
    
  @Run14
  Scenario: Validate Unread alert
   Given User is at alert page
    When The user click on unread button
    Then User should able to see all unread alerts
    
  @Run14
  Scenario: Validate alert search 
   Given User is at alert page
    When The user search alert in search bar
    Then User should able to see searched alert
    
  @Run14
  Scenario: Validate alert popup on startUp page
   Given User is at alert page
    When The user alert startup page enable button
    Then User should able to see alert on startup page
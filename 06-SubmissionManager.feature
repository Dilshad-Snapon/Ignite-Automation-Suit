#Date: 27March24


Feature: NSC Submission Manager

  @Run6
  Scenario: Validate Submission Manager page
    Given User is at Dashboard page
    When User select submission manager from menu button
    Then Submission Manager page should be open succesfully
    
   
     @Run6
  Scenario: Validate Submission market selection
    Given User is at Submission Manager page
    When User select market from submission manager
    Then Selected market should appear 
    
     @Run6
  Scenario: Validate Submission Period selection
    Given User is at Submission Manager page
    When User select period from submission manager
    Then Selected period should appear 
    
     @Run6
  Scenario: Validate Submission dealer input form download
    Given User is at Submission Manager page
    When User select dealer for input form download
    Then Selected dealer input form should downloaded 
    
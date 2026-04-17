Feature: NewsFlash Manager

  @Run9
  Scenario: Validate NewsFlash Manager page
    Given User is at Dashboard page
    When User select NewsFlash manager from menu button
    Then NewsFlash Manager page should be open succesfully
    
    @Run9
  Scenario: Validate New NewsFlash creation 
    Given User is at Newsflash page
    When User create new newsflash
    Then NewsFlash should be created succesfully
    
     @Run9
  Scenario: Validate NewsFlash edit option 
    Given User is at Newsflash page
    When User click on editing exiting newsflash
    Then NewsFlash should be edited succesfully
    
    @Run9
  Scenario: Validate NewsFlash delete option 
    Given User is at Newsflash page
    When User click on delete exiting newsflash
    Then NewsFlash should be deleted succesfully
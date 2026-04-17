#Author: your.email@your.domain.com

Feature: DNS published Reports Scenarios

  @Run10
  Scenario: Validate published Reporting page
    Given User is at Dashboard page
    When User move to published reports page
    Then published reports page should open successfully
    
      @Run10
  Scenario: Validate Report dropdown for all reports option
    Given User is at published report page
    When User click on report dropdown button
    Then user should be able to select any report type
    
     @Run10
  Scenario: Validate period dropdown for reports
    Given User is at published report page
    When User click on period dropdown button
    Then user should be able to select any period
    
        @Run10
  Scenario: Validate Default user selections
    Given User is at published report page
    When User click on Set Default setting button
    Then Reports selection should remain same everytime report page opens
    
      @Run10
  Scenario: Validate Filter Hide/unhide on page
    Given User is at published report page
    When User click on filter hide/unhide button
    Then Filter hide/unhide as per selection
    
      @Run10
  Scenario: Validate select all and unselect all reports options
    Given User is at published report page
    When User click on select all and unselect all option
    Then Reports should get selected and unselected
    
     @Run10
  Scenario: Validate pdf and Excel download button
    Given User is at published report page
    When User click on pdf and excel button of report
    Then pdf and exl version of report should be downloaded 
    
      @Run10
  Scenario: Validate Zip file download option
    Given User is at published report page
    When User select few reports 
    Then Selected reports zip file should be downloaded 
    
 
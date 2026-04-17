#Author: your.email@your.domain.com

Feature: DNS Flexible Reports Scenarios

  @Run11
  Scenario: Validate flexible Reporting page
    Given User is at Dashboard page
    When User move to flexible reports page
    Then Flexible reports page should open successfully
    
       @Run11
  Scenario: Validate Report dropdown for all reports option
    Given User is at Flexible report page
    When User click on flexible report dropdown button
    Then user should be able to select flexible report type
    
      @Run11
  Scenario: Validate Dealer selection for Flexible report
    Given User is at Flexible report page
    When User click on  Dealer selection edit btn
    Then user should be able to select dealer
    
          @Run11
  Scenario: Validate Second Dealer selection for Flexible report
    Given User is at Flexible report page
    When User click on Second Dealer selection edit btn
    Then user should be able to select Second dealer
     
       @Run11
  Scenario: Validate Dealer selection dismiss from Flexible report
    Given User is at Flexible report page
    When User click on selected Dealer Delete btn
    Then user should be able to remove dealer
    
    @Run11
  Scenario: Validate Filter Hide/unhide on page
    Given User is at Flexible report page
    When User click on filter hide/unhide button
    Then Filter hide/unhide as per selection
    
     @Run11
  Scenario: Validate superflex report department selection
    Given User is at Flexible report page
    When User click on superflex pages
    Then user should be able to select pages
    
     @Run11
  Scenario: Validate superflex report saving option
    Given User is at Flexible report page
    When User click on report save option
    Then Report should be saved successfully
    
    @Run11
  Scenario: Validate superflex report ZoomIn and ZoomOut Option
    Given User is at Flexible report page
    When User click on Report zoom In and Zoom Out Option
    Then Report size should be changing accordingly
    
        @Run11
  Scenario: Validate superflex report Download btn
    Given User is at Flexible report page
    When User click on superflex report download btn
    Then Report should be downloaded successfully
    
    @Run#
  Scenario: Validate superflex report look&Fell
    Given User is at Flexible report page
    When User click on report page expand btn
    Then Report page color and logo should remain same
    
    @Run#
  Scenario: Validate superflex user saved setting functionality
    Given User is at Flexible report page
    When User click on save user setting btn
    Then User should be able to add, reload and delete user settings
    
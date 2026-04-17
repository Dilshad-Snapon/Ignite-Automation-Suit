Feature: DNS Library


    
    @Run13
  Scenario: Validate DNS Library page
   Given User is at Dashboard page
    When The user click on DNSLibrary dropdown
    Then User should be able to see DNSLibrary
    
   @Run13
  Scenario: validate DNS Library document upload
   Given User is at DNS Library page
    When The user click on upload document
    Then User should be able to upload document successfully
     
    
   @Run13
  Scenario: Validate DNS library document view
   Given User is at DNS Library page
    When The user click on document to view
    Then Document should be open   
    
    
   @Run13
  Scenario: Validate DNS library document Delete
   Given User is at DNS Library page
    When The user click on document to delete
    Then Document should be deleted
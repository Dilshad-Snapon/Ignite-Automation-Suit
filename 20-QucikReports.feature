Feature: Quick Reports

@Run20
  Scenario: Quick Reports visible for Dealer user
    Given User is at Dashboard Page
    When User navigates to Dashboard and scrolls to Quick Reports
    Then Quick Reports panel should be visible for Dealer
 
   
@Run20
  Scenario: Quick Reports Download
    Given User is at Dashboard Page
    When User go to Quick reports and download excel
    Then Quick Reports should be download in excel
 
@Run20
  Scenario: Quick Reports Download
    Given User is at Dashboard Page
    When User go to Quick reports and download pdf
    Then Quick Reports should be download in pdf
 
@Run20#
  Scenario: Dealer sees only Dealer reports and MANACS (not National)
    Given User is at Dashboard Page
    When User go to Quick Reports
    Then Only Dealer Composite and MANACS rows should be visible
Feature: Test


 @Run25
  Scenario Outline: Validate Multiple Systems application login
    Given Login Testdata as "<TestCondition>" "<Application_URL>" "<UserName>" "<Password>"
    Given Browser is launched
    When  User enter login details
    Then  User should able to login and Logout from application

    Examples: 
      | TestCondition  | Application_URL                                                             | UserName  | Password  |
      | System1        | https://staging2.network-perf.com/stellantis2/index.html?snaponskip=true    | NSC       | nsc       | 
      | System2        | https://renaultww.nx-services.com/reneu-dnsangular/index.html               | HIMANSHU  | Password  | 
     #| System3        | NissanEU                                                                    | UserName  | Password  | 
     
     
     @Run25!
  Scenario: Login into Stellantis system
    Given User logout from current system
    When User enter stellantis system login credentials
    Then User should be able to login into application
  


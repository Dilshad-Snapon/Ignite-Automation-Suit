# Valid Login feature
Feature: Valid Login

  @Run0
  Scenario: Valid Application Login
    Given Application Is Launched
    Then Login Page available to login

  @Run#
  Scenario: Help and support scenario
    Given User is at login page
    When User click on help contact button
    Then Help windown should open

  @Run0
  Scenario: Login with credentails into application
    Given User is at login page
    When User enter valid login credentials
    Then User should be able to login into application

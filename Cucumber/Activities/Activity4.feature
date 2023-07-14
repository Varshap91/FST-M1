@activity4
Feature: Feature to test data driven test without example


  Scenario: Testing Login without Examples
    Given User is on Login page
    When User enters "admin" and "password"
    Then Verify the confirmation message
    Then Close the browser
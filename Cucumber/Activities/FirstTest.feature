@SmokeTest
Feature: Basic Syntax

  @Scenario1
  Scenario: This is the first scenario
    Given the user is on the TS page
    When the user click on the About Us link
    Then the user is redirected to About page
    Then Close the browser


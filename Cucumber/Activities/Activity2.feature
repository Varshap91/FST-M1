@activity2
Feature: Login Test


  Scenario: Testing Login
    Given User is on Login page
    When User enters "admin" and "password"
    Then Read the page title and confirmation message
    Then Close the browser
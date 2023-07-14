@activity3
Feature: Testing with Tags

  @SimpleAlert @SmokeTest1
  Scenario: Testing with Simple Alert
    Given User is on the page
    When User clicks the Simple Alert button
    Then Alert opens
    Then Read the text from it and print it
    Then Close the alert
    Then Close the browser

  @ConfirmAlert
  Scenario: Testing with Confirm Alert
    Given User is on the page
    When User clicks the Confirm Alert button
    Then Alert opens
    Then Read the text from it and print it
    Then Close the alert with Cancel
    Then Close the browser

  @PromptAlert
  Scenario Outline: Testing with Prompt Alert
    Given User is on the page
    When User clicks the Prompt Alert button
    Then Alert opens
    Then Read the text from it and print it
    Then Write a custom "<message>" in it
    Then Close the alert
    Then Close the browser
    Examples:
      | message |
      | Test message |
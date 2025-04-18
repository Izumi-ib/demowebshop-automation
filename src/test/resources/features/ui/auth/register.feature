@ui @regression
Feature: User registration feature
  Scenario: User registers with valid credentials
    Given the user is on the registration page
    When the user enters personal details 'Male', 'firstName', 'lastName' and 't79916769+6@gmail.com'
    And the user enters password 'asda1231' and confirm password 'asda1231'
    And the user clicks register button
    Then the user should see 't79916769+6@gmail.com' on the home page
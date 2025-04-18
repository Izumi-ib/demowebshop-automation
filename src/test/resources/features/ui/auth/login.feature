@ui @regression
Feature: User login feature

  Scenario: User logs in with valid credentials
    Given the user is on the login page
    When the user enters email 't79916769@gmail.com' and password '123456' to log in
    And clicks the login button
    Then the user should see 't79916769@gmail.com' on the home page

  Scenario: User logs in with invalid credentials
    Given the user is on the login page
    When the user enters email 't799169@gmail.com' and password 'as54879' to log in
    And clicks the login button
    Then the user should see login unsuccessful 'Login was unsuccessful. Please correct the errors and try again.' message

  Scenario: User is on the Home page
    Given the user is on the login page

  Scenario: User logs in
    Given the user is on the login page
    When the user enters email 't799169@gmail.com' and password 'as54879' to log in
    And clicks the login button
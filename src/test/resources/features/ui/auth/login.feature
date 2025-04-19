@ui @regression
Feature: User login feature

  Background:
    Given the user is on the login page

  Scenario: User logs in with valid credentials
    When the user enters email 't79916769@gmail.com' and password '123456' to log in
    And clicks the login button
    Then the user should see 't79916769@gmail.com' on the home page

  Scenario: User logs in with invalid credentials
    When the user enters email 't799169@gmail.com' and password 'as54879' to log in
    And clicks the login button
    Then the user should see login unsuccessful 'Login was unsuccessful. Please correct the errors and try again.' message

  Scenario: User logs in with empty credentials
    When the user enters email '' and password '' to log in
    And clicks the login button
    Then the user should see login unsuccessful 'Login was unsuccessful. Please correct the errors and try again.' message

  Scenario: User logs in with invalid email format
    When the user enters email 'invalidemail' and password '123456' to log in
    And clicks the login button
    Then the user should see invalid email error message 'Please enter a valid email address.'

  Scenario: User logs in with valid email and wrong password
    When the user enters email 't79916769@gmail.com' and password 'wrongpass' to log in
    And clicks the login button
    Then the user should see login unsuccessful 'Login was unsuccessful. Please correct the errors and try again.' message
@ui @regression
Feature: User login feature

  Background:
    Given the user is on 'login' page

  @TC_201
  Scenario: User logs in with valid credentials (TC_201)
    When the user enters email 't79916769@gmail.com' and password '123456' to log in
    And clicks the login button
    Then the user should see 't79916769@gmail.com' on the home page

  @TC_202
  Scenario: User logs in with invalid credentials (TC_202)
    When the user enters email 't799169@gmail.com' and password 'as54879' to log in
    And clicks the login button
    Then the user should see login unsuccessful 'Login was unsuccessful. Please correct the errors and try again.' message

  @TC_203
  Scenario: User logs in with empty credentials (TC_203)
    When the user enters email '' and password '' to log in
    And clicks the login button
    Then the user should see login unsuccessful 'Login was unsuccessful. Please correct the errors and try again.' message

  @TC_204
  Scenario: User logs in with invalid email format (TC_204)
    When the user enters email 'invalidemail' and password '123456' to log in
    And clicks the login button
    Then the user should see invalid email error message 'Please enter a valid email address.'

  @TC_205
  Scenario: User logs in with valid email and wrong password (TC_205)
    When the user enters email 't79916769@gmail.com' and password 'wrongpass' to log in
    And clicks the login button
    Then the user should see login unsuccessful 'Login was unsuccessful. Please correct the errors and try again.' message
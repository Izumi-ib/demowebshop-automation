@ui @regression
Feature: User registration feature

  Background:
    Given the user is on 'register' page

  @TC_101
  Scenario: User registers with valid credentials (TC_101)
    When the user enters personal details 'Male', 'firstName', 'lastName' and 't79916769'
    And the user enters password 'asda1231' and confirm password 'asda1231'
    And the user clicks register button
    Then the user should see 't79916769' on the home page

  @TC_102
  Scenario: User registers with existing credentials (TC_102)
    When the user enters personal details 'Male', 'firstName', 'lastName' and 't79916769@gmail.com'
    And the user enters password 'asda1231' and confirm password 'asda1231'
    And the user clicks register button
    Then the user should see following error messages:
      | EmailAlreadyExists | The specified email already exists |

  @TC_103
  Scenario: User registers with not matching passwords (TC_103)
    When the user enters personal details 'Male', 'FirstName', 'LastName' and 't79916769'
    And the user enters password 'asda1231' and confirm password 'sadw1231'
    And the user clicks register button
    Then the user should see following error messages:
      | ConfirmPassword | The password and confirmation password do not match. |

  @TC_104
  Scenario: User registers without filling in any fields (TC_104)
    When the user enters personal details '', '', '' and ''
    And the user enters password '' and confirm password ''
    And the user clicks register button
    Then the user should see following error messages:
      | FirstName       | First name is required. |
      | LastName        | Last name is required.  |
      | Email           | Email is required.      |
      | Password        | Password is required.   |
      | ConfirmPassword | Password is required.   |

  @TC_105
  Scenario: User registers with short password (TC_105)
    When the user enters personal details 'Male', 'FirstName', 'LastName' and 't79916769'
    And the user enters password 'asda1' and confirm password 'asda1'
    And the user clicks register button
    Then the user should see following error messages:
      | Password | The password should have at least 6 characters. |
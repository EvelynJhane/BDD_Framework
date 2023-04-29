Feature: login

  Scenario: Verify user gets error for invalid credentials
    Given I launch facebook website
    When I enter 'invalidEmail@gmail.com' as login email
    When I enter 'invalidPassword@123' as login password
    When I click on login button
    Then I verify login error is displayed
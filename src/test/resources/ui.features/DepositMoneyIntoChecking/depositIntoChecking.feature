Feature: As a user i can deposit money into my checking account

  Scenario Outline: Deposit money into checking account
    Given User is on the login page
    And User successfully logs in with credentials "test@test.com" and "Password123"
    When User navigates to deposit page
    And user selects checking "TestAccount1 (Standard Checking)" from dropdown
    And User enters a "<deposit>" amount
    And User clicks submit
    Then User should see updated Balance in the Account Card
    And User should see the updated deposit information in the transaction table


    Examples:
      | deposit |
      | 10.00   |
#      | 28.50   |
#      | 1850.70 |










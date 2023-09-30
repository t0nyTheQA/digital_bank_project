Feature:  I am able to withdraw money from any Account

  Background:
    Given User is logged in with credentials "test@test.com" and "Password123"
#    need to create the accounts


  Scenario Outline: User is able to withdraw money from any account
    Given User is on the to Withdraw page
    When user chooses an account and enters a withdraw amount and submits the withdrawal
      | accountName     | withdrawAmount     |
      | "<accountName>" | "<withdrawAmount>" |
    Then user should see the new balance and amount withdrew in the transaction table
    Examples:
      | accountName                       | withdrawAmount |
      | TestWithdraw1 (Standard Checking) | 780.50         |
      | TestWithdraw2 (Standard Checking) | 48.10          |
      | TestWithdraw (Standard Checking)  | 104.83         |

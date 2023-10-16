Feature:  I am able to withdraw money from any Account

  Scenario Outline: User is able to withdraw money from any account
    Given User is logged in with credentials "test123@email.com" and "Password123"
    Given User is on the to Withdraw page
    When user chooses an "<accountName>" and enters a "<withdrawAmount>" and submits the withdrawal
    Then user should see the new balance and amount withdrew in the transaction table
    Examples:
      | accountName                      | withdrawAmount |
      | TestAccount1 (Standard Checking) | 10.50          |

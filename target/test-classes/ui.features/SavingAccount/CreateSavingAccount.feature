Feature: Create a new savings account

  Scenario: Create a new individual savings account
    Given user is on the login page of dBank
    And user logs in with "test123@email.com" and "Password123"
    When User creates a new savings account with the information
      | accountType | ownership  | accountName     | initialDeposit |
      | Savings     | Individual | Steves Savings1 | 10000.00       |
    Then user should see green "Successfully created new Savings account named Steves Savings1" alert
    And user should see the new checking account card with initial input data and
      | accountNumber | interestRate | balance  | accountType | ownership  | accountName     |
      | 486131720     | 1.85         | 10000.00 | Savings     | Individual | Steves Savings1 |


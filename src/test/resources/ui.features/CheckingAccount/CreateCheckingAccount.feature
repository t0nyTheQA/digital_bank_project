Feature: Create a new checking account

  Scenario: Create a checking account
    Given User is logged in credentials "anton@email.com" and "Password123"
    And creates a new individual checking account with the following data
      | accountName           | accountType       | ownership  | deposit   |
      | Antons First Checking | Standard Checking | Individual | 100000.00 |
    Then User should see a green confirmation message saying "Successfully created new Standard Checking account named Antons First Checking"
    And User should see the new checking account card
      | accountName           | accountType       | ownership  | accountNumber | interestRate | balance   |
      | Antons First Checking | Standard Checking | Individual | 486131225     | 0.0%         | 100000.00 |
    And User should see the following Transaction menu
      | date             | category | description               | amount    | balance   |
      | 2023-09-07 21:19 | Income   | 845321935 (DPT) - Deposit | 100000.00 | 100000.00 |






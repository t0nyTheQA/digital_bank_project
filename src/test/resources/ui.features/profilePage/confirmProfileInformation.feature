Feature: Profile page is correct

  Scenario: As a user, I can confirm my information is correct
    Given User logs in with valid credentials
    When User goes to My Profile page
    Then User confirms
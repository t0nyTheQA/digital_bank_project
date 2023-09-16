Feature: ability to log in


  Scenario Outline:Verify user cannot login with "<invalidUsername>" and "<invalidPassword>"
    Given url "https://dbank-qa.wedevx.co/bank/login" is opened;
    And user entered "<invalidUsername>" and "<invalidPassword>"
    Then verify user is not logged
    Examples:
      | invalidUsername  | invalidPassword      |
      | notRealName      | notRealPassword      |
      | invalid pass     | anton@email.com      |
      | Password123      | doesNotExistUsername |
      | NotBlankPassword |                      |
      |                  | notBlankPassword     |
      |                  |                      |


  Scenario Outline: Verify user can login with valid credentials
    Given url "https://dbank-qa.wedevx.co/bank/login" is opened;
    And user entered valid "<username>" and "<password>"
    Then verify user successfully logged in
    Examples:
      | username        | password    |
      | anton@email.com | Password123 |







Feature: ability to log in

@negativeExamples
  Scenario Outline:Verify user cannot login with "<invalidUsername>" and "<invalidPassword>"
    Given user entered "<invalidUsername>" and "<invalidPassword>"
    Examples:
      | invalidUsername  | invalidPassword      |
      | notRealName      | notRealPassword      |
      | invalid pass     | anton@email.com      |
      | Password123      | doesNotExistUsername |
      | NotBlankPassword |                      |
      |                  | notBlankPassword     |
      |                  |                      |


  Scenario Outline: User Verifies user can login with valid credentials
    Given user entered valid "<username>" and "<password>"
    Then verify user successfully logged in
    Examples:
      | username        | password    |
      | anton@email.com | Password123 |







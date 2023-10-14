Feature: Ability to Register a User`

  Background:

    Given the user with "ella@email.com" is not in database
    Given user is on the dBank registration page


  Scenario: successfully registering a new user, positive case
    When user enters the following data
      | title | firstName | lastName | gender | dateOfBirth | ssn         | email          | password    | confirmPassword | address    | locality | region | postalCode | country | mobilePhone  | termsCheckBox |
      | Ms.   | Ella      | Chuprin  | F      | 01/01/2001  | 420-69-6969 | ella@email.com | Password123 | Password123     | 911 street | Sarasota | FL     | 34235      | USA     | 333-444-5555 | true          |
    Then user should see a green "Registration Successful. Please Login." alert
    And the following user info should be saved in the database
      | title | firstName | lastName | gender | dateOfBirth | ssn         | email          | password    | confirmPassword | address    | locality | region | postalCode | country | mobilePhone  | termsCheckBox |
      | Ms.   | Ella      | Chuprin  | F      | 01/01/2001  | 420-69-6969 | ella@email.com | Password123 | Password123     | 911 street | Sarasota | FL     | 34235      | USA     | 333-444-5555 | true          |

  @negativeExamples
  Scenario Outline: Negative test case, As an admin I want to make sure I cannot register without all proper data
    Given user enters the following data
      | title   | firstName   | lastName   | gender   | dateOfBirth   | ssn   | email   | password   | confirmPassword   | address   | locality   | region   | postalCode   | country   | mobilePhone   | termsCheckBox   |
      | <title> | <firstName> | <lastName> | <gender> | <dateOfBirth> | <ssn> | <email> | <password> | <confirmPassword> | <address> | <locality> | <region> | <postalCode> | <country> | <mobilePhone> | <termsCheckBox> |
    Then The user should see the "<fieldWithError>" with the appropriate "<errorMessage>"
    Examples:
      | title | firstName | lastName | gender | dateOfBirth | ssn           | email | password    | confirmPassword     | address    | locality | region | postalCode | country | mobilePhone  | fieldWithError  | errorMessage                                  | termsCheckBox |
      |       |           |          |        |             |               |       |             |                     |            |          |        |            |         |              | title           | Please select an item in the list.            |               |
      | Mr.   |           |          |        |             |               |       |             |                     |            |          |        |            |         |              | firstName       | Please fill out this field.                   |               |
      | Mr.   | Anton     |          |        |             |               |       |             |                     |            |          |        |            |         |              | lastName        | Please fill out this field.                   |               |
      | Mr.   | Anton     | Toropov  |        |             |               |       |             |                     |            |          |        |            |         |              | gender          | Please select one of these options.           |               |
      | Mr.   | Anton     | Toropov  | M      | 01/10/99    |               |       |             |                     |            |          |        |            |         |              | dateOfBirth     | Please match the requested format.            |               |
      | Mr.   | Anton     | Toropov  | M      | 612/2/223   |               |       |             |                     |            |          |        |            |         |              | dateOfBirth     | Please match the requested format.            |               |
      | Mr.   | Anton     | Toropov  | M      | 1/2/2       |               |       |             |                     |            |          |        |            |         |              | dateOfBirth     | Please match the requested format.            |               |
      | Mr.   | Anton     | Toropov  | M      | 01/10/1222  | 12-1-1        |       |             |                     |            |          |        |            |         |              | ssn             | Please match the requested format.            |               |
      | Mr.   | Anton     | Toropov  | M      | 01/10/1222  | 12-3333-44232 |       |             |                     |            |          |        |            |         |              | ssn             | Please match the requested format.            |               |
      | Mr.   | Anton     | Toropov  | M      | 01/10/1222  |               |       |             |                     |            |          |        |            |         |              | ssn             | Please fill out this field.                   |               |
      | Mr.   | Anton     | Toropov  | M      | 01/10/1222  | mock          |       |             |                     |            |          |        |            |         |              | email           | Please fill out this field.                   |               |
      | Mr.   | Anton     | Toropov  | M      | 01/10/1222  | mock          | mock  |             |                     |            |          |        |            |         |              | password        | Please fill out this field.                   |               |
      | Mr.   | Anton     | Toropov  | M      | 01/10/1222  | mock          | mock  | Password123 |                     |            |          |        |            |         |              | confirmPassword | Passwords Do Not Match                        |               |
      | Mr.   | Anton     | Toropov  | M      | 01/10/1222  | mock          | mock  | Password123 | NotMatchingPassword |            |          |        |            |         |              | confirmPassword | Passwords Do Not Match                        |               |
      | Mr.   | Anton     | Toropov  | M      | 01/10/1222  | mock          | mock  | Password123 | Password123         |            |          |        |            |         |              | address         | Please fill out this field.                   |               |
      | Mr.   | Anton     | Toropov  | M      | 01/10/1222  | mock          | mock  | Password123 | Password123         | 1st Street |          |        |            |         |              | locality        | Please fill out this field.                   |               |
      | Mr.   | Anton     | Toropov  | M      | 01/10/1222  | mock          | mock  | Password123 | Password123         | 1st Street | Seattle  |        |            |         |              | region          | Please fill out this field.                   |               |
      | Mr.   | Anton     | Toropov  | M      | 01/10/1222  | mock          | mock  | Password123 | Password123         | 1st Street | Seattle  | WA     |            |         |              | postalCode      | Please fill out this field.                   |               |
      | Mr.   | Anton     | Toropov  | M      | 01/10/1222  | mock          | mock  | Password123 | Password123         | 1st Street | Seattle  | WA     | 12345      |         |              | country         | Please fill out this field.                   |               |
      | Mr.   | Anton     | Toropov  | M      | 01/10/1222  | mock          | mock  | Password123 | Password123         | 1st Street | Seattle  | WA     | 12345      | USA     |              | mobilePhone     | Please fill out this field.                   |               |
      | Mr.   | Anton     | Toropov  | M      | 01/10/1222  | mock          | mock  | Password123 | Password123         | 1st Street | Seattle  | WA     | 12345      | USA     | 123-333-1232 | termsCheckBox   | Please check this box if you want to proceed. |               |





















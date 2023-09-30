Feature: Ability to Register a User


  Scenario: successfully registering a new user, positive case
    Given user is on the dBank registration page
    When user enters the following data with mocked SSN and email
      | title | firstName | lastName | gender | dateOfBirth | ssn  | email | password    | confirmPassword | address    | locality | region | postalCode | country | mobilePhone  |
      | Ms.   | Ella      | Chuprin  | F      | 01/01/2001  | mock | mock  | Password123 | Password123     | 911 street | Sarasota | FL     | 34235      | USA     | 333-444-5555 |
    Then user should see a green "Registration Successful. Please Login." alert





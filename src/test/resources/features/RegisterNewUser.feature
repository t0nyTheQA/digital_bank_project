Feature: Ability to Register a User

@ignore
  Scenario: registering a new user
    Given user clicks on Sign Up Here link from the login page
    When user enters the following data:
      | title | firstName | lastName | gender | dateOfBirth | ssn         | email          | password    | confirmPassword | address    | locality | region | postalCode | country | mobilePhone  |
      | Ms.   | Ella      | Chuprin  | F      | 01/01/2001  | 111-99-1234 | ella@email.com | Password123 | Password123     | 911 street | Sarasota | FL     | 34235      | USA     | 333-444-5555 |
    When user agrees to the terms and policies and clicks on Register button
    Then user should see a green "Registration Successful. Please Login." alert





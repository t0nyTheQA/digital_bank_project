Feature: Remember me button
  Scenario: user clicks on remember me button
    Given the user on main page
    When the user fills out his credentials "johndoe@gmail.com" and "Test123$"
    And the user clicks on "Remember Me" button
    Then credentials should be saved
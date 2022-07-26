Feature: Registration and logout

  Scenario Outline: User is able to register an account through adidas training app
    Given Fresh app installed
    And Registration page is shown to the new user
    And The user's mandatory data "<FirstName>", "<LastName>", "<Email>", "<Password>"  added correctly
    When The user taps on the register option
    Then Extra legal consents are shown
    And The marketing consent is shown

    Examples:
      | FirstName | LastName | Email                   | Password|
      | Ahmed       | QA       | Ahmed7@georgelabs.com | Testtest1!|


  Scenario: User is able to logout from adidas training app
    Given The user registered new account
    And The more tab is shown to the user
    When The user taps on the logout option
    Then The user is logged out successfully
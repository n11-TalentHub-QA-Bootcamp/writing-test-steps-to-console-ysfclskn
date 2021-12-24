Feature: n11 Facebook Login

  @loginSocial
  Scenario: n11 Facebook Login
    Given user launch browser and open the main page
    When user logged in with facebook
    Then user logged in succesfully
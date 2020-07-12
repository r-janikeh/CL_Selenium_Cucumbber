Feature: Functionality Test on website

  Scenario Outline: Test construct
    Given browser is open
    And user is on login page
    When user enters <username> and <password>
    And user clicks on login
    Then user is navigated to the home page
    And user clicks on Angebote button
    Then user is navigated to the offers page
    And user clicks on the Privathaftpflicht button
    Then user is navigated to the Privathaftpflicht page
    And user clicks on Weiter button
    Then user is navigated to the Who do you want to insure? page
    And user answers the questions
    Then user is navigated to the feedback anfordern page
    And user enter TestFeatures and clicks on the Angebot anfordern button
    Then user is navigated to the Zum Angebot page
    And user clicks on the Zum Angebot button
    Then Test should end at 'https://staging.clark.de/de/app/manager' route
    Then verify the correct contract is shown on the manager route.

    Examples: 
      | username    | password |
      | a@aaaaa.com | 13536@aA |
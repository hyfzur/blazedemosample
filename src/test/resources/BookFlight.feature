Feature: Book a flight

  Scenario: Book a flight using flight number
    Given User is on the Blazedemo home page
    When User selects the Departure City as "Boston" and the Destination City as "London"
    And User clicks on the Find Flights button
    Then User should be on the Reserve flight page
    When User chooses flight number "4346"
    Then User should be on the Purchase flight page
    When User enters the passenger and card details
    And User clicks on the Purchase Flight button
    Then User should be on the Flight confirmation page

  Scenario: Book the first flight of an airline
    Given User is on the Blazedemo home page
    When User selects the Departure City as "Boston" and the Destination City as "London"
    And User clicks on the Find Flights button
    Then User should be on the Reserve flight page
    When User chooses the first flight from "Virgin America" airline
    Then User should be on the Purchase flight page
    When User enters the passenger and card details
    And User clicks on the Purchase Flight button
    Then User should be on the Flight confirmation page
Feature: Can I hit the route?
  Bibibidi babidi doo

  Scenario: Hit the trout!
    Given This is route: "<route>"
    When I make the get request
    Then I should be told "<response>"

  Examples:
    | route       |   response |
    | helloworld  |    200     |
Feature: Can I hit the route?
  Bibibidi babidi doo

  Scenario: Hit the trout!
    Given Request route is "<route>"
    When the client calls for /"<route>" request
    Then I should be given with "<response>"

  Examples:
    | route       |   response |
    | helloworld  |    200     |
    | hello-world |    403     |
    | authenticate |   405     |
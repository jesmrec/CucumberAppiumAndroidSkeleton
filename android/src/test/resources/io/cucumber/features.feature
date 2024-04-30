Feature: Actions in main page

  Rule: Main view correct

    Scenario Outline: Done unlocked
      Given I open the app
      When I click on <section>
      Then Done button is unlocked

    Examples:
      | section   |
      | Headlines |

  Rule: Settings view correct

    Scenario: Settings displayed
      Given I open the app
      When I open Settings
      Then I see the following sections
        | Theme                |
        | Use Dynamic Color    |
        | Dark mode preference |

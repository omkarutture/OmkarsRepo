Feature: Vctc 

Background: 
Given User should be at home page

Scenario: Validate title of home page
When validate title should be "Velocity Best Software Testing Center"

Scenario Outline: Angular Course information
When click on courses button
And click on course option <name>
Then user should be on anguler Developer details page

Examples:
|name|
|Angular Developer|
|Software Testing|
|React Developer|

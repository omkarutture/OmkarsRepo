Feature: Home Page Functionality
Scenario: Validate Title
Given User is at landing page
Then page title should contains "Shopping"

Scenario: Validate cart icon
Given User is at landing page
Then cart icon should get display

Scenario: Checkout the deals section
Given User is at landing page
Then user click on deal section

Scenario: login to app
Given User is at landing page 
When User click in signin button
And user enters username "9404009814" in box
And user enters password "Omkar@1995" in box


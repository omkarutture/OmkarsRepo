Feature: login functionality
Scenario: login with valid creadentials
Given user is at login page
When user enters username
And user enters password
And user clicks on login button
Then user should get logged in successfully

Scenario: title verification
Given user is at landing page
Then title of page should be pageTitle
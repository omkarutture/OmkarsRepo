Feature: login with data
Scenario: login with valid credentials
Given user at login page
When user enters username as "test1"
And user enters password as "test@1234"
And user clicks on login button below login screen 
Then successfully logged in
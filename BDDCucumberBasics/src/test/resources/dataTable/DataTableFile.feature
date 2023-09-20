Feature: Registration functionality

Scenario: Account creation
Given User at Registration page
When User enters following data
|Omkar|Pawar|om@gmail.com|28|9988776655|
|Pragati|Pinge|pp@gmail.com|28|1122334455|
And click on create button
Then account creation done
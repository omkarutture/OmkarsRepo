Feature: MultiData Signup
Scenario Outline: Signup with Multidata
Given User is at Signup Page
When User enters "<name>" 
And User enters "<age>" in age bar
And User enters "<gender>" to disclose
And User enters "<email Id>" point of contact
And User lucky number is <lucky No> 
And User clicks submit button
Then user gets Signup successfully

Examples:
|name|age|gender|email Id|lucky No|
|Omkar|28|Male|omkar@gmail.com|7|
|Pragati|28|Female|pragati@gmail.com|9|
|Amol|35.5|Male|amol@gmail.com|100|

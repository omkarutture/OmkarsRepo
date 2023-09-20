Feature: Ticket Booking

Background:
Given User should login bookmyshow
When User should select films section
And user selects theater

Scenario Outline:
And Enter film "<name>"
And Enter show time "<time>"
And select seat number <seat>
And click on done
Then booking should get confirmed

Examples:
|name|time|seat|
|Gadar2|12:00PM|7, 8, 9|
|OMG2|16:00PM|2|
|Subhedar|20:00PM|9, 10, 11, 12, 13|
 
 
Feature: Order Functionality
Background:
Given User should logged into application
When User should be at oders page

Scenario: Fetching Previously Placed Order Info
And User Clicks on Past Orders button
Then User should be able to view past orders info

Scenario: Fetching Current Placed Order Info
And User Clicks on Current Orders button
Then User should be able to view current orders info

Scenario: Fetching Cancelled Placed Order Info
And User Clicks on Cancelled Orders button
Then User should be able to view Cancelled orders info
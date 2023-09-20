@feature1
Feature: Campaign with Tags

@regression
Scenario: Campaign Creation
Given at campaign page
When click on create campaign button
And user enter information
And clicks on save button
Then Campaign creation Done

@retesting
Scenario: Campaign Scheduling
Given at campaign page
When click on Scheduling campaign button
And user enter Schedule information
And clicks on Schedule button
Then Campaign Scheduling Done

@retesting @Functional
Scenario: Send Campaign
Given at campaign page
When click on Sent campaign button
Then Campaign should get sent.
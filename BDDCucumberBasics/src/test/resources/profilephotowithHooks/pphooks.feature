Feature: Profile Photo with Hooks
Scenario: upload profile photo
Given At profilr photo page
When click on upload photo button
And choose photo
And click upload button
Then successfully uploaded photo

Scenario: update profile photo
Given At profilr photo page
When click on update photo button
And choose photo
And click update button
Then successfully updeated photo

Scenario: delete profile photo
Given At profilr photo page
When click on edit photo button
And click delete button
Then successfully delete photo
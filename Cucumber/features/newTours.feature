
Feature: NewTours Application Testing
Scenario: NewTours LogIn  Functionality Testing

Given Open Firefox Browser and Navigate to NewTours Application
When User enters Valid UserName and Password and perform Click operation on SignIn Button
Then User should be successfully LogIn to the Application and SignOff
Then User should close the Browser

Given Open Firefox Browser and Navigate to NewTours App
When User clicks on Register link and Enters Details
Then User should be successfully Registered to the Application
Then User should close the Browser

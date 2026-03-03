#language: pt
Feature: Login

@test
Scenario: Successful login
  Given that I enter the username and password
  When I click the login button
  Then I should see the application home screen

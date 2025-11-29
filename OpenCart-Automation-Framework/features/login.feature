Feature: Login Functionality
  As a registered user
  I want to log in to the OpenCart website
  So that I can access my account dashboard

  Scenario: Successful login with valid credentials
    Given I open the OpenCart login page
    When I enter a valid email and password
    And I click on the Login button
    Then I should see my account dashboard

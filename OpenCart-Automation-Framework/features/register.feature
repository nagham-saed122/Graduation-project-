Feature: User Registration
  As a new user
  I want to register an account on the OpenCart website
  So that I can start shopping

  Scenario: Register a new account successfully
    Given I open the OpenCart registration page
    When I fill in all required user information
    And I submit the registration form
    Then I should see a success message confirming registration

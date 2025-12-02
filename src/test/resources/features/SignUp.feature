Feature: Sign Up Functionality

  Background:
    Given I am on the Demoblaze home page

  Scenario: Successful Sign Up
    When I click the Sign Up button
    Then the Sign Up modal should open
    When I sign up with username "NaghommmAhmedSaed" and password "MySecretPassword!"
    And I click the Sign Up submit button
    Then I should see a sign up alert saying "Sign up successful."

  Scenario: Cancel Sign Up
    When I click the Sign Up button
    Then the Sign Up modal should open
    When I sign up with username "SomeUser" and password "SomePassword!"
    And I click the Sign Up Close button
    Then the Sign Up modal should close

  Scenario: Sign Up with Existing User
    When I click the Sign Up button
    Then the Sign Up modal should open
    When I sign up with username "NaghamAhmed" and password "SecretPassword!"
    And I click the Sign Up submit button
    Then I should see a sign up alert saying "This user already exist."

  Scenario: Sign Up with Missing Credentials
    When I click the Sign Up button
    Then the Sign Up modal should open
    When I sign up with password "SecretPassword!" only
    And I click the Sign Up submit button
    Then I should see a sign up alert saying "Please fill out Username and Password."

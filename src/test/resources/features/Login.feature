Feature: Login Functionality

  Background:
    Given I am on the Demoblaze home page

  Scenario: Successful Login
    When I click the Login button
    Then the Login modal should open
    When I enter username "NaghomAhmedSaed" and password "MySecretPassword!"
    And I click the Login submit button
    Then I should see the welcome message "Welcome NaghomAhmedSaed"

  Scenario: Cancel Login
    When I click the Login button
    Then the Login modal should open
    When I enter username "SomeUser" and password "SomePassword!"
    And I click the Login Close button
    Then the Login modal should close

  Scenario: Login with Missing Credentials
    When I click the Login button
    Then the Login modal should open
    When I enter password "SecretPassword!" only
    And I click the Login submit button
    Then I should see a login alert saying "Please fill out Username and Password."

  Scenario: Login with Wrong Credentials
    When I click the Login button
    Then the Login modal should open
    When I enter username "NaghammmmAhmed" and password "SecretPpppassword!"
    And I click the Login submit button
    Then I should see a login alert saying "User does not exist."

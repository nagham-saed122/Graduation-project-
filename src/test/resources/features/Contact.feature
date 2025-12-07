Feature: Contact Us Functionality

  Background:
    Given I am on the Demoblaze home page

  Scenario: Send a Message Successfully
    When I click on the Contact link
    And I enter email "test@example.com"
    And I enter name "Test User"
    And I enter message "This is a test message."
    And I click the Send Message button
    Then I should see a contact alert saying "Thanks for the message!!"

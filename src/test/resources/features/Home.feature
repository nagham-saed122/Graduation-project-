Feature: Home Page Functionality

  Background:
    Given I am on the Demoblaze home page

  Scenario: Verify Navbar Elements are Displayed
    Then the Logo should be displayed
    And the Home link should be displayed
    And the Contact link should be displayed
    And the About Us link should be displayed
    And the Cart link should be displayed
    And the Login link should be displayed
    And the Sign Up link should be displayed

  Scenario: Verify All Products are Displayed
    Then the products list should not be empty
    And each product should have an image, name, and price displayed

  Scenario: Verify Categories are Clickable
    Then the Product list should be displayed
    When I check the categories
    Then the Phones category should be clickable
    And the Laptops category should be clickable
    And the Monitors category should be clickable

  Scenario: Verify Home Page Title
    Then the Home page title should be "STORE"

  Scenario: Verify Next and Previous Buttons
    When I click the Next button
    And I wait for 2 seconds
    And I click the Previous button
    And I wait for 2 seconds
    Then the products list should not be empty
    And each product should have an image, name, and price displayed

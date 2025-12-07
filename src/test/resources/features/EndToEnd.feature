Feature: End to End Purchase Flow
  As a registered user
  I want to browse products, add them to cart, and complete the purchase
  So that I can buy items from the store

  Background:
    Given I am on the Demoblaze home page

  Scenario: Complete purchase flow
    When I click the Login button
    And I enter username "testuser_123" and password "password123"
    And I click the Login submit button
    Then I should see the welcome message "Welcome testuser_123"

    When I add "Samsung galaxy s6" to the cart
    And I go to the Cart page
    Then the cart should contain "Samsung galaxy s6"
    
    When I place an order with the following details:
      | Name       | Test User |
      | Country    | USA       |
      | City       | New York  |
      | CreditCard | 123456789 |
      | Month      | 12        |
      | Year       | 2025      |
    Then I should see the success message "Thank you for your purchase!"

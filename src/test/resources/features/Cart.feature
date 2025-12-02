Feature: Cart Page Functionality

  Background:
    Given I am on the Demoblaze home page

  Scenario: Verify Cart Products and Total
    When I add "Samsung galaxy s6" to the cart
    And I go to the Cart page
    Then the cart should not be empty
    And the cart should contain "Samsung galaxy s6"
    And the total price should be displayed

  Scenario: Delete Product from Cart
    When I add "Nokia lumia 1520" to the cart
    And I go to the Cart page
    And I delete "Nokia lumia 1520" from the cart
    Then the cart should not contain "Nokia lumia 1520"

  Scenario: Purchase with Valid Data
    When I add "Samsung galaxy s6" to the cart
    And I go to the Cart page
    And I place an order with the following details:
      | Name       | Nagham           |
      | Country    | Egypt            |
      | City       | Cairo            |
      | CreditCard | 1234567890123456 |
      | Month      | 12               |
      | Year       | 2025             |
    Then I should see the success message "Thank you for your purchase!"

  Scenario: Purchase Without Data Should Show Alert
    When I go to the Cart page
    And I click Place Order
    And I click Purchase without filling details
    Then I should see an alert saying "Please fill out Name and Creditcard"

Feature: Add Product to Cart
  As a customer
  I want to add a product to my shopping cart
  So that I can purchase it later

  Scenario: Add item to cart successfully
    Given I am on the OpenCart homepage
    When I select a product and click "Add to Cart"
    Then the item should appear in my shopping cart

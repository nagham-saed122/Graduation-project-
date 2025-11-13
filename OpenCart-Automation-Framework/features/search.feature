Feature: Product Search
  As a customer
  I want to search for products on the OpenCart website
  So that I can find items quickly

  Scenario: Search for an existing product
    Given I am on the OpenCart homepage
    When I search for "MacBook"
    Then search results related to "MacBook" should appear

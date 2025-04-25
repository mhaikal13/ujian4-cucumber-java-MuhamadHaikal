
Feature: Login and Add Product to Cart

  Scenario: Successful login and add 1 product to cart
    Given User di login page
    When User input data valid
    And User clicks login button
    Then User diarahkan ke inventory page
    When User adds "Sauce Labs Backpack" ke dalam cart
    Then Cart badge should show "1"

  Scenario: Unsuccessful login with invalid credentials
    Given User di login page
    When User input invalid data
    And User clicks login button
    Then muncul error message


Feature: Login and Add Product to Cart

  Scenario: Successful login and add 1 product to cart
    Given User is on the login page
    When User enters valid credentials
    And User clicks login button
    Then User should be redirected to inventory page
    When User adds "Sauce Labs Backpack" to the cart
    Then Cart badge should show "1"

  Scenario: Unsuccessful login with invalid credentials
    Given User is on the login page
    When User enters invalid credentials
    And User clicks login button
    Then An error message should be displayed

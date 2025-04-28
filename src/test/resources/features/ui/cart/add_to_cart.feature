Feature: User adds products to cart feature

  Background:
    Given the user is on '' page

  @TC_301
  Scenario Outline: User adds a product to cart (TC_301)
    When the user clicks on 'Add to cart' button for product with name '<productTitle>'
    Then the user should see 'The product has been added to your shopping cart' on the top
    When the user is on 'cart' page
    Then the user verifies the product with name '<productTitle>' was added to the cart

    Examples:
      | productTitle      |
      | 14.1-inch Laptop |

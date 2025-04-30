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
      | productTitle     |
      | 14.1-inch Laptop |

  @TC_302
  Scenario Outline: User removes product from cart (TC_302)
    When the user clicks on 'Add to cart' button for product with name '<productTitle>'
    Then the user should see 'The product has been added to your shopping cart' on the top
    When the user is on 'cart' page
    Then the user verifies the product with name '<productTitle>' was added to the cart
    When the user clicks on 'Remove from cart' button for product with name '<productTitle>'
    And the user clicks on 'Update shopping cart' button in shopping page
    Then the user should see 'Your Shopping Cart is empty!' message in shopping cart

    Examples:
      | productTitle     |
      | 14.1-inch Laptop |

  @TC_303
  Scenario: User adds multiple product to cart and verifies its total

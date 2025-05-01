Feature: User adds products to cart feature

  @TC_301
  Scenario Outline: User adds a product to cart (TC_301)
    Given the user is on '' page
    When the user clicks on 'Add to cart' button for product with name '<productTitle>'
    Then the user should see 'The product has been added to your shopping cart' on the top
    When the user is on 'cart' page
    Then the user verifies the product with name '<productTitle>' was added to the cart

    Examples:
      | productTitle     |
      | 14.1-inch Laptop |

  @TC_302
  Scenario Outline: User removes product from cart (TC_302)
    Given the user is on '' page
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
    Given the user is on 'accessories' page
    When the user clicks on 'Add to card' button and adds following products to cart:
      | productTitle                |
      | TCP Instructor Led Training |
      | TCP Public Complete         |
      | TCP Public MT/AT            |
    Then the user should see 'The product has been added to your shopping cart' on the top
    And the user is on 'cart' page
#    Then the user should see the total price as '{string}'

  @TC_304
  Scenario: User verifies cart quantity update
    Given the user is on '' page
    When the user clicks on 'Add to cart' button for product with name '14.1-inch Laptop'
    Then the user should see 'The product has been added to your shopping cart' on the top
    When the user is on 'cart' page
    And the user change quantity '' for the with name product '14.1-inch Laptop'
    Then the user should see the total price as '{string}'





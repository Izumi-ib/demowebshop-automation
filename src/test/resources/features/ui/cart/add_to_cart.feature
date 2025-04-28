Feature: User adds products to cart feature

  Background:
    Given the user is on 'home' page

  @TC_301
  Scenario Outline: User adds a product to cart (TC_301)
    When the user clicks on 'Add to cart' button for product with name ''
    Then the user should see 'The product has been added to your shopping cart' on the top
    When the user goes to cart page
    Then the user verifies the product with name '' was added to the cart

    Examples:
      | product name          |
      | $25 Virtual Gift Card |

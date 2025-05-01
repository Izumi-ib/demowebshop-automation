package com.demowebshop.ui.stepdefinitions;

import com.demowebshop.ui.actions.CartActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;

public class CartSteps {
    private final static CartActions cartActions = new CartActions(DriverHelper.getDriver());

    @When("the user clicks on {string} button for product with name {string}")
    public void the_user_clicks_on_button_for_product_with_name(String buttonName, String productName) {
        cartActions.clickOnProduct(buttonName, productName);
    }

    @When("the user clicks on {string} button in shopping page")
    public void the_user_clicks_on_button(String buttonName) {
        cartActions.clickButtonInShoppingPage(buttonName);
    }

    @Then("the user should see {string} message in shopping cart")
    public void the_user_should_see_message_in_shopping_cart(String expectedMessage) {
        cartActions.verifyMessageInShoppingCart(expectedMessage);
    }

    @Then("the user should see {string} on the top")
    public void the_user_should_see_on_the_top(String expectedMessage) {
        cartActions.validateProductAddedMessage(expectedMessage);
    }

    @Then("the user verifies the product with name {string} was added to the cart")
    public void the_user_verifies_the_product_with_name_was_added_to_the_cart(String expectedProductTitle) {
        cartActions.verifyTheProductIsAddedToCart(expectedProductTitle);
    }

    @When("the user clicks on {string} button and adds following products to cart:")
    public void the_user_clicks_on_button_and_adds_following_products_to_cart(String buttonName, io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> products = dataTable.asMaps(String.class, String.class);

        cartActions.clickButtonAndAddProducts(buttonName, products);
    }

    @Then("the user should see {string} total price")
    public void the_user_should_see_total_price(String expectedPrice) {
        cartActions.verifyTotalPriceOfProducts(expectedPrice);
    }

    @When("the user change quantity {string} for the with name product {string}")
    public void the_user_change_quantity_for_the_with_name_product(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the user should see the total price as {string}")
    public void the_user_should_see_the_total_price_as(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}

package com.demowebshop.ui.stepdefinitions;

import com.demowebshop.ui.actions.CartActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverHelper;

public class CartSteps {
    private final static CartActions cartActions = new CartActions(DriverHelper.getDriver());

    @When("the user clicks on {string} button for product with name {string}")
    public void the_user_clicks_on_button_for_product_with_name(String buttonName, String productName) {
        cartActions.clickOnProduct(buttonName, productName);
    }

    @Then("the user should see {string} on the top")
    public void the_user_should_see_on_the_top(String expectedMessage) {
        cartActions.validateProductAddedMessage(expectedMessage);
    }

    @Then("the user verifies the product with name {string} was added to the cart")
    public void the_user_verifies_the_product_with_name_was_added_to_the_cart(String expectedProductTitle){
        cartActions.verifyTheProductIsAddedToCart(expectedProductTitle);
    }

}

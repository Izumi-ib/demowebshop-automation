package com.demowebshop.ui.stepdefinitions;

import com.demowebshop.ui.actions.CartActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverHelper;

public class CartSteps {
    private final static CartActions cartActions = new CartActions(DriverHelper.getDriver());

    @Given("the user is on cart page")
    public void the_user_is_on_cart_page(){

    }

    @When("the user clicks on {string} button for product with name {string}")
    public void the_user_clicks_on_button_for_product_with_name(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the user should see {string} on the top")
    public void the_user_should_see_on_the_top(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user goes to cart page")
    public void the_user_goes_to_cart_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}

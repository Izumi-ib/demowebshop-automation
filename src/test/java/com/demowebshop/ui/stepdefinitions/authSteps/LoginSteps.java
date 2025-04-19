package com.demowebshop.ui.stepdefinitions.authSteps;

import com.demowebshop.ui.actions.authActions.LoginActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverHelper;

public class LoginSteps {
    private final LoginActions loginActions = new LoginActions(DriverHelper.getDriver());

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        loginActions.navigateToLoginPage();
    }

    @When("the user enters email {string} and password {string} to log in")
    public void the_user_enters_email_and_password_to_log_in(String email, String password) {
        loginActions.enterCredentials(email, password);
    }

    @When("clicks the login button")
    public void clicks_the_login_button() {
        loginActions.clickLoginButton();
    }

    @Then("the user should see login unsuccessful {string} message")
    public void the_user_should_see_login_unsuccessful_message(String expectedMessage) {
        loginActions.validateLoginErrorMessage(expectedMessage);
    }

    @Then("the user should see invalid email error message {string}")
    public void the_user_should_see_invalid_email_error_message(String expectedMessage) {
        loginActions.validateInvalidEmailErrorMessage(expectedMessage);
    }
}

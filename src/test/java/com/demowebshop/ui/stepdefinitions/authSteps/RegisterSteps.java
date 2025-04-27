package com.demowebshop.ui.stepdefinitions.authSteps;

import com.demowebshop.ui.actions.authActions.RegisterActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RegisterSteps {
    WebDriver driver = DriverHelper.getDriver();
    RegisterActions registerActions = new RegisterActions(driver);

    @Given("the user is on the registration page")
    public void the_user_is_on_the_registration_page() {
        registerActions.navigateToRegisterPage();
    }

    @When("the user enters personal details {string}, {string}, {string} and {string}")
    public void the_user_enters_personal_details_and(String gender, String firstName, String lastName, String email) {
        registerActions.enterPersonalDetails(gender, firstName, lastName, email);
    }

    @When("the user enters password {string} and confirm password {string}")
    public void the_user_enters_password_and_confirm_password(String password, String confirmPassword) {
        registerActions.enterPasswordAndConfirmPassword(password, confirmPassword);
    }

    @When("the user clicks register button")
    public void the_user_clicks_register_button() {
        registerActions.clickRegisterButton();
    }

    @Then("the user should see following error messages:")
    public void the_user_should_see_following_error_messages(io.cucumber.datatable.DataTable dataTable) {
        Map<String, List<String>> errors = dataTable.asMap(String.class, String.class)
                .entrySet()
                .stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                ));

        registerActions.validateRegistrationFormError(errors);
    }

}

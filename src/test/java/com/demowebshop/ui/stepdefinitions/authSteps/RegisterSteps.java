package com.demowebshop.ui.stepdefinitions.authSteps;

import com.demowebshop.ui.pages.auth.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class RegisterSteps {
    WebDriver driver = DriverHelper.getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @Given("the user is on the registration page")
    public void the_user_is_on_the_registration_page() {
        driver.get(ConfigReader.readProperty("baseUrl") + "register");
    }
    @When("the user enters personal details {string}, {string}, {string} and {string}")
    public void the_user_enters_personal_details_and(String gender, String firstName, String lastName, String email) {
        registerPage.chooseGender(gender);
        registerPage.fillPersonalDetailsAndPasswords(firstName, lastName, email);
    }
    @When("the user enters password {string} and confirm password {string}")
    public void the_user_enters_password_and_confirm_password(String password, String confirmPassword) {
        registerPage.fillPasswordsForReg(password, confirmPassword);
    }
    @When("the user clicks register button")
    public void the_user_clicks_register_button() {
        registerPage.clickRegisterButton();
    }

}

package com.demowebshop.ui.stepdefinitions.authSteps;

import com.demowebshop.ui.pages.auth.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class LoginSteps {
    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);;

    @Step("Navigate to login page")
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver.get(ConfigReader.readProperty("baseUrl") + "login");
    }

    @When("the user enters email {string} and password {string} to log in")
    public void the_user_enters_email_and_password_to_log_in(String email, String password) {
        loginPage.enterLoginCredentials(email, password, true);
    }
    @When("clicks the login button")
    public void clicks_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("the user should see login unsuccessful {string} message")
    public void the_user_should_see_login_unsuccessful_message(String expectedMessage){
        loginPage.validateLoginUnsuccessfulMessage(expectedMessage);
    }
}

package com.demowebshop.ui.actions.authActions;

import com.demowebshop.ui.pages.auth.LoginPage;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigReader;

import static io.qameta.allure.Allure.step;

public class LoginActions {
    private WebDriver driver;
    private final LoginPage loginPage;
    private static final Logger logger = LoggerFactory.getLogger(LoginActions.class);

    public LoginActions(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
    }

    public void navigateToLoginPage() {
        step("Navigate to login page");
        logger.info("Navigating to login page");
        driver.get(ConfigReader.readProperty("baseUrl") + "login");
    }

    public void enterCredentials(String email, String password) {
        step("User enters email: {0} and password: {1}");
        logger.info("Entering email: {} and password: {}", email, password);
        loginPage.enterLoginCredentials(email, password, true);
    }

    public void clickLoginButton(){
        step("User clicks the login button");
        logger.info("Clicking login button");
        loginPage.clickLoginButton();
    }

    public void validateLoginErrorMessage(String expectedMessage) {
        step("User should see login error message: " + expectedMessage, () -> {
            logger.info("Verifying login error message");
            loginPage.validateLoginUnsuccessfulMessage(expectedMessage);
        });
    }


    public void validateInvalidEmailErrorMessage(String expectedMessage){
        step("User should see invalid email error message: {expectedMessage}");
        logger.info("Email invalid error message");
        loginPage.validateInvalidEmailMessage(expectedMessage);
    }

}

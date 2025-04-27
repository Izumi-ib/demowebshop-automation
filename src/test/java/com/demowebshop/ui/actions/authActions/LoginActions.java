package com.demowebshop.ui.actions.authActions;

import com.demowebshop.ui.pages.auth.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AllureUtils;
import utils.ConfigReader;

public class LoginActions {
    private WebDriver driver;
    private final LoginPage loginPage;
    private static final Logger logger = LoggerFactory.getLogger(LoginActions.class);

    public LoginActions(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
    }

    @Step("Navigating to login page")
    public void navigateToLoginPage() {
        AllureUtils.log(logger, "Navigating to login page");
        driver.get(ConfigReader.readProperty("baseUrl") + "login");
    }

    @Step("Entering email {0} and password {1}")
    public void enterCredentials(String email, String password) {
        AllureUtils.log(logger, "Entered login credentials: Email = '%s', Password = '%s'", email, password);
        loginPage.enterLoginCredentials(email, password, true);
    }

    @Step("Clicking login button")
    public void clickLoginButton() {
        AllureUtils.log(logger, "Clicking the login button to submit the credentials");
        loginPage.clickLoginButton();
    }

    @Step("Validating login error message")
    public void validateLoginErrorMessage(String expectedMessage) {
        AllureUtils.log(logger, "Validating the login error message: %s", expectedMessage);
        loginPage.validateLoginUnsuccessfulMessage(expectedMessage);
    }

    @Step("Validating invalid email error message")
    public void validateInvalidEmailErrorMessage(String expectedMessage) {
        AllureUtils.log(logger, "Validating invalid email error message: %s", expectedMessage);
        loginPage.validateInvalidEmailMessage(expectedMessage);
    }
}

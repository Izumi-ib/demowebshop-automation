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
        String msg = "Navigating to login page";
        logger.info(msg);
        AllureUtils.attachLog(msg);

        driver.get(ConfigReader.readProperty("baseUrl") + "login");
    }

    @Step("Entering email {0} and password {1}")
    public void enterCredentials(String email, String password) {
        logger.info("Entering login credentials: Email = '{}', Password = '{}'", email, password); // Лог в консоли
        AllureUtils.attachLog("Entered login credentials: Email = '" + email + "', Password = '" + password + "'"); // Лог в отчете Allure

        loginPage.enterLoginCredentials(email, password, true);
    }

    @Step("Clicking login button")
    public void clickLoginButton(){
        String msg = "Clicking the login button to submit the credentials";
        logger.info(msg);
        AllureUtils.attachLog(msg);

        loginPage.clickLoginButton();
    }

    @Step("Validating login error message")
    public void validateLoginErrorMessage(String expectedMessage) {
        String msg = "Validating the login error message: " + expectedMessage;
        logger.info(msg);
        AllureUtils.attachLog(msg);

        loginPage.validateLoginUnsuccessfulMessage(expectedMessage);
    }


    public void validateInvalidEmailErrorMessage(String expectedMessage){
        String msg = "Validating invalid email error message: " + expectedMessage;
        logger.info(msg);
        AllureUtils.attachLog(msg);

        loginPage.validateInvalidEmailMessage(expectedMessage);
    }

}

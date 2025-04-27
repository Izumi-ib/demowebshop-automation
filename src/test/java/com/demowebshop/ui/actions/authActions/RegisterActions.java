package com.demowebshop.ui.actions.authActions;

import com.demowebshop.ui.pages.auth.RegisterPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AllureUtils;
import utils.ConfigReader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class RegisterActions {
    private final RegisterPage registerPage;
    private final WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(LoginActions.class);

    public RegisterActions(WebDriver driver) {
        this.driver = driver;
        this.registerPage = new RegisterPage(driver);
    }

    @Step("Navigating to Register page")
    public void navigateToRegisterPage() {
        AllureUtils.log(logger, "Navigating to Register page");
        driver.get(ConfigReader.readProperty("baseUrl") + "register");
    }

    @Step("Entering personal details: Gender - {gender}, First Name - {firstName}, Last Name - {lastName}, Email - {email}")
    public void enterPersonalDetails(String gender, String firstName, String lastName, String email) {
        AllureUtils.log(logger, String.format("Filling personal details: Gender [%s], First Name [%s], Last Name [%s], Email [%s]", gender, firstName, lastName, email));
        registerPage.chooseGender(gender);
        registerPage.fillPersonalDetailsAndPasswords(firstName, lastName, email);
    }

    @Step("Entering password and confirmation password")
    public void enterPasswordAndConfirmPassword(String password, String confirmPassword) {
        AllureUtils.log(logger, "Filling in password and confirmation password fields");
        registerPage.fillPasswordsForReg(password, confirmPassword);
    }

    @Step("Clicking the Register button")
    public void clickRegisterButton() {
        AllureUtils.log(logger, "Clicking the Register button to submit the form");
        registerPage.clickRegisterButton();
    }

    @Step("Validating all registration errors")
    public void validateRegistrationFormError(Map<String, List<String>> errors) {

        errors.forEach((field, expectedErrorMessages) -> {
            try {
                String methodName = "verify" + field + "Error";

                Method method = registerPage.getClass().getMethod(methodName, String.class);

                String expectedErrorMessage = expectedErrorMessages.get(0);


                method.invoke(registerPage, expectedErrorMessage);
            } catch (NoSuchMethodException e) {
                throw new IllegalArgumentException("No method found for field: " + field, e);

            } catch (InvocationTargetException e) {
                if (e.getCause() instanceof AssertionError) {
                    throw (AssertionError) e.getCause();
                } else {
                    throw new RuntimeException("Unexpected error during method invocation", e.getCause());
                }

            } catch (Exception e) {
                throw new RuntimeException("Unexpected reflection error", e);
            }
        });
    }


}

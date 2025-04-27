package com.demowebshop.ui.pages.auth;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AllureUtils;

import java.time.Duration;
import java.util.Random;

public class RegisterPage {

    private WebDriverWait wait;
    private static Logger logger;

    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        logger = LoggerFactory.getLogger(RegisterPage.class);
    }

    @FindBy(id = "gender-male")
    WebElement genderMaleRadio;
    @FindBy(id = "gender-female")
    WebElement genderFemaleRadio;
    @FindBy(id = "FirstName")
    WebElement firstNameInput;
    @FindBy(id = "LastName")
    WebElement lastNameInput;
    @FindBy(id = "Email")
    WebElement emailInput;
    @FindBy(id = "Password")
    WebElement passwordInput;
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordInput;
    @FindBy(id = "register-button")
    WebElement registerButton;
    @FindBy(xpath = "//div[@class='validation-summary-errors']//li")
    WebElement emailAlreadyExistsErrorElement;
    @FindBy(xpath = "//span[@for='FirstName']")
    WebElement firstNameErrorElement;
    @FindBy(xpath = "//span[@for='LastName']")
    WebElement lastNameErrorElement;
    @FindBy(xpath = "//span[@for='Email']")
    WebElement emailErrorElement;
    @FindBy(xpath = "//span[@for='Password']")
    WebElement passwordErrorElement;
    @FindBy(xpath = "//span[@for='ConfirmPassword']")
    WebElement confirmPasswordErrorElement;


    public void chooseGender(String gender) {
        if (gender.equalsIgnoreCase("Male") && !genderMaleRadio.isSelected()) {
            genderMaleRadio.click();
        } else if (gender.equalsIgnoreCase("Female") && !genderFemaleRadio.isSelected()) {
            genderFemaleRadio.click();
        } else if (gender.isEmpty()) {
            System.out.println("Gender is empty");
        } else if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female")) {
            throw new IllegalArgumentException("Invalid gender: " + gender + ". Expected 'Male' or 'Female'.");
        }
    }

    public void fillPersonalDetailsAndPasswords(String firstName, String lastName, String email) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);

        if (email.isEmpty()) {
            AllureUtils.log(logger, "During registration the email input is empty");
        } else if (email.contains("@")) {
            emailInput.sendKeys(email);
        } else {
            String newEmail = email + "+" + new Random().nextInt(9, 100) + "@gmail.com";
            emailInput.sendKeys(newEmail);
        }
    }

    public void fillPasswordsForReg(String password, String confirmPassword) {
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void verifyEmailAlreadyExistsError(String expectedMessage) {
        Assert.assertEquals("Email already exists error assertion has failed", expectedMessage, wait.until(ExpectedConditions.visibilityOf(emailAlreadyExistsErrorElement)).getText());
    }

    public void verifyFirstNameError(String errorMessage) {
        Assert.assertEquals("First name error assertion has failed",
                errorMessage,
                wait.until(ExpectedConditions.visibilityOf(firstNameErrorElement)).getText());
    }

    public void verifyLastNameError(String errorMessage) {
        Assert.assertEquals("Last name error assertion has failed",
                errorMessage,
                wait.until(ExpectedConditions.visibilityOf(lastNameErrorElement)).getText());
    }

    public void verifyEmailError(String errorMessage) {
        Assert.assertEquals("Email error assertion has failed",
                errorMessage,
                wait.until(ExpectedConditions.visibilityOf(emailErrorElement)).getText());
    }

    public void verifyPasswordError(String errorMessage) {
        Assert.assertEquals("Password error assertion has failed",
                errorMessage,
                wait.until(ExpectedConditions.visibilityOf(passwordErrorElement)).getText());
    }

    public void verifyConfirmPasswordError(String errorMessage) {
        Assert.assertEquals("Confirmation password error assertion has failed",
                errorMessage,
                wait.until(ExpectedConditions.visibilityOf(confirmPasswordErrorElement)).getText());
    }

    public void clickRegisterButton() {
        registerButton.submit();
    }


}

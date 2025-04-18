package com.demowebshop.ui.pages.auth;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
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

    public void chooseGender(String gender) {
        if (gender.equalsIgnoreCase("Male") && !genderMaleRadio.isSelected()) {
            genderMaleRadio.click();
        } else if (gender.equalsIgnoreCase("Female") && !genderFemaleRadio.isSelected()) {
            genderFemaleRadio.click();
        } else if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female")) {
            throw new IllegalArgumentException("Invalid gender: " + gender + ". Expected 'Male' or 'Female'.");
        }
    }

    public void fillPersonalDetailsAndPasswords(String firstName, String lastName, String email) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
    }

    public void fillPasswordsForReg(String password, String confirmPassword) {
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void clickRegisterButton() {
        registerButton.submit();
    }


}

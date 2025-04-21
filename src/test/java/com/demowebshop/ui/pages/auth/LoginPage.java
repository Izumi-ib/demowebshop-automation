package com.demowebshop.ui.pages.auth;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverHelper;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver = DriverHelper.getDriver();
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    WebElement emailInput;
    @FindBy(id = "Password")
    WebElement passwordInput;
    @FindBy(id = "RememberMe")
    WebElement rememberMeInput;
    @FindBy(xpath = "//input[@value='Log in']")
    WebElement loginButton;
    @FindBy(xpath = "//div[@class='message-error']//span")
    WebElement loginErrorMessage;
    @FindBy(xpath = "//span[@for='Email']")
    WebElement invalidEmailMessage;

    public void enterLoginCredentials(String email, String password, boolean remember){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        if(remember && !rememberMeInput.isSelected()){
            rememberMeInput.click();
        }
    }
    public void clickLoginButton(){
        loginButton.submit();
    }

    public void validateLoginUnsuccessfulMessage(String expectedMessage){
        Assert.assertEquals(loginErrorMessage.getText(), expectedMessage);
    }
    public void validateInvalidEmailMessage(String expectedMessage){
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOf(invalidEmailMessage)).getText(), expectedMessage);
    }

}

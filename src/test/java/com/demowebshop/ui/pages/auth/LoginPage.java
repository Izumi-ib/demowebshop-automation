package com.demowebshop.ui.pages.auth;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverHelper;

public class LoginPage {
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
        Assertions.assertEquals(expectedMessage, loginErrorMessage.getText());
    }


}

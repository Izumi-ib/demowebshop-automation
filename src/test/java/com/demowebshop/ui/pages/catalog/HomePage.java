package com.demowebshop.ui.pages.catalog;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='header-links']//a[@class='account']")
    WebElement profileInfo;

    public void validateProfileInfo(String expectedTitle){

        Assertions.assertEquals(expectedTitle, profileInfo.getText());
    }

}

package com.demowebshop.ui.pages.cart;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCartPage {
    WebDriverWait wait;

    public ShoppingCartPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//")
    WebElement sda;

    public void verifyProductIsAdded(String expectedProductTitle) {
        WebElement productBlock = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//tr[@class='cart-item-row'][.//a[.='" + expectedProductTitle + "']]")
        ));

        Assert.assertEquals(expectedProductTitle, productBlock.getText());
    }


}

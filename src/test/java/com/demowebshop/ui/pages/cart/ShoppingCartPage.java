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
import java.util.List;

public class ShoppingCartPage {
    WebDriverWait wait;

    public ShoppingCartPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='removefromcart']")
    WebElement removeFromCartButton;
    @FindBy(xpath = "//tr[@class='cart-item-row']")
    WebElement productBlock;
    @FindBy(xpath = "//input[@name='updatecart']")
    WebElement updateCartButton;
    @FindBy(xpath = "//div[contains(text(), 'Your Shopping')]")
    WebElement cartIsEmptyMessage;
    @FindBy(xpath = "//span[@class='product-price order-total']")
    WebElement totalPrice;
    @FindBy(xpath = "//span[@class='product-subtotal']")
    List<WebElement> subTotalPrices;


    public void verifyProductIsAdded(String expectedProductTitle) {
        WebElement productBlock = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//tr[@class='cart-item-row']")
        ));

        WebElement productTitle = productBlock.findElement(By.xpath(".//a[.='" + expectedProductTitle + "']"));

        Assert.assertEquals(expectedProductTitle, productTitle.getText());
    }

    public void clickRemoveCheckBox(String expectedProductTitle){
        WebElement productTitle = productBlock.findElement(By.xpath(".//a[.='" + expectedProductTitle + "']"));
        WebElement removeButton = productTitle.findElement(By.xpath("//input[@name='removefromcart']"));

        wait.until(ExpectedConditions.elementToBeClickable(removeButton)).click();
    }

    public void clickButtonInShoppingCart(String buttonName){
        switch (buttonName){
            case "Update shopping cart":
                updateCartButton.click();
        }
    }

    public void validateCartIsEmptyMessage(String expectedMessage){
        Assert.assertEquals(expectedMessage, cartIsEmptyMessage.getText());
    }

    public void getTotalPrice(Double expectedTotalPrice){
        Double actualTotalPrice = 0.0;
        for(WebElement price : subTotalPrices){
             actualTotalPrice += Double.parseDouble(price.getText());
        }
        Assert.assertEquals(expectedTotalPrice, actualTotalPrice);
    }

}

package com.demowebshop.ui.pages.common;

import com.demowebshop.ui.pages.cart.ShoppingCartPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductComponent {
    private final WebDriverWait wait;
    ShoppingCartPage shoppingCartPage;

    public ProductComponent(WebDriver driver) {
        PageFactory.initElements(driver, this);
        shoppingCartPage = new ShoppingCartPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(css = ".bar-notification p")
    WebElement productAddedBarMessage;

    public void clickOnProduct(String buttonName, String productName) {
        switch (buttonName){
            case "Add to cart":
                WebElement productBlock = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@class='product-item'][.//a[contains(text(), '" + productName + "')]]")
                ));

                WebElement productButton = productBlock.findElement(By.xpath(".//input[@value='" + buttonName + "']"));

                wait.until(ExpectedConditions.elementToBeClickable(productButton)).click();
                break;
            case "Remove from cart":
                shoppingCartPage.clickRemoveCheckBox(productName);
                break;
        }
    }

    public void validateProductAddedMessage(String expectedMessage) {
        wait.until(ExpectedConditions.visibilityOf(productAddedBarMessage));

        Assert.assertEquals(expectedMessage, productAddedBarMessage.getText());
    }
}

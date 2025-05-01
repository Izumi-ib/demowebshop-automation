package com.demowebshop.ui.pages.common;

import com.demowebshop.ui.pages.cart.ShoppingCartPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import java.time.Duration;

public class ProductComponent {
    private final WebDriverWait wait;
    private final Actions actions;
    ShoppingCartPage shoppingCartPage;

    public ProductComponent(WebDriver driver) {
        PageFactory.initElements(driver, this);
        shoppingCartPage = new ShoppingCartPage(driver);

        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(css = ".bar-notification p")
    WebElement productAddedBarMessage;

    public void clickOnProduct(String buttonName, String productName) {
        System.out.println(productName);
        switch (buttonName) {
            case "Add to cart":
                WebElement productButton = wait.until(ExpectedConditions.elementToBeClickable(
//                        By.xpath("//div[@class='details'][.//a[contains(text(), '" + productName + "')]]//input[contains(@class, 'product-box-add-to-cart-button')]")
                        By.xpath("//div[@class='details'][.//a[contains(text(), 'TCP Instructor Led Training')]]//input[contains(@class, 'product-box-add-to-cart-button')]")
                ));

                actions.moveToElement(productButton).perform();
                actions.click(productButton).perform();

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

package com.demowebshop.ui.actions;

import com.demowebshop.ui.actions.authActions.LoginActions;
import com.demowebshop.ui.pages.auth.LoginPage;
import com.demowebshop.ui.pages.cart.ShoppingCartPage;
import com.demowebshop.ui.pages.common.ProductComponent;
import io.cucumber.java.eo.Do;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AllureUtils;

import java.util.List;
import java.util.Map;

public class CartActions {
    private final ShoppingCartPage shoppingCartPage;
    private final ProductComponent productComponent;
    private static final Logger logger = LoggerFactory.getLogger(CartActions.class);

    public CartActions(WebDriver driver) {
        shoppingCartPage = new ShoppingCartPage(driver);
        productComponent = new ProductComponent(driver);
    }

    @Step("User clicks on {buttonName} button for product with name {productName}")
    public void clickOnProduct(String buttonName, String productName) {
        AllureUtils.log(logger, "Clicking on " + buttonName + " button for product with name " + productName + "");
        productComponent.clickOnProduct(buttonName, productName);
    }

    @Step("User validates {expectedMessage} product added message on the top of the page")
    public void validateProductAddedMessage(String expectedMessage) {
        AllureUtils.log(logger, "Validating that the product added message is: '" + expectedMessage + "' at the top of the page.");
        productComponent.validateProductAddedMessage(expectedMessage);
    }

    @Step("User verifies the product with name {expectedProductName} is on cart page")
    public void verifyTheProductIsAddedToCart(String expectedProductTitle) {
        AllureUtils.log(logger, "Verifying that the product with name " + expectedProductTitle + " was added to cart");
        shoppingCartPage.verifyProductIsAdded(expectedProductTitle);
    }

    @Step("User clicks on {buttonName} button in shopping page")
    public void clickButtonInShoppingPage(String buttonName) {
        AllureUtils.log(logger, "Clicking on " + buttonName + " button in shopping page");
        shoppingCartPage.clickButtonInShoppingCart(buttonName);
    }

    @Step("User should see {expectedMessage}")
    public void verifyMessageInShoppingCart(String expectedMessage) {
        AllureUtils.log(logger, "Validating " + expectedMessage + " message in Shopping cart");
        switch (expectedMessage) {
            case "Your Shopping Cart is empty!":
                shoppingCartPage.validateCartIsEmptyMessage(expectedMessage);
        }
    }


    @Step("User clicks {buttonName} and adds following products:")
    public void clickButtonAndAddProducts(String buttonName, List<Map<String, String>> products) {
        for (Map<String, String> row : products) {
            String productTitle = row.get("productTitle");

            AllureUtils.log(logger, "User adds following product " + productTitle + " to cart");
            productComponent.clickOnProduct(buttonName, productTitle);
        }
    }

    @Step("User should see total price:{expectedTotalPrice} of the products")
    public void verifyTotalPriceOfProducts(String expectedPrice) {
        double expectedTotalPrice = Double.parseDouble(expectedPrice);

        AllureUtils.log(logger, "User should see total price:" + expectedTotalPrice + "of the products");
        shoppingCartPage.getTotalPrice(expectedTotalPrice);
    }


}

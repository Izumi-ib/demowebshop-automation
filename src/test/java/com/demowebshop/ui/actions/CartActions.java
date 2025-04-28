package com.demowebshop.ui.actions;

import com.demowebshop.ui.actions.authActions.LoginActions;
import com.demowebshop.ui.pages.auth.LoginPage;
import com.demowebshop.ui.pages.cart.ShoppingCartPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AllureUtils;
import utils.ConfigReader;

public class CartActions {
    private WebDriver driver;
    private final ShoppingCartPage shoppingCartPage;
    private static final Logger logger = LoggerFactory.getLogger(CartActions.class);

    public CartActions (WebDriver driver){
        this.driver = driver;
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    @Step("Navigating to Cart page")
    public void navigateToCartPage(){
        AllureUtils.log(logger, "Navigating to Cart page");
        driver.get(ConfigReader.readProperty("baseUrl") + "cart");
    }




}

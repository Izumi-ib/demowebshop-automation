package com.demowebshop.ui.actions;

import com.demowebshop.ui.actions.authActions.LoginActions;
import com.demowebshop.ui.pages.auth.LoginPage;
import com.demowebshop.ui.pages.catalog.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AllureUtils;
import utils.ConfigReader;

public class CommonActions {

    private WebDriver driver;

    private final HomePage homePage;
    private static final Logger logger = LoggerFactory.getLogger(LoginActions.class);

    public CommonActions(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
    }

    @Step("User should see '{expectedUsername}' on the home page")
    public void validateUsername(String expectedUsername){
        logger.info("Verifying that {} is displayed", expectedUsername);
        homePage.validateProfileInfo(expectedUsername);
    }

    @Step("User navigates to {pageTitle} page")
    public void navigateToPage(String pageTitle) {
        AllureUtils.log(logger, "Navigating to " + pageTitle + " page");
        driver.get(ConfigReader.readProperty("baseUrl") + pageTitle);
    }


}

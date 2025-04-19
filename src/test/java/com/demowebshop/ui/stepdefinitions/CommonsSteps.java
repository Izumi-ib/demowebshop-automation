package com.demowebshop.ui.stepdefinitions;


import com.demowebshop.ui.pages.catalog.HomePage;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DriverHelper;

public class CommonsSteps {
    private final WebDriver driver = DriverHelper.getDriver();
    private final HomePage homePage = new HomePage(driver);
    private final Logger logger = LoggerFactory.getLogger(CommonsSteps.class);


    @Step("User should see '{expectedUsername}' on the home page")
    @Then("the user should see {string} on the home page")
    public void the_user_should_see_on_the_home_page(String expectedTitle) {
        logger.info("Verifying that {} is displayed", expectedTitle);
        homePage.validateProfileInfo(expectedTitle);
    }

}

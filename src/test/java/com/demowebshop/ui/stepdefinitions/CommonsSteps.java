package com.demowebshop.ui.stepdefinitions;


import com.demowebshop.ui.pages.catalog.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DriverHelper;

public class CommonsSteps {
    private final WebDriver driver = DriverHelper.getDriver();
    private final CommonActions commonActions = new CommonActions(driver);

    @Then("the user should see {string} on the home page")
    public void the_user_should_see_on_the_home_page(String expectedTitle) {
        commonActions.validateUsername(expectedTitle);
    }

    @Given("the user is on {string} page")
    public void the_user_is_on_page(String pageTitle){
        commonActions.navigateToPage(pageTitle);
    }

}

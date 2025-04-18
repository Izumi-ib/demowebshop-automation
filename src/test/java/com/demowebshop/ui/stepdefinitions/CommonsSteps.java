package com.demowebshop.ui.stepdefinitions;


import com.demowebshop.ui.pages.catalog.HomePage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class CommonsSteps {
    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);

    @Then("the user should see {string} on the home page")
    public void the_user_should_see_on_the_home_page(String expectedTitle) {
        homePage.validateProfileInfo(expectedTitle);
    }

}

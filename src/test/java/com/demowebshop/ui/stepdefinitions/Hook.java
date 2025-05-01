package com.demowebshop.ui.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import utils.AllureUtils;
import utils.ConfigReader;
import utils.DriverHelper;


public class Hook {
    WebDriver driver = DriverHelper.getDriver();

    @Before
    public void setUp(Scenario scenario) {
        driver.get(ConfigReader.readProperty("baseUrl"));
    }

    @After
    public void tearDown(Scenario scenario) {
            if (scenario.isFailed()) {
                AllureUtils.takeScreenshot(driver);
            }
        DriverHelper.quitDriver();
    }

}

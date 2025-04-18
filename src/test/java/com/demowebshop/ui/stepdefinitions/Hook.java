package com.demowebshop.ui.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;


public class Hook {
    WebDriver driver = DriverHelper.getDriver();

    @Before
    public void setUp() {
        driver.get(ConfigReader.readProperty("baseUrl"));
    }

    @After
    public void tearDown() {
        DriverHelper.quitDriver();
    }

}

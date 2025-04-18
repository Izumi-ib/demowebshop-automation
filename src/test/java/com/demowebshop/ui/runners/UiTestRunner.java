package com.demowebshop.ui.runners;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/ui")
//@ConfigurationParameter(key = FEATURES_PROPERTY_NAME,value = "classpath:features/login.feature")
@ConfigurationParameter(key = "cucumber.glue", value = "com/demowebshop/ui/stepdefinitions")
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@ui")
@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
@ConfigurationParameter(key = "cucumber.plugin", value = "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm")
public class UiTestRunner {
}

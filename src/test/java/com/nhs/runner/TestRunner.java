package com.nhs.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * @author Sreej
 */

@CucumberOptions(features = "src/test/resources/features/NHSCostChecker.feature", glue = {"com/nhs/stepDefinitions"},
        monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }


}

package com.nhs.stepDefinitions;

import com.nhs.driver.Driver;
import com.nhs.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


/**
 * @author Sreej
 */
public class Hooks {

    @Before
    public static void setUp() {
        String browser = System.getProperty("browser");
        Driver.initDriver(browser);
    }

    @After
    public static void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.quitDriver();
    }

}

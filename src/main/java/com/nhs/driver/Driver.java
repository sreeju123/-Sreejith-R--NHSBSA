package com.nhs.driver;

import java.util.Objects;

/**
 * @author Sreej
 */
public class Driver {

    private Driver() {

    }

    public static void initDriver(String browser) {
        if (Objects.isNull(DriverManager.getDriver())) {
            DriverManager.setDriver(DriverFactory.get(browser));
            DriverManager.getDriver().manage().window().maximize();
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }

}

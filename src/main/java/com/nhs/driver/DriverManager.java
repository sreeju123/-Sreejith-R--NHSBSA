package com.nhs.driver;

import org.openqa.selenium.WebDriver;

/**
 * @author Sreej
 */
public class DriverManager {

    private DriverManager() {
    }

    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return threadLocal.get();
    }

    public static void setDriver(WebDriver driver) {
        threadLocal.set(driver);
    }

    public static void unload() {
        threadLocal.remove();
    }

}

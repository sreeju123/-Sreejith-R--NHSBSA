package com.nhs.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Sreej
 */
public class DriverFactory {

    private DriverFactory() {

    }
//    static String browser = System.getProperty("chrome");

    public static WebDriver get(String browser) {

        WebDriver driver = null;

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }
        return driver;
    }


}

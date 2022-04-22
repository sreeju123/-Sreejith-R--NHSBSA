package com.nhs.pages;

import com.nhs.contants.FrameworkConstants;
import com.nhs.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Sreej
 */
public class BasePage {

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    protected void click(WebElement element, String elementName) {
        explicitlyWaitForElementToBePresent(element);
        explicitlyWaitForElementToBeClickable(element);
        element.click();
    }

    protected void click(By by, String elementName) {
        DriverManager.getDriver().findElement(by).click();
    }

    protected void sendKeys(WebElement element, String value) {
        explicitlyWaitForElementToBePresent(element);
        explicitlyWaitForElementToBeClickable(element);
        element.sendKeys(value);
    }

    private void explicitlyWaitForElementToBeClickable(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getEXPLICITWAIT())
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    private void explicitlyWaitForElementToBePresent(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getEXPLICITWAIT())
                .until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}

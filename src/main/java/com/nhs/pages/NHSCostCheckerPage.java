package com.nhs.pages;

import com.nhs.utils.DynamicXpathUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * @author Sreej
 */
public class NHSCostCheckerPage extends BasePage {

    @FindBy(id = "next-button")
    private WebElement buttonStart;

    @FindBy(id = "next-button")
    private WebElement buttonNext;

    @FindBy(id = "dob-day")
    private WebElement fieldDay;

    @FindBy(id = "dob-month")
    private WebElement fieldMonth;

    @FindBy(id = "dob-year")
    private WebElement fieldYear;

    @FindBy(xpath = "//div[@class='done-panel']")
    private WebElement resultDonePanel;

    @FindBy(id = "result-heading")
    private WebElement resultMessage;

    @FindBy(xpath = "//*[contains(text(),'You get free:')]/following-sibling::ul[1]")
    private WebElement headerYouGetFree;

    @FindBy(xpath = "//*[contains(text(),'You get money off:')]/following-sibling::ul[1]")
    private WebElement headerGetMoneyOff;

    @FindBy(className = "nhsbsa-list-item__description")
    private List<WebElement> descriptionYouGetFree;

    private String questions = "//*[contains(text(),'%s')]/following::input[contains(@value,'%s')]";

    public WebElement getResultDonePanel() {
        return resultDonePanel;
    }

    public WebElement getResultMessage() {
        return resultMessage;
    }

    public WebElement getHeaderYouGetFree() {
        return headerYouGetFree;
    }

    public WebElement getHeaderGetMoneyOff() {
        return headerGetMoneyOff;
    }

    public List<WebElement> getDescriptionYouGetFree() {
        return descriptionYouGetFree;
    }

    public void clickStartButton() {
        click(buttonStart, "Start Button");
    }

    public void clickNextButton() {
        click(buttonNext, "Next Button");
    }

    public void clickRadioButton(String question, String answer) {
        String newXpath = DynamicXpathUtils.getXpath1(questions, question, answer);
        click(By.xpath(newXpath), "answer");
    }

    public void enterDOB(String day, String month, String year) {
        sendKeys(fieldDay, day);
        sendKeys(fieldMonth, month);
        sendKeys(fieldYear, year);
    }

    public boolean resultDonePanel() {
        return isElementPresent(getResultDonePanel());
    }

    public boolean resultMessage() {
        return isElementPresent(getResultMessage());
    }


}

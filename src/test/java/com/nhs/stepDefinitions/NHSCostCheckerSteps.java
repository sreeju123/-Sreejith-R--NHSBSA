package com.nhs.stepDefinitions;

import com.nhs.driver.DriverManager;
import com.nhs.enums.ConfigProperties;
import com.nhs.pages.NHSCostCheckerPage;
import com.nhs.utils.PropertyUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * @author Sreej
 */
public class NHSCostCheckerSteps {

    NHSCostCheckerPage nhsCostCheckerPage = new NHSCostCheckerPage();

    @Given("The user lands on the {string} page")
    public void the_user_lands_on_the_page(String page) {
        switch (page) {
            case "NHS check for help":
                DriverManager.getDriver().get(PropertyUtils.getValue(ConfigProperties.URL));
                break;
            default:
                throw new RuntimeException();
        }

    }

    @Given("The user clicks  {string} button on the NHS check for help page")
    public void the_user_clicks_button_on_the_page(String button) {
        switch (button) {
            case "Start":
                nhsCostCheckerPage.clickStartButton();
                break;
            default:
                throw new RuntimeException();
        }
    }

    @Given("The user clicks {string} button")
    public void the_user_clicks_button(String button) {
        switch (button) {
            case "Next":
                nhsCostCheckerPage.clickNextButton();
                break;
            default:
                throw new RuntimeException();
        }

    }

    @Given("The user clicks {string} for {string} question")
    public void the_user_clicks_for_question(String answer, String question) {
        nhsCostCheckerPage.clickRadioButton(question, answer);
    }

    @Given("The user enters DOB {string} on the Date of birth page")
    public void the_user_enters_DOB_on_the_Date_of_birth_page(String dob) {
        String[] DOB = dob.split("-");
        nhsCostCheckerPage.enterDOB(DOB[0], DOB[1], DOB[2]);
    }

    @Given("The user validates the NHS cost result contains {string}")
    public void the_user_validates_the_NHS_cost_result_contains(String text) {
        if (nhsCostCheckerPage.resultDonePanel()) {
            Assert.assertTrue(nhsCostCheckerPage.getResultDonePanel().getText().contains(text));
        } else if (nhsCostCheckerPage.resultMessage()) {
            Assert.assertTrue(nhsCostCheckerPage.getResultMessage().getText().contains(text));
        }
    }

    @Then("The user validates the free treatments {string}")
    public void the_user_validates_the_free_treatments(String description) {
        String[] freeTreatmentDesc = description.split(" - ");
        for (int i = 0; i < nhsCostCheckerPage.getDescriptionYouGetFree().size(); i++) {
            String text = nhsCostCheckerPage.getDescriptionYouGetFree().get(i).getText();
            Assert.assertTrue(text.contains(freeTreatmentDesc[i]));
        }
    }

    @Then("The user validates the available {string} treatments {string}")
    public void the_user_validates_the_available_treatments(String options, String treatments) {
        switch (options) {
            case "free":
                String[] solutions = treatments.split(" - ");
                int size = nhsCostCheckerPage.getHeaderYouGetFree().findElements(By.xpath("./li")).size();
                for (int i = 1; i <= size; i++) {
                    String text = nhsCostCheckerPage.getHeaderYouGetFree().findElement(By.xpath("./li[" + i + "]")).getText();
                    Assert.assertTrue(text.contains(solutions[i - 1]));
                }
                break;
            case "money off":
                String[] solutions1 = treatments.split(" - ");
                int size1 = nhsCostCheckerPage.getHeaderGetMoneyOff().findElements(By.xpath("./li")).size();
                for (int i = 1; i <= size1; i++) {
                    String text = nhsCostCheckerPage.getHeaderGetMoneyOff().findElement(By.xpath("./li[" + i + "]")).getText();
                    Assert.assertTrue(text.contains(solutions1[i - 1]));
                }
                break;
            default:
                throw new RuntimeException();
        }

    }

}

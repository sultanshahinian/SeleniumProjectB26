package com.cydeo.test.day7_testNG_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebDriverFactory;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T2_StateDropdown {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //    1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown
        // set up chrome and create WebDriver instance
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/dropdown");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void stateDropdownTest() {
        //3. Select Illinois
        //4. Select Virginia
        //5. Select California
        //6. Verify final selected option is California.
        //    Use all Select options. (visible text, value, index)

        Select stateDropdown = new Select(driver.findElement(By.id("state")));

        //3. Select Illinois  selectByValue
        stateDropdown.selectByValue("IL");

        //4. Select Virginia  selectByVisibleText
        stateDropdown.selectByVisibleText("Virginia");

        //5. Select California   selectByIndex
        stateDropdown.selectByIndex(5);

        String actualStateOption = stateDropdown.getFirstSelectedOption().getText();
        String expectedStateOption = "California";

        Assert.assertEquals(actualStateOption, expectedStateOption, "state dropdown verification failed");
    }

    @Test
    public void multiSelectDropdownTest() {
//        3. Select all the options from multiple select dropdown.
        Select languages = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

        System.out.println("languages.isMultiple() = " + languages.isMultiple());

        languages.selectByValue("java");
        languages.selectByVisibleText("C#");
        languages.deselectByIndex(3);


//        4. Print out all selected values.
        for (WebElement each : languages.getOptions()) {
            each.click();
            System.out.println("each.getText() = " + each.getText());
        }


//        5. Deselect all values.
        languages.deselectAll();

    }


}
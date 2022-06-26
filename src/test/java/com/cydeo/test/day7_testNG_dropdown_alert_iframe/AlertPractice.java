package com.cydeo.test.day7_testNG_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebDriverFactory;
import com.google.common.base.Verify;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertPractice {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        //        1. Open browser


        // set up chrome and create WebDriver instance
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //        2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }


    @Test
    public void informationAlertTest() {

//        3. Click to “Click for JS Alert” button
        WebElement jsAlertBTN = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        jsAlertBTN.click();

//        4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

//        5. Verify “You successfully clicked an alert” text is displayed.

        WebElement resultText = driver.findElement(By.id("result"));
        Assert.assertTrue(resultText.isDisplayed());

        String actualResultText = resultText.getText();
        String expectedResultText = "You successfully clicked an alert";
        Assert.assertEquals(actualResultText, expectedResultText, "Result text did not appear correctly");
    }
}

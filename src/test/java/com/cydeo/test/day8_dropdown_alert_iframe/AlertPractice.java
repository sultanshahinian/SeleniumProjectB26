package com.cydeo.test.day8_dropdown_alert_iframe;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertPractice {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void confirmAlertTest() {
//        3. Click to “Click for JS Confirm” button
        WebElement confirmAlertBtn = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirmAlertBtn.click();

//        4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();


//        5. Verify “You clicked: Ok” text is displayed.

        WebElement resultText = driver.findElement(By.id("result"));
        Assert.assertTrue(resultText.isDisplayed(), "result test did not appear");

        String actualText = resultText.getText();
        String expectedText = "You clicked: Ok";
        Assert.assertEquals(actualText, expectedText, "The result is not good");
    }

    @Test
    public void promptAlertTest() {
//        3. Click to “Click for JS Prompt” button
        WebElement jsPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsPrompt.click();

//        4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");


//        5. Click to OK button from the alert
        alert.accept();

//        6. Verify “You entered: hello” text is displayed.
        WebElement resultText = driver.findElement(By.id("result"));

        String actualText = resultText.getText();
        String expectedText = "You entered: hello";
        Assert.assertTrue(resultText.isDisplayed(), "result test did not appear");
        Assert.assertEquals(actualText, expectedText, "Result test did not appear correctly");
    }


}

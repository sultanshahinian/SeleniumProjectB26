package com.cydeo.test.day7_testNG_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Selenium {

    WebDriver driver;

    @BeforeMethod
    public void SetUpMethod(){
        // set up chrome and create WebDriver instance
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void teardownMethod(){
        driver.quit();
    }

    @Test
    public void googleTitle(){

        // Get "https://google.com/"
        driver.get("https://google.com");


        // Assert: title is  "Google"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        Assert.assertEquals(actualTitle,expectedTitle, "Title verification is failed.");

    }

    @Test
    public void yahooTitle(){
        driver.get("https://yahoo.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Yahoo";
        Assert.assertEquals(actualTitle,expectedTitle, "Title verification is failed.");
    }

    @Test
    public void etsyTitle(){
        driver.get("https://etsy.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Etsy";
        Assert.assertEquals(actualTitle,expectedTitle, "Title verification is failed.");
    }

}

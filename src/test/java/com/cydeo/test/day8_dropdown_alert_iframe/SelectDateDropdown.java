package com.cydeo.test.day8_dropdown_alert_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SelectDateDropdown {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void dateDropDownTest(){

//        3. Select “December 1st, 1923” and verify it is selected.
        Select yearDropdown = new Select(driver.findElement(By.id("year")));
        Select monthDropdown = new Select(driver.findElement(By.id("month")));
        Select dayDropdown = new Select(driver.findElement(By.id("day")));

//                Select year using   : visible text
        yearDropdown.selectByVisibleText("1923");


//        Select month using    : value attribute Select
        monthDropdown.selectByValue("11");

//        day using : index number
        dayDropdown.selectByIndex(0);

        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        String expectedYear = "1923";
        String expectedMonth = "December";
        String expectedDay = "1";

        Assert.assertTrue(actualYear.equals(expectedYear),"Year selection did not pass");

        Assert.assertTrue(actualMonth.equals(expectedMonth),"Month selection did not pass");
        Assert.assertTrue(actualDay.equals(expectedDay),"Day selection did not pass");

        Assert.assertEquals(actualYear, expectedYear, "Year selection did not pass");
        Assert.assertEquals(actualMonth, expectedMonth, "Month selection did not pass");
        Assert.assertEquals(actualDay, expectedDay, "Year selection did not pass");



    }
}

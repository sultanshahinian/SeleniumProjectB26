package com.cydeo.test.day6_StaleElement_TestNG;

import com.cydeo.test.utilities.WebDriverFactory;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T1_StaleElementRefException {
    public static void main(String[] args) {


//    TC #1: StaleElementReferenceException handling
//      1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

//      2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.get("https://practice.cydeo.com/add_remove_elements/");
//
//      3. Click to “Add Element” button
        WebElement addElementBtn = driver.findElement(By.xpath("//button[.='Add Element']"));
        addElementBtn.click();

//      4. Verify “Delete” button is displayed after clicking.
        WebElement deletebtn = driver.findElement(By.xpath("//button[@class='added-manually']") );
        System.out.println("before clicking the delete button = " + deletebtn.isDisplayed());

//      5. Click to “Delete” button.
        deletebtn.click();

//      6. Verify “Delete” button is NOT displayed after clicking.
       // System.out.println("after clicking the delete button = " + deletebtn.isDisplayed());

        try {
            System.out.println("after clicking the delete button = " + deletebtn.isDisplayed());
        }catch(StaleElementReferenceException e){
            System.out.println("StaleElementReferenceException is thrown" );
            System.out.println("this means the web element is completely deleted from the page and html");
        }
       driver.quit();

    }
}
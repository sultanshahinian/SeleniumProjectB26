package com.cydeo.test.day2_locators;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_linkTextPractice {

    public static void main(String[] args) throws InterruptedException {


//      1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//      2- Go to: https://practice.cydeo.com/
        driver.get("https://practice.cydeo.com/");

        Thread.sleep(3000);

//      3- Click to A/B Testing from top of the list
        WebElement abLinkText = driver.findElement(By.linkText("A/B Testing"));
        abLinkText.click();

        Thread.sleep(3000);

//      4- Verify title is:
//      Expected: No A/B Test
        String expectedTitle = "No A/B Test";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("No A/B test Title Verification Passed");
        } else {
            System.out.println("No A/B test Title Verification Failed");
        }

//      5- Go back to home page by using the .back();

        driver.navigate().back();


//      6- Verify title equals:
//      Expected: Practice

        expectedTitle = "Practice";
        actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Practice Title Verification Passed");
        } else {
            System.out.println("Practice Title Verification Failed");
        }

        driver.quit();

    }
}
package com.cydeo.test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2_CydeoVerification {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com");

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "cydeo";

        if (actualURL.contains(expectedURL)){
            System.out.println("URL Test passed");
        }else{
            System.out.println("URL test failed");
        }

        String actualTitle = driver.getTitle();
        String expectedTitle = "Practice";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title test passed");
        }else{
            System.out.println("Title test failed");
        }



        driver.quit();
    }
}

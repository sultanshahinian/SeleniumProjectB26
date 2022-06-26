package com.cydeo.test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_YahooTitleVerification {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.yahoo.com");

        String actualTitle = driver.getTitle();

        String expectedTitle = "Yahoo";

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        driver.quit();


    }
}
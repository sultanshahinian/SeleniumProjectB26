package com.cydeo.test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basic_Navigations {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.etsy.com");  //easier and shorter so we use this one.

//        driver.navigate().to("https://www.etsy.com");  this does the same as get() but it is longer so we don't use it very much

        Thread.sleep(1000);
        driver.navigate().back();

        Thread.sleep(1000);
        driver.navigate().forward();

        Thread.sleep(1000);
        driver.navigate().refresh();

        System.out.println("driver.getTitle() = " + driver.getTitle());

        driver.get("https://www.tesla.com");
        String currentTitle = driver.getTitle();
        System.out.println(currentTitle);

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        //this will close the currently opened page
        driver.close();

        //this will close all of the pages/tabs
        driver.quit();

    }

}

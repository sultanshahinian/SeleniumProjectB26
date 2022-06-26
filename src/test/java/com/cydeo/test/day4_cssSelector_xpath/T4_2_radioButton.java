package com.cydeo.test.day4_cssSelector_xpath;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T4_2_radioButton {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/radio_buttons");

        //locate all sport radio buttons
        List<WebElement> sportRadioBtns = driver.findElements(By.xpath("//input[@name='sport']"));

        for (WebElement each : sportRadioBtns) {
            each.click();
        }


        driver.quit();
    }
}

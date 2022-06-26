package com.cydeo.test.day4_cssSelector_xpath;

import com.cydeo.test.utilities.WebDriverFactory;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T4_radioButton {
    public static void main(String[] args) {
//        1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

//        3. Click to “Hockey” radio button
        WebElement hockeyRadiobtn = driver.findElement(By.xpath("//input[@id='hockey']"));
        hockeyRadiobtn.click();

//        4. Verify “Hockey” radio button is selected after clicking.
        System.out.println("hockeyRadiobtn.isSelected() = " + hockeyRadiobtn.isSelected());

//        5. Locate green button
        WebElement greenRadioBtn = driver.findElement(By.xpath("//input[@id='green']"));

//        6. verify if its enabled
        System.out.println("greenRadioBtn.isEnabled() = " + greenRadioBtn.isEnabled());


        driver.quit();
    }
}

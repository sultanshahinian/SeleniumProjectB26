package com.cydeo.test.day15_upload_actions;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.internal.ConfigurationGroupMethods;

public class T2_Actions_Hover_Practices {

    @Test
    public void google_actions_hover_test() {

        //    1. Go to https://www.google.com

        Driver.getDriver().get(ConfigurationReader.getProperty(("google.url")));


        //    2. Hover over on Search button
        WebElement searchBtn = Driver.getDriver().findElement(By.xpath("//input@id='gbqfbb']preceding-sibling::input"));
        WebElement feelingLuckyBtn = Driver.getDriver().findElement(By.id("gbqfbb"));

        Actions actions = new Actions(Driver.getDriver());
        //    3. Hover over on Feeling Lucky button
        actions.moveToElement(searchBtn).perform();
        actions.moveToElement(feelingLuckyBtn).perform();

    }
}

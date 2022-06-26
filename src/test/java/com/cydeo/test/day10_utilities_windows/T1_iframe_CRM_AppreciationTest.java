package com.cydeo.test.day10_utilities_windows;

import com.cydeo.test.base.TestBase;
import com.cydeo.test.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_iframe_CRM_AppreciationTest extends TestBase {

    @Test

    public void sendingAppreciationMsg() {

//        2- Go to: https://login2.nextbasecrm.com/
//        driver.get("https://login2.nextbasecrm.com/");

//        3- Login Homepage ( Login with valid username and password)
        CRM_Utilities.crm_login(driver);
//        WebElement username = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
//        username.sendKeys("helpdesk1@cybertekschool.com");
//
//        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
//        password.sendKeys("UserUser");
//
//        WebElement loginBtn = driver.findElement(By.xpath("//input[@class='login-btn']"));
//        loginBtn.click();

//        4- Click the MORE tab and select APPRECIATION
        WebElement moreBtn = driver.findElement(By.cssSelector("span[id$='link-text']"));
        moreBtn.click();

        WebElement appreciation = driver.findElement(By.xpath("//span[.='Appreciation']"));
        appreciation.click();

//        5- Write an Appreciation message
        driver.switchTo().frame(driver.findElement(By.cssSelector(".bx-editor-iframe")));
        driver.findElement(By.tagName("body")).sendKeys("hello");


//        6- Click the SEND button
        driver.switchTo().defaultContent();
        WebElement sendBtn = driver.findElement(By.id("blog-submit-button-save"));
        sendBtn.click();


//        7- Verify the Appreciation message is displayed on the feed
WebElement feedText = driver.findElement(By.xpath("//div[starts-with(@id,'blog_post_body')]"));
String actualText =feedText.getText();
String expectedText ="hello";
Assert.assertEquals(actualText,expectedText, "Feed Message did not load correctly");



    }
}

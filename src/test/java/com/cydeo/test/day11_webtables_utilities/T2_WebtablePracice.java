package com.cydeo.test.day11_webtables_utilities;

import com.cydeo.test.base.TestBase;
import com.cydeo.test.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_WebtablePracice extends TestBase {

    @Test
    public void order_name_verify_test(){

//        1. Goto : https://practice.cydeo.com/web-tables
        driver.get("https://practice.cydeo.com/web-tables");

//        2. Verify Bob’s name is listed as expected.
//        Expected: “Bob Martin”

        WebElement BobMartinCell = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));

        String actualBobName = BobMartinCell.getText();
        String expectedBobName = "Bob Martin";

        Assert.assertEquals(actualBobName, expectedBobName, "Bob name did not appear correctly");


//        3. Verify Bob Martin’s order date is as expected: 12/31/2021

        WebElement bobMartinDataCell = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']/following-sibling::td[3]"));

        String actualBobMartinDateCell = bobMartinDataCell.getText();
        String expectedBobMartinDateCell = "12/31/2021";

        Assert.assertEquals(actualBobMartinDateCell, expectedBobMartinDateCell, "Date test does not pass");


    }

    @Test
    public void test2(){
        driver.get("https://practice.cydeo.com/web-tables");

        String customerOrderDate1 = WebTableUtils.returnOrderDate(driver, "Alexandra Gray");
        System.out.println("customerOrderDate1 = " + customerOrderDate1);

        String customerOrderDate2 = WebTableUtils.returnOrderDate(driver, "Ned Stark");
        System.out.println("customerOrderDate2 = " + customerOrderDate2);

    }

    @Test
    public void test3(){
        driver.get("https://practice.cydeo.com/web-tables");

        WebTableUtils.orderVerify(driver,"Alexandra Gray","04/15/2021");
    }

}

package com.cydeo.test.day17_pom_syncronization;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class T1_ActionsPractice {

    @Test
    public void cydeo_practice_drag_and_drop_test() {
//        1. Open a chrome browser
//        2. Go to:
//        https://practice.cydeo.com/drag_and_drop_circles

        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");


//        3. Click and hold small circle
        //   //div[@id='draggable']  small circle

//        4. Move it on top of the big circle
        //  //div[@id='droptarget']
//        5. And release on it.

        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        Actions actions = new Actions(Driver.getDriver());

        actions.dragAndDrop(smallCircle, bigCircle).perform();

//        6. Verify “You did great!” text appears on big circle
        Assert.assertEquals(bigCircle.getText(), "You did great!");

    }

    @Test
    public void cydeo_practice_drag_and_drop_test2() {  //same as above but uses click and hold
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");

        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(smallCircle)
                .clickAndHold()
                .moveToElement(bigCircle)
                .release().perform();

        Assert.assertEquals(bigCircle.getText(), "You did great!");

    }

    @AfterClass
    public void teardown() {
        Driver.closeDriver();
    }
}
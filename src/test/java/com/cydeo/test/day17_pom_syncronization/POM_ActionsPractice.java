package com.cydeo.test.day17_pom_syncronization;

import com.cydeo.pages.CydeoPracticePage;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class POM_ActionsPractice {

    CydeoPracticePage cydeoPracticePage;
    Actions actions;

    @BeforeMethod
    public void setupMethod(){
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");
        cydeoPracticePage = new CydeoPracticePage();
        actions = new Actions(Driver.getDriver());

    }


    @Test
    public void drag_small_circle_text() {  //page starts with 'Drag the small circle here'
//        1. Open a chrome browser
//        2. Go to:
//        https://practice.cydeo.com/drag_and_drop_circles

//        3. Verify expected default text appears on big circle
//                Expected = "Drag the small circle here."

        Assert.assertEquals(cydeoPracticePage.bigCircle.getText(), "Drag the small circle here.");


    }


    @Test
    public void drop_here_text() {  //after clicking small circle and starting to move the large cirlce says 'drop here'
//        TC #3: Cydeo Practice Drag and Drop Test
//        1. Open a chromee browser
//        2.  Go to:
//        https://practice.cydeo.com/drag_and_drop_circles

//        3. Click and hold small circle


        actions.moveToElement(cydeoPracticePage.smallCircle)
                .clickAndHold()
                .moveByOffset(100,0)
                .perform();


//        4. Verify "Drop here." text appears on big circle
        Assert.assertEquals(cydeoPracticePage.bigCircle.getText(), "Drop here.");


    }
// add method for dropping the circle outside the big one

    @Test
    public void tryAgainTxt(){

        actions.moveToElement(cydeoPracticePage.smallCircle)
                .clickAndHold()
                .moveByOffset(100,0)
                .release()
                .perform();
        Assert.assertEquals(cydeoPracticePage.bigCircle.getText(), "Try again!");
    }


    //add method for hovering over the big circle but not release it

    @Test
    public void nowDropTxt(){
        actions.moveToElement(cydeoPracticePage.smallCircle)
                .clickAndHold()
                .moveToElement(cydeoPracticePage.bigCircle)
                .perform();
        Assert.assertEquals(cydeoPracticePage.bigCircle.getText(), "Now drop...");

    }


    @AfterClass
    public void teardown() {
        Driver.closeDriver();
    }
}
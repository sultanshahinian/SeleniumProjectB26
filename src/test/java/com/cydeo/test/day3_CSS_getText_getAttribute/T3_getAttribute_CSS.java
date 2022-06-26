package com.cydeo.test.day3_CSS_getText_getAttribute;

import com.cydeo.test.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_getAttribute_CSS {

    public static void main(String[] args) {
//        TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
//        1- Open a chrome browser
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

//        2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

//        3- Verify “Log in” button text is as expected:
//        Expected: Log In

        // Located using type attribute
        // WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));

        // Located using value attribute
        // WebElement loginButton = driver.findElement(By.cssSelector("input[value='Log In']"));

        // Located using class attribute
        WebElement loginButton = driver.findElement(By.cssSelector("input[class='login-btn']"));

        String expectedBtnText = "Log In";
        String actualBtnText = loginButton.getAttribute("value");

        if(actualBtnText.equals(expectedBtnText)){
            System.out.println("Log In button text verification passed!");
        }else{
            System.out.println("Log In button text verification failed!");
        }

        driver.quit();
    }
}


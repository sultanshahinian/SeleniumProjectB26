package com.cydeo.test.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    //Create a private constructor, we are closing access to the
    // object of this class from outside the class
    private Driver() {
    }

    //We make WebDriver private, because we want to close access from outside of class
    //We make it static, because we will use it inside static method
    private static WebDriver driver;  // value is null by default

    //Create a re-usable utility method which will return same driver instance when we call it
    public static WebDriver getDriver() {

        // it will check if driver is null and if it is we will set up browser inside if statement
        // if you already setup driver and are using it again for following lines of code, it will return to same driver
        if (driver == null) {

            //We read browserType from Configuration.properties with
            //help of ConfigurationReader Class' getDriver method
            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }

        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();//this line will terminate the existing session.value will not even be null
            driver = null;
        }

    }
}
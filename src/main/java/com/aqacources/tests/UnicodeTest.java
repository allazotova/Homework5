package com.aqacources.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class UnicodeTest {
    // Instance of WebDriver
    private WebDriver driver;

    /**
     * Set up method
     */
    @Before
    public void setUp() {

        // If you want to disable infobars please use this code
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");

        // Initialize path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver-2");

        // Initialize instance of ChromeDriver and add options
        driver = new ChromeDriver(options);

        // Set 10 second for implicitly wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Maximize window
        driver.manage().window().maximize();

    }

    /**
     * Open site, find and print chars
     */

    @Test
    public void testOpenGoogleTest() {

        // Open site
        driver.get("https://unicode-table.com/ru/");

        // Find char Q
        String char1 = driver.findElement(By.xpath("//li[@title='U+0051 | Dec: 81']")).getText();
        System.out.println("Char 1: "+ char1);

        // Find char &
        String char2 = driver.findElement(By.xpath("//li[@title='U+0026 | Dec: 38']")).getText();
        System.out.println("Char 2: " + char2);

        // Find char A
        String char3 = driver.findElement(By.xpath("//li[@title='U+0041 | Dec: 65']")).getText();
        System.out.println("Char 3: " + char3);

    }
        /**
         * After method, quit driver
         */
        @After
        public void tearDown () {

            // Quit from Driver. close() just close window,
            // quit() - close all window an driver
            driver.quit();
        }
    }

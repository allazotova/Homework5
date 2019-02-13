package com.aqacources.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DifferenceInPricesTest {

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
     * Open site, find and compare 2 prices
     */
    @Test
    public void testOpenGoogleTest() {

        // Open site
        driver.get("https://supsystic.com/example/comparison-example/");

        // Find a price before sale
        String phoneDefaultPriceString = driver.findElement(By.xpath("//span[contains(text(),'$2699')]")).getText();

        //cut the "$" char
        phoneDefaultPriceString = phoneDefaultPriceString.substring(1);

        //convert String to double
        double phoneDefaultPrice = Double.parseDouble(phoneDefaultPriceString);
        System.out.println("The price before sale: "+ phoneDefaultPrice + " USD");

        // Find a sale price
        String phoneSalePriceString = driver.findElement(By.xpath("//span[contains(text(),'$959.00')]")).getText();

        //cut the "$" char
        phoneSalePriceString = phoneSalePriceString.substring(1);

        //convert String to double
        double phoneSalePrice = Double.parseDouble(phoneSalePriceString);
        System.out.println("Sale price: " + phoneSalePrice + " USD");

        //find the difference in prices
        double differenceInPrices = (phoneDefaultPrice - phoneSalePrice);
        System.out.println("The difference in prices: "+ differenceInPrices + " USD");
    }

    /**
     * After method, quit driver
     */
    @After
    public void tearDown() {

        // Quit from Driver. close() just close window,
        // quit() - close all window an driver
        driver.quit();
    }

}

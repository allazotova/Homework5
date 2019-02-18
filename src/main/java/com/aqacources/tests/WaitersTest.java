package com.aqacources.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitersTest {
    // Instance of WebDriver
    private WebDriver driver;
    private WebDriverWait wait;

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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Maximize window
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver,5);

    }

    @Test
    public void testOpenGoogleTest() {

     // Open site
     driver.get("https://s1.demo.opensourcecms.com/s/44");

        //switching to frame
        driver.switchTo().frame("preview-frame");
        // find an username field
        WebElement emailField = driver.findElement(By.xpath("//*[@id='txtUsername']"));
        //type a username
        emailField.sendKeys("test.gmail");
        //find  a password field
      WebElement passwordField = driver.findElement(By.xpath("//*[@id='txtPassword']"));
      //type password
        passwordField.sendKeys("123123123");
        //click Login button
        driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
        //wait for message
      wait.until(ExpectedConditions.textToBe(By.xpath("//div[@id='divLoginButton']/span[@id='spanMessage']"),"Invalid credentials"));
        //leave username field empty
      driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("");
      //click Login button
      driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
      //wait for message
      wait.until(ExpectedConditions.textToBe(By.xpath("//div[@id='divLoginButton']/span[@id='spanMessage']"),"Username cannot be empty"));
      //type a username
       driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("qwerty");
       //leave password field empty
       driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("");
        //click Login button
       driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
        //wait for message
       wait.until(ExpectedConditions.textToBe(By.xpath("//div[@id='divLoginButton']/span[@id='spanMessage']"),"Password cannot be empty"));
    //exit from frame
      driver.switchTo().defaultContent();
      //click Remove Frame button
      driver.findElement(By.xpath("//span[contains(text(),'Remove Frame')]")).click();
   //check that frame is removed
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(),'Remove Frame')]")));
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

package com.bridgelabz.baseclass;

import com.bridgelabz.utility.ReadPropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;


public abstract class BaseClass extends ReadPropertyFile {

    public WebDriver driver;
    public static Logger log = Logger.getLogger(BaseClass.class.getName());

    public void setUp() {
        PropertyConfigurator.configure("C:\\Users\\EKTA\\IdeaProjects\\PageObjectModelInstagram\\log4j.properties");
        BasicConfigurator.configure();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(("https://www.instagram.com/"));
        driver.manage().window().maximize();
        log.info("Chrome browser has launched");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        log.debug("Implicit time wait");
    }

    public void closeBrowser() {
        driver.quit();
        log.info("quit");
        Reporter.log("Browser session ended!!!", true);
    }
}
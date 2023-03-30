package com.bridgelabz.page;

import com.bridgelabz.utility.ReadPropertyFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends ReadPropertyFile {

    WebDriver driver;

    @CacheLookup
    @FindBy(name = "username")
    WebElement userName;

    @CacheLookup
    @FindBy(name = "password")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"loginForm\"]/div/div[3]/button")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void loginInToTheInstagram(String uName, String pass) throws InterruptedException {
        driver.findElement(By.name(properties.getProperty("loginUserNameData"))).sendKeys(uName);
        password.sendKeys(pass);
        loginButton.click();
        Thread.sleep(500);
        redirectOnToTheHomePage();
    }

    public void redirectOnToTheHomePage() {
        String title = driver.getTitle();
        Assert.assertEquals("Instagram",title);
    }
}
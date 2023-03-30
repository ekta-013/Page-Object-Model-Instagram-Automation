package com.bridgelabz.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    WebDriver driver;

    @CacheLookup
    @FindBy(linkText = "Sign up")
    WebElement signUpLink;

    @CacheLookup
    @FindBy(name = "emailOrPhone")
    WebElement email;

    @CacheLookup
    @FindBy(name = "fullName")
    WebElement fullName;

    @CacheLookup
    @FindBy(name = "username")
    WebElement userName;

    @CacheLookup
    @FindBy(name = "password")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/div/div/div[1]/div/div/div/div[1]/section/main/div/div/div[1]/div[2]/form/div[7]/div")
    WebElement signUpButton;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String redirectOnToTheSignUpScreen() throws InterruptedException {
        signUpLink.click();
        Thread.sleep(100);
        String pageTitle = driver.getTitle();
        return pageTitle;
    }

    public boolean enterDataInToTheRegistration() {
        signUpLink.click();
        email.sendKeys("mohiteekta31@gmail.com");
        fullName.sendKeys("Ekta Mohite");
        userName.sendKeys("ekktaa_1");
        password.sendKeys("Forgot@Ek");
        boolean flag = signUpButton.isEnabled();
        return flag;
    }
}


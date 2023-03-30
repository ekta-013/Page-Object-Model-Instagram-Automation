package com.bridgelabz.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {
    WebDriver driver;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[1]/div/div/div/div[1]/div[1]/div[1]/div/div/div/div/div[3]/div/div/a/div/div[2]/div/div")
    WebElement moreOption;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[1]/div/div/div/div[1]/div[1]/div[1]/div/div/div/div/div[3]/div/div/div[1]/div/div[1]/div[7]/div/div/div/div/div/div")
    WebElement logoutButton;

    public Logout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void logoutFromInstagram() throws InterruptedException {
        moreOption.click();
        Thread.sleep(500);
        logoutButton.click();
        Thread.sleep(500);
    }
}

package com.bridgelabz.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    @FindBy(linkText = "Search")
    WebElement search;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[1]/div/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div/div/div[2]/div[1]/div/input")
    WebElement searchbar;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[1]/div/div/div/div[1]/div[1]/div[2]/section/main/div/header/section/div[1]/div[2]/div/div[1]/button")
    WebElement followButton;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[1]/div/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div/div/div[2]/div[2]/div/div[1]/a/div/div/div/div[2]/div/div/div[2]/span")
    WebElement searchoption;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchAndFollowFunction() throws InterruptedException {
        search.click();
        Thread.sleep(1000);
        searchbar.sendKeys("katrina");
        Thread.sleep(1000);
        searchoption.click();
        Thread.sleep(10000);
        followButton.click();
        Actions action = new Actions(driver);
        action.scrollByAmount(0, 600).perform();

    }
}

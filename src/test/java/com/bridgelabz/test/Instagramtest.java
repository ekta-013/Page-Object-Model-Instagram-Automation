package com.bridgelabz.test;

import com.bridgelabz.baseclass.BaseClass;
import com.bridgelabz.baseclass.TestNgListener;
import com.bridgelabz.page.*;
import com.bridgelabz.utility.DataProvider;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.*;
import java.awt.*;


@Listeners(TestNgListener.class)
public class Instagramtest extends BaseClass {

    RegistrationPage registration;
    LoginPage login;
    HomePage home;
    ExplorePage explore;
    Logout logout;

    @BeforeMethod
    public void initialization() {
        setUp();
        registration = new RegistrationPage(driver);
        login = new LoginPage(driver);
        home = new HomePage(driver);
        logout = new Logout(driver);
        explore = new ExplorePage(driver);
    }

    @Test(priority = 0)
    @Epic("Instagram Regression")
    @Severity(value = SeverityLevel.CRITICAL)
    @Step("Redirect to sign up screen")
    public void redirectOnToTheSignUpPage() throws InterruptedException {
        log.debug("signup");
        String title = registration.redirectOnToTheSignUpScreen();
        Assert.assertEquals("Instagram",title);
        log.info("Redirect OnTo The SignUp page");
    }

    @Test(priority = 1)
    @Severity(value = SeverityLevel.CRITICAL)
    @Step("Registration form ")
    public void insertTheDataIntoTheRegistrationField() throws InterruptedException {
        log.debug("insertData");
        registration = new RegistrationPage(driver);
        boolean isEnable = registration.enterDataInToTheRegistration();
        Assert.assertEquals(true,isEnable);
        log.info("inserted data successfully");
        Thread.sleep(3000);
    }

    @Severity(value = SeverityLevel.CRITICAL)
    @Step("Login to instagram")
    @Test(priority = 2, dataProvider = "testLoginData", dataProviderClass = DataProvider.class)
    public void loginInToTheInstagram(String userName, String password) throws InterruptedException, AWTException{
        log.debug("login");
        login.loginInToTheInstagram(userName, password);
        Thread.sleep(3000);
        log.info("login successfully");
        log.debug("search");
        home.searchAndFollowFunction();
        log.info("search, follow  successfully");
        explore.explore();
        log.info("Scroll through explore page");
        logout.logoutFromInstagram();
        log.info("logout Successfully");

    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }
}

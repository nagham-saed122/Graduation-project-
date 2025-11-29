package Tests;

import BaseTest.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTestClass {
    @Test(priority = 0)
    public void verifyLogin() throws InterruptedException {

        loginPage = homePage.clickLoginButton();

        Assert.assertTrue(loginPage.isLoginModalOpened(),
                "Login modal did NOT open!");

        loginPage.setLoginUsername("NaghomAhmedSaed");
        loginPage.setLoginPassword("MySecretPassword!");
        Thread.sleep(2000);
        loginPage.clickLoginButton();
        Thread.sleep(2000);
        String actualWelcomeMsg = loginPage.getWelcomeMessage();

        Assert.assertEquals(
                actualWelcomeMsg,
                "Welcome NaghomAhmedSaed",
                "Welcome message is incorrect!"
        );
    }


    @Test(priority = 3)
    public void verifyCancelLogin() throws InterruptedException {

        loginPage = homePage.clickLoginButton();

        Assert.assertTrue(loginPage.isLoginModalOpened(),
                "Login modal did NOT open!");

        Thread.sleep(2000);

        loginPage.setLoginUsername("SomeUser");
        loginPage.setLoginPassword("SomePassword!");

        loginPage.clickOnCloseButton();

    }

    @Test(priority = 1)
    public void verifyMissingLogin() throws InterruptedException {

        loginPage = homePage.clickLoginButton();

        Assert.assertTrue(loginPage.isLoginModalOpened(),
                "Login modal did NOT open!");

        loginPage.setLoginPassword("SecretPassword!");
        Thread.sleep(2000);
        loginPage.clickLoginButton();
        Thread.sleep(2000);
        String alertMsg = loginPage.getAlertMessage();
        loginPage.acceptAlert();

        Assert.assertEquals(alertMsg, "Please fill out Username and Password.");
    }

    @Test(priority = 2)
    public void verifyLoginWithWrongCredintials() throws InterruptedException {

        loginPage = homePage.clickLoginButton();

        Assert.assertTrue(loginPage.isLoginModalOpened(),
                "Login modal did NOT open!");
        loginPage.setLoginUsername("NaghammmmAhmed");
        loginPage.setLoginPassword("SecretPpppassword!");
        Thread.sleep(2000);
        loginPage.clickLoginButton();
        Thread.sleep(2000);
        String alertMsg = loginPage.getAlertMessage();
        loginPage.acceptAlert();

        Assert.assertEquals(alertMsg, "User does not exist.");
    }


}


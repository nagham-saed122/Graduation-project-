package Tests;

import BaseTest.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpPageTest extends BaseTestClass {

        @Test(priority = 0)
        public void verifySignUp() throws InterruptedException {

            // Open Sign Up modal
            signUpPage = homePage.clickRegisterButton();

            // Check modal is opened
            Assert.assertTrue(signUpPage.isSignUpModalOpened(),
                    "Sign Up modal did NOT open!");

            // Fill username & password
            signUpPage.setUsername("NaghommAhmedSaed");
            signUpPage.setPassword("MySecretPassword!");
            Thread.sleep(2000);
            signUpPage.clickSignUpButton();
            Thread.sleep(2000);
            String alertMsg = signUpPage.getAlertMessage();
            signUpPage.acceptAlert();

            Assert.assertEquals(alertMsg, "Sign up successful.");
        }

//
        @Test(priority = 2)
        public void verifyCancelSignUp() {

            // Open Sign Up modal
            signUpPage = homePage.clickRegisterButton();

            // Check modal is opened
            Assert.assertTrue(signUpPage.isSignUpModalOpened(),
                    "Sign Up modal did NOT open!");

            // Enter data
            signUpPage.setUsername("SomeUser");
            signUpPage.setPassword("SomePassword!");

            // Click the Close button
            signUpPage.clickOnCloseButton();

        }

    @Test(priority = 1)
    public void verifyMissingSignUp() throws InterruptedException {

        // Open Sign Up modal
        signUpPage = homePage.clickRegisterButton();

        // Check modal is opened
        Assert.assertTrue(signUpPage.isSignUpModalOpened(),
                "Sign Up modal did NOT open!");

        // Fill username & password
        signUpPage.setUsername("NaghamAhmed");
        signUpPage.setPassword("SecretPassword!");
        Thread.sleep(2000);
        signUpPage.clickSignUpButton();
        Thread.sleep(2000);
        String alertMsg = signUpPage.getAlertMessage();
        signUpPage.acceptAlert();

        Assert.assertEquals(alertMsg, "This user already exist.");
    }

    @Test(priority = 3)
    public void verifyMissingCredintialsSignUp() throws InterruptedException {

        // Open Sign Up modal
        signUpPage = homePage.clickRegisterButton();

        // Check modal is opened
        Assert.assertTrue(signUpPage.isSignUpModalOpened(),
                "Sign Up modal did NOT open!");

        // Fill username & password
        signUpPage.setPassword("SecretPassword!");
        Thread.sleep(2000);
        signUpPage.clickSignUpButton();
        Thread.sleep(2000);
        String alertMsg = signUpPage.getAlertMessage();
        signUpPage.acceptAlert();

        Assert.assertEquals(alertMsg, "Please fill out Username and Password.");
    }


}


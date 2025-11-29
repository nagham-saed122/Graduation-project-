package Tests;

import BaseTest.BaseTestClass;
import Pages.CartPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTest extends BaseTestClass {

        @Test
        public void purchaseWithoutData_ShouldShowAlert() throws InterruptedException {
            cartPage = homePage.clickCartButton();

            cartPage.clickPlaceOrderButton();
         //   Thread.sleep(2000);

            Assert.assertTrue(cartPage.isPlaceOrderModalOpened(), "Place Order modal should be opened");

            cartPage.clickPurchaseButton();
            Thread.sleep(2000);

            String alertText = cartPage.getAlertMessage();
            Assert.assertTrue(alertText.contains("Please fill out Name and Creditcard."), "Alert should warn about missing data");
            cartPage.acceptAlert();
        }

        @Test
        public void purchaseWithPartialData_ShouldShowAlert() throws InterruptedException {
            CartPage cart = new CartPage(driver);

            cart.clickPlaceOrderButton();
            Thread.sleep(1000);

            cart.setName("Nagham");
            cart.setCountry("Egypt");

            cart.clickPurchaseButton();
            Thread.sleep(500);

            String alertText = cart.getAlertMessage();
            Assert.assertTrue(alertText.contains("Please fill out"), "Alert should warn about missing data");
            cart.acceptAlert();
        }

        @Test
        public void purchaseWithValidData_ShouldSucceed() throws InterruptedException {
            CartPage cart = new CartPage(driver);

            cart.clickPlaceOrderButton();
            Thread.sleep(1000);

            cart.setName("Nagham");
            cart.setCountry("Egypt");
            cart.setCity("Cairo");
            cart.setCreditCard("1234567890123456");
            cart.setMonth("12");
            cart.setYear("2025");

            cart.clickPurchaseButton();
            Thread.sleep(1000);

            String alertText = cart.getAlertMessage();
            Assert.assertTrue(alertText.contains("Thank you"), "Purchase should be successful");
            cart.acceptAlert();
        }

        @Test
        public void closePlaceOrderModal_ShouldCloseModal() throws InterruptedException {
            CartPage cart = new CartPage(driver);

            cart.clickPlaceOrderButton();
            Thread.sleep(1000);

            Assert.assertTrue(cart.isPlaceOrderModalOpened(), "Modal should be opened");

            cart.clickCloseButton();
            Thread.sleep(500);

            Assert.assertTrue(driver.findElements(By.className("modal-content")).isEmpty(), "Modal should be closed");
        }
    }



package Tests;

import BaseTest.BaseTestClass;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTest extends BaseTestClass {

        @Test
        public void verifyNavbarElementsAreDisplayed() {
            home = homePage.clickHomeButton();
            Assert.assertTrue(home.isLogoDisplayed(), "Logo should be displayed");
        Assert.assertTrue(home.isHomeLinkDisplayed(), "Home link should be displayed");
        Assert.assertTrue(home.isContactDisplayed(), "Contact link should be displayed");
        Assert.assertTrue(home.isAboutUsDisplayed(), "About Us link should be displayed");
        Assert.assertTrue(home.isCartDisplayed(), "Cart link should be displayed");
        Assert.assertTrue(home.isLoginDisplayed(), "Login link should be displayed");
        Assert.assertTrue(home.isSignUpDisplayed(), "Sign Up link should be displayed");
    }

    @Test
    public void verifyAllProductsDisplayed() {
        home = homePage.clickHomeButton();

        List<WebElement> products = home.getAllProducts();
        Assert.assertFalse(products.isEmpty(), "Products list should not be empty");

        for (WebElement product : products) {
            Assert.assertTrue(home.getProductImage(product).isDisplayed(), "Product image must be displayed");
            Assert.assertTrue(home.getProductName(product).isDisplayed(), "Product name must be displayed");
            Assert.assertTrue(home.getProductPrice(product).isDisplayed(), "Product price must be displayed");
        }
    }


    @Test
    public void verifyCategoriesAreClickable() {

        home = homePage.clickHomeButton();

        Assert.assertTrue(home.isProductListDisplayed(),
                "Product list should be displayed before testing categories");

        WebElement phone = home.getPhonesCategory();
        Assert.assertTrue(phone.isDisplayed(), "Phones category should be clickable");

        WebElement laptops = home.getLaptopsCategory();
        Assert.assertTrue(laptops.isDisplayed(), "Laptops category should be clickable");

        WebElement monitors = home.getMonitorsCategory();
        Assert.assertTrue(monitors.isDisplayed(), "Monitors category should be clickable");
    }


    @Test
    public void verifyHomePageTitle() {
        home = homePage.clickHomeButton();
        String title = home.getHomePageTitle();
        Assert.assertEquals(title, "STORE", "Homepage title should be 'STORE'");
    }

    @Test
    public void verifyNextAndPreviousButtons() throws InterruptedException {
        home = homePage.clickHomeButton();
        home.clickNextButton();
        Thread.sleep(2000);
        home.clickPreviousButton();
        Thread.sleep(2000);
        List<WebElement> products = home.getAllProducts();
        Assert.assertFalse(products.isEmpty(), "Products list should not be empty after clicking Previous");
        for (WebElement product : products) {
            Assert.assertTrue(home.getProductImage(product).isDisplayed(), "Product image must be displayed");
            Assert.assertTrue(home.getProductName(product).isDisplayed(), "Product name must be displayed");
            Assert.assertTrue(home.getProductPrice(product).isDisplayed(), "Product price must be displayed");
        }
    }




}



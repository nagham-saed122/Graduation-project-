package Tests;

import BaseTest.BaseTestClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class CartPageTest extends BaseTestClass {

    // Helper method to ensure a product is in the cart
    private void addProductToCart(String productName) {
        homePage.clickHomeButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(productName))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add to cart"))).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        homePage.clickHomeButton();
    }

    @Test(priority = 1)
    public void verifyCartProductsAndTotal() {
        addProductToCart("Samsung galaxy s6");
        cartPage = homePage.clickCartButton();
        List<String> products = cartPage.getProductTitles();
        Assert.assertFalse(products.isEmpty(), "Cart should not be empty");
        Assert.assertTrue(products.contains("Samsung galaxy s6"), "Added product should be in the cart");
        String total = cartPage.getTotalPrice();
        System.out.println("Total Price displayed: " + total);
        Assert.assertNotNull(total, "Total price should be displayed");
        Assert.assertFalse(total.isEmpty(), "Total price should not be empty");
    }

    @Test(priority = 2)
    public void deleteProductFromCart() throws InterruptedException {
        addProductToCart("Nokia lumia 1520");
        cartPage = homePage.clickCartButton();
        String productToDelete = "Nokia lumia 1520";
        cartPage.waitForProductInCart(productToDelete);
        List<String> initialProducts = cartPage.getProductTitles();
        Assert.assertTrue(initialProducts.contains(productToDelete), "Product to delete should be present initially");
        cartPage.deleteProduct(productToDelete);
        List<String> updatedProducts = cartPage.getProductTitles();
        Assert.assertFalse(updatedProducts.contains(productToDelete),
                "Product should be removed from cart after deletion");
    }

    @Test(priority = 3)
    public void purchaseWithValidData_ShouldSucceed() {
        addProductToCart("Samsung galaxy s6");
        cartPage = homePage.clickCartButton();
        cartPage.clickPlaceOrderButton();
        cartPage.setName("Nagham");
        cartPage.setCountry("Egypt");
        cartPage.setCity("Cairo");
        cartPage.setCreditCard("1234567890123456");
        cartPage.setMonth("12");
        cartPage.setYear("2025");
        cartPage.clickPurchaseButton();

        // Handle SweetAlert success message
        String successText = cartPage.getSuccessMessageText();
        Assert.assertTrue(successText.contains("Thank you for your purchase!"), "Purchase should be successful");
        cartPage.clickSuccessOKButton();
    }

    @Test(priority = 4)
    public void purchaseWithoutData_ShouldShowAlert() {
        cartPage = homePage.clickCartButton();
        cartPage.clickPlaceOrderButton();
        cartPage.clickPurchaseButton();
        String alertText = cartPage.getAlertMessage();
        Assert.assertTrue(alertText.contains("Please fill out Name and Creditcard"),
                "Alert should warn about missing data");
        cartPage.acceptAlert();
    }
}
package StepDefinitions;

import Pages.CartPage;
import Pages.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class CartSteps {

    WebDriver driver;
    HomePage homePage;
    CartPage cartPage;

    private void ensureDriver() {
        if (driver == null) {
            driver = Hooks.driver;
            homePage = new HomePage(driver);
        }
    }

    @When("I add {string} to the cart")
    public void i_add_to_the_cart(String productName) {
        ensureDriver();
        homePage.clickHomeButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(productName))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add to cart"))).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        homePage.clickHomeButton();
    }

    @And("I go to the Cart page")
    public void i_go_to_the_cart_page() {
        ensureDriver();
        cartPage = homePage.clickCartButton();
    }

    @Then("the cart should not be empty")
    public void the_cart_should_not_be_empty() {
        List<String> products = cartPage.getProductTitles();
        Assert.assertFalse(products.isEmpty(), "Cart should not be empty");
    }

    @And("the cart should contain {string}")
    public void the_cart_should_contain(String productName) {
        cartPage.waitForProductInCart(productName);
        List<String> products = cartPage.getProductTitles();
        Assert.assertTrue(products.contains(productName), "Added product should be in the cart");
    }

    @And("the total price should be displayed")
    public void the_total_price_should_be_displayed() {
        String total = cartPage.getTotalPrice();
        Assert.assertNotNull(total, "Total price should be displayed");
        Assert.assertFalse(total.isEmpty(), "Total price should not be empty");
    }

    @And("I delete {string} from the cart")
    public void i_delete_from_the_cart(String productName) {
        cartPage.deleteProduct(productName);
    }

    @Then("the cart should not contain {string}")
    public void the_cart_should_not_contain(String productName) {
        List<String> products = cartPage.getProductTitles();
        Assert.assertFalse(products.contains(productName), "Product should be removed from cart");
    }

    @And("I place an order with the following details:")
    public void i_place_an_order_with_the_following_details(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        cartPage.clickPlaceOrderButton();
        cartPage.setName(data.get("Name"));
        cartPage.setCountry(data.get("Country"));
        cartPage.setCity(data.get("City"));
        cartPage.setCreditCard(data.get("CreditCard"));
        cartPage.setMonth(data.get("Month"));
        cartPage.setYear(data.get("Year"));
        cartPage.clickPurchaseButton();
    }

    @Then("I should see the success message {string}")
    public void i_should_see_the_success_message(String expectedMessage) {
        String successText = cartPage.getSuccessMessageText();
        Assert.assertTrue(successText.contains(expectedMessage), "Purchase should be successful");
        cartPage.clickSuccessOKButton();
    }

    @And("I click Place Order")
    public void i_click_place_order() {
        cartPage.clickPlaceOrderButton();
    }

    @And("I click Purchase without filling details")
    public void i_click_purchase_without_filling_details() {
        cartPage.clickPurchaseButton();
    }

    @Then("I should see an alert saying {string}")
    public void i_should_see_an_alert_saying(String expectedAlert) {
        String alertText = cartPage.getAlertMessage();
        Assert.assertTrue(alertText.contains(expectedAlert), "Alert should warn about missing data");
        cartPage.acceptAlert();
    }
}

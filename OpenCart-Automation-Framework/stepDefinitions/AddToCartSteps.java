package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class AddToCartSteps {
    WebDriver driver;

    @Given("I am on the OpenCart homepage")
    public void openHomePage() {
        driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");
    }

    @When("I select a product and click \"Add to Cart\"")
    public void addProductToCart() {
        driver.findElement(By.cssSelector(".product-layout:first-child button[aria-label='Add to Cart']")).click();
    }

    @Then("the item should appear in my shopping cart")
    public void verifyItemInCart() {
        driver.findElement(By.id("cart")).click();
        boolean itemVisible = driver.findElement(By.cssSelector(".dropdown-menu .text-start a")).isDisplayed();
        assert itemVisible;
        driver.quit();
    }
}

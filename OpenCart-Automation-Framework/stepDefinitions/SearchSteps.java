package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class SearchSteps {
    WebDriver driver;

    @Given("I am on the OpenCart homepage")
    public void openHomePage() {
        driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");
    }

    @When("I search for {string}")
    public void searchForProduct(String productName) {
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys(productName);
        driver.findElement(By.cssSelector("button.btn.btn-light.btn-lg")).click();
    }

    @Then("search results related to {string} should appear")
    public void verifySearchResults(String productName) {
        boolean isDisplayed = driver.findElement(By.linkText("MacBook")).isDisplayed();
        assert isDisplayed;
        driver.quit();
    }
}

package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class LoginSteps {
    WebDriver driver;

    @Given("I open the OpenCart login page")
    public void openLoginPage() {
        driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/index.php?route=account/login");
    }

    @When("I enter a valid email and password")
    public void enterCredentials() {
        driver.findElement(By.id("input-email")).sendKeys("test@example.com");
        driver.findElement(By.id("input-password")).sendKeys("password123");
    }

    @When("I click on the Login button")
    public void clickLoginButton() {
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
    }

    @Then("I should see my account dashboard")
    public void verifyDashboard() {
        boolean isDisplayed = driver.findElement(By.linkText("Logout")).isDisplayed();
        assert isDisplayed;
        driver.quit();
    }
}

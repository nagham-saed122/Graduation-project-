package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class RegisterSteps {
    WebDriver driver;

    @Given("I open the OpenCart registration page")
    public void openRegisterPage() {
        driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/index.php?route=account/register");
    }

    @When("I fill in all required user information")
    public void fillUserDetails() {
        driver.findElement(By.id("input-firstname")).sendKeys("John");
        driver.findElement(By.id("input-lastname")).sendKeys("Doe");
        driver.findElement(By.id("input-email")).sendKeys("john.doe" + System.currentTimeMillis() + "@example.com");
        driver.findElement(By.id("input-password")).sendKeys("test12345");
        driver.findElement(By.name("agree")).click();
    }

    @When("I submit the registration form")
    public void submitForm() {
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
    }

    @Then("I should see a success message confirming registration")
    public void verifySuccess() {
        boolean success = driver.findElement(By.cssSelector("#content h1")).getText().contains("Your Account Has Been Created");
        assert success;
        driver.quit();
    }
}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
//
    By SignUpBTNLocator = By.id("signin2");
    By LoginBTNLocator = By.id("login2");
    By HomeBTNLocator = By.className("nav-link");
    By CartBTNLocator = By.id("cartur");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public SignUpPage clickRegisterButton() {
        driver.findElement(SignUpBTNLocator).click();
        return new SignUpPage(driver);
    }

    public LoginPage clickLoginButton() {
        driver.findElement(LoginBTNLocator).click();
        return new LoginPage(driver);
    }

    public Home clickHomeButton() {
        driver.findElement(HomeBTNLocator).click();
        return new Home(driver);
    }

    public CartPage clickCartButton() {
        driver.findElement(CartBTNLocator).click();
        return new CartPage(driver);
    }
}

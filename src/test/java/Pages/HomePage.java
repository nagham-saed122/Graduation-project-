package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By SignUpBTNLocator = By.id("signin2");
    By LoginBTNLocator = By.id("login2");
    By HomeBTNLocator = By.xpath("//a[contains(@class, 'nav-link') and @href='index.html']"); // More specific for Home
    By CartBTNLocator = By.id("cartur");
    By ContactBTNLocator = By.linkText("Contact");
    By AboutUsBTNLocator = By.linkText("About us");
    By LogoutBTNLocator = By.id("logout2");
    By WelcomeUserLocator = By.id("nameofuser");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public SignUpPage clickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SignUpBTNLocator)).click();
        return new SignUpPage(driver);
    }

    public LoginPage clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LoginBTNLocator)).click();
        return new LoginPage(driver);
    }

    public Home clickHomeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(HomeBTNLocator)).click();
        return new Home(driver);
    }

    public CartPage clickCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CartBTNLocator)).click();
        return new CartPage(driver);
    }

    public void clickContactButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ContactBTNLocator)).click();
        // Contact opens a modal, logic to handle it could be added here or in a
        // ContactModal class
    }

    public void clickAboutUsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AboutUsBTNLocator)).click();
        // About Us opens a modal
    }

    public void clickLogoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LogoutBTNLocator)).click();
    }

    public boolean isWelcomeMessageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(WelcomeUserLocator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getWelcomeMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(WelcomeUserLocator)).getText();
    }
}

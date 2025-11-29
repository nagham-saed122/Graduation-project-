package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Home {
    WebDriver driver;

    public Home(WebDriver driver) {
        this.driver = driver;
        wait  = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

     By logo = By.className("navbar-brand");
     By homeLink = By.className("nav-link");
     By contactLink = By.linkText("Contact");
     By aboutUsLink = By.linkText("About us");
     By cartLink = By.id("cartur");
     By loginLink = By.id("login2");
     By signUpLink = By.id("signin2");
     By productCards = By.className("col-lg-3");
     By phoneCategory = By.id("itemc");
     By laptopCategory = By.id("itemc");
     By monitorCategory = By.id("itemc");
     By nextButtonLocator = By.id("next2");
     By previousButtonLocator = By.id("prev2");
    WebDriverWait wait;


    public boolean isLogoDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logo)).isDisplayed();
    }

    public boolean isHomeLinkDisplayed() {
        return driver.findElement(homeLink).isDisplayed();
    }

    public boolean isContactDisplayed() {
        return driver.findElement(contactLink).isDisplayed();
    }

    public boolean isAboutUsDisplayed() {
        return driver.findElement(aboutUsLink).isDisplayed();
    }

    public boolean isCartDisplayed() {
        return driver.findElement(cartLink).isDisplayed();
    }

    public boolean isLoginDisplayed() {
        return driver.findElement(loginLink).isDisplayed();
    }

    public boolean isSignUpDisplayed() {
        return driver.findElement(signUpLink).isDisplayed();
    }

    public String getHomePageTitle() {
        return driver.getTitle();
    }

    public boolean isProductListDisplayed() {
        return !getAllProducts().isEmpty();
    }

    public List<WebElement> getAllProducts() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("card")));
        return driver.findElements(By.className("card"));
    }

    public WebElement getProductImage(WebElement productCard) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(productCard.findElement(By.className("card-img-top"))));
    }

    public WebElement getProductName(WebElement productCard) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(productCard.findElement(By.className("card-title"))));
    }

    public WebElement getProductPrice(WebElement productCard) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(productCard.findElement(By.tagName("h5"))));
    }

    public WebElement getPhonesCategory() {
        return wait.until(ExpectedConditions.elementToBeClickable(phoneCategory));
    }

    public WebElement getLaptopsCategory() {
        return wait.until(ExpectedConditions.elementToBeClickable(laptopCategory));
    }

    public WebElement getMonitorsCategory() {
        return wait.until(ExpectedConditions.elementToBeClickable(monitorCategory));
    }
    public void clickNextButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(nextButtonLocator));
        nextBtn.click();
    }

    public void clickPreviousButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement prevBtn = wait.until(ExpectedConditions.elementToBeClickable(previousButtonLocator));
        prevBtn.click();
    }

}



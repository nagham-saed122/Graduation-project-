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
    WebDriverWait wait;

    public Home(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Navbar Locators
    By logo = By.className("navbar-brand");
    By homeLink = By.xpath("//a[contains(@class, 'nav-link') and @href='index.html']");
    By contactLink = By.linkText("Contact");
    By aboutUsLink = By.linkText("About us");
    By cartLink = By.id("cartur");
    By loginLink = By.id("login2");
    By signUpLink = By.id("signin2");

    // Category Locators
    By phoneCategory = By.linkText("Phones");
    By laptopCategory = By.linkText("Laptops");
    By monitorCategory = By.linkText("Monitors");

    // Product Locators
    By productCards = By.className("card");
    By nextButtonLocator = By.id("next2");
    By previousButtonLocator = By.id("prev2");

    // Carousel Locators
    By carouselContainer = By.id("carouselExampleIndicators");
    By carouselNextBtn = By.className("carousel-control-next");
    By carouselPrevBtn = By.className("carousel-control-prev");

    // Footer Locators
    By footer = By.id("footc");

    // --- Navbar Methods ---

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

    // --- Category Methods ---

    public void clickPhonesCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(phoneCategory)).click();
    }

    public void clickLaptopsCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(laptopCategory)).click();
    }

    public void clickMonitorsCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(monitorCategory)).click();
    }

    public WebElement getPhonesCategory() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(phoneCategory));
    }

    public WebElement getLaptopsCategory() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(laptopCategory));
    }

    public WebElement getMonitorsCategory() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(monitorCategory));
    }

    // --- Product Methods ---

    public boolean isProductListDisplayed() {
        return !getAllProducts().isEmpty();
    }

    public List<WebElement> getAllProducts() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productCards));
        return driver.findElements(productCards);
    }

    public WebElement getProductImage(WebElement productCard) {
        return wait.until(ExpectedConditions.visibilityOf(productCard.findElement(By.className("card-img-top"))));
    }

    public WebElement getProductName(WebElement productCard) {
        return wait.until(ExpectedConditions.visibilityOf(productCard.findElement(By.className("card-title"))));
    }

    public WebElement getProductPrice(WebElement productCard) {
        return wait.until(ExpectedConditions.visibilityOf(productCard.findElement(By.tagName("h5"))));
    }

    public void clickProduct(String productName) {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(productName))).click();
    }

    // --- Pagination Methods ---

    public void clickNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButtonLocator)).click();
    }

    public void clickPreviousButton() {
        wait.until(ExpectedConditions.elementToBeClickable(previousButtonLocator)).click();
    }

    // --- Carousel Methods ---

    public boolean isCarouselDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(carouselContainer)).isDisplayed();
    }

    public void clickCarouselNext() {
        wait.until(ExpectedConditions.elementToBeClickable(carouselNextBtn)).click();
    }

    public void clickCarouselPrev() {
        wait.until(ExpectedConditions.elementToBeClickable(carouselPrevBtn)).click();
    }

    // --- Footer Methods ---

    public boolean isFooterDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(footer)).isDisplayed();
    }
}

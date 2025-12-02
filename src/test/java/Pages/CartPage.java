package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Locators
    By cartRowsLocator = By.xpath("//tbody[@id='tbodyid']/tr");
    By totalPriceLocator = By.id("totalp");

    By getPlaceOrderBtnLocator = By.className("btn-success");
    By placeOrderModalLocator = By.id("orderModal");
    By nameTextboxLocator = By.id("name");
    By countryTextboxLocator = By.id("country");
    By cityTextboxLocator = By.id("city");
    By creditCardTextboxLocator = By.id("card");
    By monthTextboxLocator = By.id("month");
    By yearTextboxLocator = By.id("year");
    By purchaseButtonLocator = By.xpath("//button[@onclick=\"purchaseOrder()\"]");
    By closeButtonLocator = By.className("btn-secondary");

    // Locators for Success Message (SweetAlert)
    By successMessageTextLocator = By.xpath("//h2[text()='Thank you for your purchase!']");
    By successOKButtonLocator = By.xpath("//button[contains(@class, 'confirm') and text()='OK']");

    // --- Table Interaction Methods ---

    public List<String> getProductTitles() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartRowsLocator));
        List<String> titles = new ArrayList<>();
        List<WebElement> rows = driver.findElements(cartRowsLocator);
        for (WebElement row : rows) {
            titles.add(row.findElement(By.xpath("./td[2]")).getText());
        }
        return titles;
    }

    public List<String> getProductPrices() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartRowsLocator));
        List<String> prices = new ArrayList<>();
        List<WebElement> rows = driver.findElements(cartRowsLocator);
        for (WebElement row : rows) {
            prices.add(row.findElement(By.xpath("./td[3]")).getText());
        }
        return prices;
    }

    public void waitForProductInCart(String productName) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("tbodyid"), productName));
    }

    public void deleteProduct(String productName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartRowsLocator));
        List<WebElement> rows = driver.findElements(cartRowsLocator);
        for (WebElement row : rows) {
            String title = row.findElement(By.xpath("./td[2]")).getText();
            if (title.equals(productName)) {
                WebElement deleteLink = row.findElement(By.xpath("./td[4]/a"));
                deleteLink.click();
                wait.until(ExpectedConditions.stalenessOf(row));
                return;
            }
        }
        throw new RuntimeException("Product " + productName + " not found in cart");
    }

    public String getTotalPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalPriceLocator));
        return driver.findElement(totalPriceLocator).getText();
    }

    // --- Place Order Methods ---

    public void clickPlaceOrderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(getPlaceOrderBtnLocator)).click();
    }

    public boolean isPlaceOrderModalOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrderModalLocator));
        return driver.findElement(placeOrderModalLocator).isDisplayed();
    }

    public void waitForModal() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrderModalLocator));
    }

    public void setName(String name) {
        waitForModal();
        driver.findElement(nameTextboxLocator).clear();
        driver.findElement(nameTextboxLocator).sendKeys(name);
    }

    public void setCountry(String country) {
        waitForModal();
        driver.findElement(countryTextboxLocator).clear();
        driver.findElement(countryTextboxLocator).sendKeys(country);
    }

    public void setCity(String city) {
        waitForModal();
        driver.findElement(cityTextboxLocator).clear();
        driver.findElement(cityTextboxLocator).sendKeys(city);
    }

    public void setCreditCard(String card) {
        waitForModal();
        driver.findElement(creditCardTextboxLocator).clear();
        driver.findElement(creditCardTextboxLocator).sendKeys(card);
    }

    public void setMonth(String month) {
        waitForModal();
        driver.findElement(monthTextboxLocator).clear();
        driver.findElement(monthTextboxLocator).sendKeys(month);
    }

    public void setYear(String year) {
        waitForModal();
        driver.findElement(yearTextboxLocator).clear();
        driver.findElement(yearTextboxLocator).sendKeys(year);
    }

    public void clickPurchaseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(purchaseButtonLocator)).click();
    }

    public void clickCloseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(closeButtonLocator)).click();
    }

    // --- Alert and Success Message Methods ---

    public Alert getAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    public String getAlertMessage() {
        return getAlert().getText();
    }

    public void acceptAlert() {
        getAlert().accept();
    }

    public String getSuccessMessageText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageTextLocator));
        return driver.findElement(successMessageTextLocator).getText();
    }

    public void clickSuccessOKButton() {
        wait.until(ExpectedConditions.elementToBeClickable(successOKButtonLocator)).click();
    }
}
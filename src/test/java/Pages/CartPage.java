package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait  = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

        By getPlaceOrderBtnLocator = By.className("btn-success");
        By placeOrderModalLocator = By.className("modal-content");
        By nameTextboxLocator = By.id("name");
        By countryTextboxLocator = By.id("country");
        By cityTextboxLocator = By.id("city");
        By creditCardTextboxLocator = By.id("card");
        By monthTextboxLocator = By.id("month");
        By yearTextboxLocator = By.id("year");
        By purchaseButtonLocator = By.xpath("//button[@onclick=\"purchaseOrder()\"]");
        By closeButtonLocator = By.className("btn-secondary");
        WebDriverWait wait;


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

        public Alert getAlert() {
            return driver.switchTo().alert();
        }

        public String getAlertMessage() {
            return getAlert().getText();
        }

        public void acceptAlert() {
            getAlert().accept();
        }
    }


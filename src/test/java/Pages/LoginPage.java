package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait  = new WebDriverWait(driver, Duration.ofSeconds(20));

    }
    By loginInModalLocator = By.id("logInModal");
    By LoginuserNameTextboxLocator = By.id("loginusername");
    By LoginpasswordTextboxLocator = By.id("loginpassword");
    By LoginButtonLocator = By.xpath("//button[@onclick=\"logIn()\"]");
    By closeButtonLocator = By.xpath("//button[@class=\"btn btn-secondary\"]");
    By welcomeMsg = By.id("nameofuser");
    WebDriverWait wait;



    public boolean isLoginModalOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginInModalLocator));
        return driver.findElement(loginInModalLocator).isDisplayed();
    }

    public void waitForModal(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginButtonLocator));
    }

    public void setLoginUsername(String userName){
        waitForModal();
        wait.until(ExpectedConditions.elementToBeClickable(LoginuserNameTextboxLocator)).sendKeys(userName);
    }

    public void setLoginPassword(String password){
        waitForModal();
        wait.until(ExpectedConditions.elementToBeClickable(LoginpasswordTextboxLocator)).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(LoginButtonLocator).click();
    }


    public String clickOnCloseButton(){
        return driver.findElement(closeButtonLocator).getText();
    }

    public Alert getAlert(){
        return driver.switchTo().alert();
    }

    public String getAlertMessage(){
        return getAlert().getText();
    }

    public void acceptAlert(){
        getAlert().accept();
    }

    public String getWelcomeMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMsg)).getText();
    }

}



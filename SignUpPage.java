package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        wait  = new WebDriverWait(driver, Duration.ofSeconds(20));

    }
    By signInModalLocator = By.id("signInModal");
    By userNameTextboxLocator = By.id("sign-username");
    By passwordTextboxLocator = By.id("sign-password");
    By SignUpButtonLocator = By.xpath("//button[@onclick=\"register()\"]");
    By closeButtonLocator = By.className("btn-secondary");
    WebDriverWait wait;



    public boolean isSignUpModalOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInModalLocator));
        return driver.findElement(signInModalLocator).isDisplayed();
    }

    public void waitForModal(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInModalLocator));
    }

    public void setUsername(String userName){
        waitForModal();
        wait.until(ExpectedConditions.elementToBeClickable(userNameTextboxLocator)).sendKeys(userName);
    }

    public void setPassword(String password){
        waitForModal();
        wait.until(ExpectedConditions.elementToBeClickable(passwordTextboxLocator)).sendKeys(password);
    }

    public void clickSignUpButton(){
        driver.findElement(SignUpButtonLocator).click();
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

}

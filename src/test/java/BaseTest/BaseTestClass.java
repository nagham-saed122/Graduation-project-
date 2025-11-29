package BaseTest;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTestClass {

        protected WebDriver driver;
        protected HomePage homePage;
        protected SignUpPage signUpPage;
        protected LoginPage loginPage;
        protected Home home;
        protected CartPage cartPage;
        protected WebDriverWait wait;

        @BeforeClass
        public void setUp(){
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().window().maximize();
            homePage = new HomePage(driver);
        }

        @BeforeMethod
        public void goToHomePage(){
            driver.get("https://demoblaze.com/");
        }

        @AfterClass
        public void tearDown(){
            driver.quit();
        }

    }



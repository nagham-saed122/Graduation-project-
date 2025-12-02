package StepDefinitions;

import Pages.Home;
import Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class HomeSteps {

    WebDriver driver;
    HomePage homePage;
    Home home;

    @Given("I am on the Demoblaze home page")
    public void i_am_on_the_demoblaze_home_page() {
        this.driver = Hooks.driver;
        homePage = new HomePage(driver);
        driver.get("https://demoblaze.com/");
        home = homePage.clickHomeButton();
    }
//
    @Then("the Logo should be displayed")
    public void the_logo_should_be_displayed() {
        Assert.assertTrue(home.isLogoDisplayed(), "Logo should be displayed");
    }

    @And("the Home link should be displayed")
    public void the_home_link_should_be_displayed() {
        Assert.assertTrue(home.isHomeLinkDisplayed(), "Home link should be displayed");
    }

    @And("the Contact link should be displayed")
    public void the_contact_link_should_be_displayed() {
        Assert.assertTrue(home.isContactDisplayed(), "Contact link should be displayed");
    }

    @And("the About Us link should be displayed")
    public void the_about_us_link_should_be_displayed() {
        Assert.assertTrue(home.isAboutUsDisplayed(), "About Us link should be displayed");
    }

    @And("the Cart link should be displayed")
    public void the_cart_link_should_be_displayed() {
        Assert.assertTrue(home.isCartDisplayed(), "Cart link should be displayed");
    }

    @And("the Login link should be displayed")
    public void the_login_link_should_be_displayed() {
        Assert.assertTrue(home.isLoginDisplayed(), "Login link should be displayed");
    }

    @And("the Sign Up link should be displayed")
    public void the_sign_up_link_should_be_displayed() {
        Assert.assertTrue(home.isSignUpDisplayed(), "Sign Up link should be displayed");
    }

    @Then("the products list should not be empty")
    public void the_products_list_should_not_be_empty() {
        List<WebElement> products = home.getAllProducts();
        Assert.assertFalse(products.isEmpty(), "Products list should not be empty");
    }

    @And("each product should have an image, name, and price displayed")
    public void each_product_should_have_an_image_name_and_price_displayed() {
        List<WebElement> products = home.getAllProducts();
        for (WebElement product : products) {
            Assert.assertTrue(home.getProductImage(product).isDisplayed(), "Product image must be displayed");
            Assert.assertTrue(home.getProductName(product).isDisplayed(), "Product name must be displayed");
            Assert.assertTrue(home.getProductPrice(product).isDisplayed(), "Product price must be displayed");
        }
    }

    @Then("the Product list should be displayed")
    public void the_product_list_should_be_displayed() {
        Assert.assertTrue(home.isProductListDisplayed(), "Product list should be displayed");
    }

    @When("I check the categories")
    public void i_check_the_categories() {
        // Placeholder for category check interaction if needed
    }

    @Then("the Phones category should be clickable")
    public void the_phones_category_should_be_clickable() {
        Assert.assertTrue(home.getPhonesCategory().isDisplayed(), "Phones category should be clickable");
    }

    @And("the Laptops category should be clickable")
    public void the_laptops_category_should_be_clickable() {
        Assert.assertTrue(home.getLaptopsCategory().isDisplayed(), "Laptops category should be clickable");
    }

    @And("the Monitors category should be clickable")
    public void the_monitors_category_should_be_clickable() {
        Assert.assertTrue(home.getMonitorsCategory().isDisplayed(), "Monitors category should be clickable");
    }

    @Then("the Home page title should be {string}")
    public void the_home_page_title_should_be(String expectedTitle) {
        String title = home.getHomePageTitle();
        Assert.assertEquals(title, expectedTitle, "Homepage title should be 'STORE'");
    }

    @When("I click the Next button")
    public void i_click_the_next_button() {
        home.clickNextButton();
    }

    @And("I wait for {int} seconds")
    public void i_wait_for_seconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000L);
    }

    @And("I click the Previous button")
    public void i_click_the_previous_button() {
        home.clickPreviousButton();
    }
}

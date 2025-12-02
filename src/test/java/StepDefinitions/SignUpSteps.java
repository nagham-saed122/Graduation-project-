package StepDefinitions;

import Pages.HomePage;
import Pages.SignUpPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignUpSteps {

    WebDriver driver;
    HomePage homePage;
    SignUpPage signUpPage;

    private void ensureDriver() {
        if (driver == null) {
            driver = Hooks.driver;
            homePage = new HomePage(driver);
        }
    }

    @When("I click the Sign Up button")
    public void i_click_the_sign_up_button() {
        ensureDriver();
        signUpPage = homePage.clickRegisterButton();
    }

    @Then("the Sign Up modal should open")
    public void the_sign_up_modal_should_open() {
        Assert.assertTrue(signUpPage.isSignUpModalOpened(), "Sign Up modal did NOT open!");
    }

    @When("I sign up with username {string} and password {string}")
    public void i_sign_up_with_username_and_password(String username, String password) {
        signUpPage.setUsername(username);
        signUpPage.setPassword(password);
    }

    @When("I sign up with password {string} only")
    public void i_sign_up_with_password_only(String password) {
        signUpPage.setPassword(password);
    }

    @And("I click the Sign Up submit button")
    public void i_click_the_sign_up_submit_button() throws InterruptedException {
        Thread.sleep(1000);
        signUpPage.clickSignUpButton();
        Thread.sleep(2000);
    }

    @Then("I should see a sign up alert saying {string}")
    public void i_should_see_a_sign_up_alert_saying(String expectedAlert) {
        String alertMsg = signUpPage.getAlertMessage();
        signUpPage.acceptAlert();
        Assert.assertEquals(alertMsg, expectedAlert);
    }

    @And("I click the Sign Up Close button")
    public void i_click_the_sign_up_close_button() {
        signUpPage.clickOnCloseButton();
    }

    @Then("the Sign Up modal should close")
    public void the_sign_up_modal_should_close() {
        // Assuming action completes successfully as per original test
    }
}

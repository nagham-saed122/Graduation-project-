package DemoblazeStepDefinitions;

import Pages.ContactPage;
import Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ContactSteps {

    WebDriver driver;
    ContactPage contactPage;
    HomePage homePage;

    private void ensureDriver() {
        if (driver == null) {
            driver = HooksPage.Hooks.driver;
            contactPage = new ContactPage(driver);
            homePage = new HomePage(driver);
        }
    }

    @When("I click on the Contact link")
    public void i_click_on_the_contact_link() {
        ensureDriver();
        contactPage.clickContactLink();
        contactPage.waitForModal();
    }

    @And("I enter email {string}")
    public void i_enter_email(String email) {
        contactPage.enterEmail(email);
    }

    @And("I enter name {string}")
    public void i_enter_name(String name) {
        contactPage.enterName(name);
    }

    @And("I enter message {string}")
    public void i_enter_message(String message) {
        contactPage.enterMessage(message);
    }

    @And("I click the Send Message button")
    public void i_click_the_send_message_button() {
        contactPage.clickSendMessage();
    }

    @Then("I should see a contact alert saying {string}")
    public void i_should_see_an_alert_saying(String expectedMessage) {
        String actualMessage = contactPage.getAlertText();
        Assert.assertEquals(actualMessage, expectedMessage, "Alert message mismatch!");
        contactPage.acceptAlert();
    }
}


package stepdefs;

import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginStepDefs {
    WebDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;

    @Given("User is on the login page")
    public void user_on_login_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }

    @When("User enters valid credentials")
    public void user_enters_valid_credentials() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
    }

    @When("User enters invalid credentials")
    public void user_enters_invalid_credentials() {
        loginPage.enterUsername("invalid_user");
        loginPage.enterPassword("wrong_password");
    }

    @And("User clicks login button")
    public void user_clicks_login() throws InterruptedException {
        loginPage.clickLogin();
        Thread.sleep(1000);
    }

    @Then("User should be redirected to inventory page")
    public void user_redirected_to_inventory() {
        Assert.assertTrue(inventoryPage.isOnInventoryPage(), "Should be on inventory page");
    }

    @When("User adds {string} to the cart")
    public void user_adds_product(String product) throws InterruptedException {
        if (product.equalsIgnoreCase("Sauce Labs Backpack")) {
            Thread.sleep(1000);
            inventoryPage.addBackpackToCart();
            Thread.sleep(1000);
        }
    }

    @Then("Cart badge should show {string}")
    public void cart_badge_should_show(String expected) {
        Assert.assertEquals(expected, inventoryPage.getCartBadgeCount());
        driver.quit();
    }

    @Then("An error message should be displayed")
    public void error_message_should_be_displayed() throws InterruptedException {
        Assert.assertTrue(loginPage.isErrorDisplayed(), "Epic sadface: Username and password do not match any user in this service");
        Thread.sleep(1000);
        driver.quit();
    }
}

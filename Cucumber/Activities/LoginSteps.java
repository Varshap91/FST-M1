package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class LoginSteps extends BaseClass{
    @Given("User is on Login page")
    public void openLoginPage() {
        //open login page
        driver.get("https://www.training-support.net/selenium/login-form");
        Assertions.assertEquals("Login Form", driver.getTitle());
    }

    @When("User enters {string} and {string}")
    public void enterData(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @When("User enters \"(.*)\" and \"(.*)\"")
    public void dataEntry(String Usernames, String Passwords) {
        driver.findElement(By.id("username")).sendKeys(Usernames);
        driver.findElement(By.id("password")).sendKeys(Passwords);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("Verify the confirmation message")
    public void verifyLoginMessage() {
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        Assertions.assertEquals("Welcome Back, admin", loginMessage);
    }

    @Then("Read the page title and confirmation message")
    public void getPageTitle() {
        System.out.println("Page Title: " + driver.getTitle());
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        Assertions.assertEquals("Welcome Back, admin", loginMessage);
    }

}

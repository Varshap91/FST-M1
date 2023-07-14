package stepDefinitions;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstTest extends BaseClass {

    @BeforeAll
    public static void setUp() {
        //Geckodriver install
        WebDriverManager.firefoxdriver().setup();
        //suppressing browser logs
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"NULL");
        //Initialize Driver
        driver = new FirefoxDriver();
        //Initialize wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("the user is on the TS page")
    public void openTSHomePage() {
        driver.get("https://www.training-support.net");

       Assertions.assertEquals("Training Support", driver.getTitle());
    }
    @When("the user click on the About Us link")
    public void clickAboutUsLink() {
        //wait till element is clickable
        wait.until(ExpectedConditions.elementToBeClickable(By.id("about-link"))).click();
        //click if button is enabled
//        if (driver.findElement(By.id("about-link")).isEnabled()) {
//            driver.findElement(By.id("about-link")).click();
//        }
    }

    @Then("the user is redirected to About page")
    public void verifyAboutPage() {
        Assertions.assertEquals("About Training Support", driver.getTitle());
    }
}

package TestNGActivities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.time.Duration;

public class Activity9 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Reporter.log("Starting Test |");
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        Reporter.log("Opened Browser |");
        Reporter.log("Page title is " + driver.getTitle() + " |");
    }

    @BeforeMethod
    public void beforeMethod() {
        Reporter.log("Test Case Setup started |");
        driver.switchTo().defaultContent();
    }

    @Test(priority = 0)
    public void simpleAlertTestCase(){
        Reporter.log("simpleAlertTestCase() started |");
        WebElement simple = driver.findElement(By.id("simple"));
        simple.click();
        Reporter.log("Simple Alert opened |");
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Reporter.log("Switched focus to alert |");
        System.out.println("Simple alert text: " + alert.getText());

        Assert.assertEquals("This is a JavaScript Alert!", alert.getText());
        alert.accept();
        Reporter.log("Alert closed");
        Reporter.log("Test case ended |");
    }

    @Test(priority = 1)
    public void confirmAlertTestCase(){
        Reporter.log("confirmAlertTestCase() started |");
        WebElement confirm = driver.findElement(By.id("confirm"));
        confirm.click();
        Reporter.log("Confirm Alert opened |");
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert1 = driver.switchTo().alert();
        Reporter.log("Switched foucs to alert |");
        System.out.println("Confirmation alert text: " + alert1.getText());
        Assert.assertEquals("This is a JavaScript Confirmation!", alert1.getText());
        alert1.dismiss();
        Reporter.log("Alert closed |");
        Reporter.log("Test case ended |");
    }

    @Test
    public void promptAlertTestCase(){
        Reporter.log("promptAlertTestCase() started |");
        WebElement prompt = driver.findElement(By.id("prompt"));
        prompt.click();
        Reporter.log("Prompt Alert opened |");
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert2 = driver.switchTo().alert();
        Reporter.log("Switched focus to alert |");
        System.out.println("Prompt alert text: " + alert2.getText());
        alert2.sendKeys("test");
        Reporter.log("Text entered in prompt alert |");
        Assert.assertEquals("This is a JavaScript Prompt!", alert2.getText());
        alert2.accept();
        Reporter.log("Alert closed |");
        Reporter.log("Test case ended |");
    }

    @AfterTest
    public void tearDown() {
        Reporter.log("Ending Test |");
        driver.close();
    }
}

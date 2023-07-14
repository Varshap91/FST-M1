package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity22 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();

        // Suppressing browser log
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        // Initialize firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Actions builder = new Actions(driver);

        // Open a page
        driver.get("https://www.training-support.net/selenium/popups");

        // Page title
        System.out.println("Title of page is: " + driver.getTitle());

        //Sign in button
        WebElement signIn = driver.findElement(By.cssSelector(".inverted"));
        builder.moveToElement(signIn).build().perform();

        String msg = signIn.getAttribute("data-tooltip");
        System.out.println(msg);
        signIn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

        // Enter the credentials
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));
        WebElement loginMsg = driver.findElement(By.id("action-confirmation"));
        System.out.println("Login Message: " + loginMsg.getText());

        driver.quit();

    }
}

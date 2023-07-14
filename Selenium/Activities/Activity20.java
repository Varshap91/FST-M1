package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity20 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        // Suppressing browser log
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        // Initialize firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Open a page
        driver.get("https://training-support.net/selenium/javascript-alerts");

        // Page title
        System.out.println("Title of page is: " + driver.getTitle());

        driver.findElement(By.id("prompt")).click();
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        // Enter text
        alert.sendKeys("Awesome!");

        // Close the alert
        alert.accept();
        System.out.println("User tapped on OK");

        driver.quit();

    }
}

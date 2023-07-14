package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity19 {
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

        driver.findElement(By.id("confirm")).click();
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        // alert text
        System.out.println("Text in alert: " + alert.getText());

        // Tap on OK
        alert.accept();
        System.out.println("OK button tapped");

        // Tap on Cancel
        driver.findElement(By.id("confirm")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        System.out.println("Cancel button tapped");

        driver.quit();

    }
}

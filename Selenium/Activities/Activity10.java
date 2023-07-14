package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity10 {
    public static void main(String[] args) throws InterruptedException {
        // Installing Firefox driver
        WebDriverManager.firefoxdriver().setup();

        // Suppressing browser log
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        // Initialize firefox driver

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Open a page
        driver.get("https://training-support.net/selenium/dynamic-controls");

        // Print page title
        System.out.println("Page Title is: " + driver.getTitle());

        WebElement inputBox = driver.findElement(By.id("dynamicCheckbox"));
        System.out.println(inputBox.isDisplayed());

        driver.findElement(By.id("toggleCheckbox")).click();

        inputBox = driver.findElement(By.id("dynamicCheckbox"));
        System.out.println(inputBox.isDisplayed());

        driver.quit();

    }
}
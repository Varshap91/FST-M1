package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity12 {
    public static void main(String[] args) throws InterruptedException {

        // Installing Firefox driver
        WebDriverManager.firefoxdriver().setup();

        // Suppressing browser log
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");

        // Initialize firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open a page
        driver.get("https://training-support.net/selenium/dynamic-controls");

        // Print page title
        System.out.println("Page Title is: " + driver.getTitle());

        //check if input field is enabled
        WebElement text = driver.findElement(By.id("input-text"));
        System.out.println(text.isEnabled());

        // Tap on enable input button
        driver.findElement(By.id("toggleInput")).click();

        // check if input field is enabled
        text = driver.findElement(By.id("input-text"));
        System.out.println(text.isEnabled());

        driver.quit();
    }
}

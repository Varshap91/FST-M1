package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity5 {

    public static void main(String[] args) {
        // Installing Firefox driver
        WebDriverManager.firefoxdriver().setup();

        // Suppressing browser log
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        // Initialize firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open a page
        driver.get("https://www.training-support.net/selenium/input-events");

        // Print page title
        System.out.println("Page Title is: " + driver.getTitle());

        WebElement obj = driver.findElement(By.className("active"));

        Actions builder = new Actions(driver);

        // Left click
        builder.click(obj).pause(1000).build().perform();
        obj = driver.findElement(By.className("active"));
        System.out.println("Text: " + obj.getText());

        // Double click
        builder.doubleClick(obj).pause(1000).build().perform();
        obj = driver.findElement(By.className("active"));
        System.out.println("Text: " + obj.getText());

        // Right click
        builder.contextClick(obj).pause(1000).build().perform();
        obj = driver.findElement(By.className("active"));
        System.out.println("Text: " + obj.getText());

        driver.quit();
    }
}

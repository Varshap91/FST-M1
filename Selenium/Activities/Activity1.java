package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity1 {
    public static void main(String[] args) {

        // Installing Firefox driver
        WebDriverManager.firefoxdriver().setup();

        // Suppressing browser log
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        // Initialize firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open a page
        driver.get("https://www.training-support.net");

        System.out.println("Page Title is: " + driver.getTitle());

        WebElement aboutUs = driver.findElement(By.id("about-link"));
        aboutUs.click();
        System.out.println("Next Page Title is: " + driver.getTitle());

        driver.quit();

    }
}

package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity6 {
    public static void main(String[] args) {
        // Installing Firefox driver
        WebDriverManager.firefoxdriver().setup();

        // Suppressing browser log
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        // Initialize firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open a page
        driver.get("https://training-support.net/selenium/input-events");

        // Print page title
        System.out.println("Page Title is: " + driver.getTitle());

        Actions builder = new Actions(driver);

        builder.sendKeys("V").build().perform();
        builder.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();

        driver.quit();
    }
}
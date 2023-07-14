package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity9 {
    public static void main(String[] args) throws InterruptedException {
        // Installing Firefox driver
        WebDriverManager.firefoxdriver().setup();

        // Suppressing browser log
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        // Initialize firefox driver

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Open a page
        driver.get("https://training-support.net/selenium/ajax");

        // Print page title
        System.out.println("Page Title is: " + driver.getTitle());

        driver.findElement(By.cssSelector("button.ui:nth-child(2)")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        WebElement hellomsg = driver.findElement(By.tagName("h1"));
        System.out.println(hellomsg.getText());

        WebElement delayedText = driver.findElement(By.tagName("h3"));
        System.out.println(delayedText.getText());

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"), "I'm late!"));
        hellomsg = driver.findElement(By.tagName("h3"));
        System.out.println(hellomsg.getText());

        driver.quit();

    }
}

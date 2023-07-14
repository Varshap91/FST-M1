package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Activity21 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        // Suppressing browser log
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        // Initialize firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Open a page
        driver.get("https://www.training-support.net/selenium/tab-opener");

        // Page title
        System.out.println("Title of page is: " + driver.getTitle());


        String parentHandle = driver.getWindowHandle();

        driver.findElement(By.id("launcher")).click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> handles = driver.getWindowHandles();

        for(String handle : handles) {
            if (handle != parentHandle) {
                driver.switchTo().window(handle);
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content")));
        System.out.println("New tab title: " + driver.getTitle());
        WebElement header = driver.findElement(By.className("content"));
        System.out.println("New header: " + header.getText());

        driver.findElement(By.id("actionButton")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        handles = driver.getWindowHandles();

        for(String handle : handles) {
                driver.switchTo().window(handle);
            }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content")));
        System.out.println("New tab title: " + driver.getTitle());
        WebElement header1 = driver.findElement(By.className("content"));
        System.out.println("New header: " + header1.getText());

        driver.quit();
    }
}
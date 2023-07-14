package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity15 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        // Suppressing browser log
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        // Initialize firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Open a page
        driver.get("https://training-support.net/selenium/dynamic-attributes");

        //Page title
        System.out.println("Title of page is: " + driver.getTitle());

        // Enter the credentials
        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("password");
        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();

        // Confirm login msg
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));
        WebElement loginMsg = driver.findElement(By.id("action-confirmation"));
        System.out.println("Loin message: " + loginMsg.getText());

        // close the browser
        driver.quit();
    }
}

package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity16 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        // Suppressing browser log
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        // Initialize firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Open a page
        driver.get("https://training-support.net/selenium/dynamic-attributes");

        // Page title
        System.out.println("Title of page is: " + driver.getTitle());

        // Enter details and sign up
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/div/div[1]/input")).sendKeys("Varshap1");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/div/div[2]/input")).sendKeys("12345678");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/div/div[3]/input")).sendKeys("12345678");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("varshap1@text.com");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/div/button")).click();

        // Confirm login msg
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));
        WebElement loginMsg = driver.findElement(By.id("action-confirmation"));
        System.out.println("Loin message: " + loginMsg.getText());

        // close the browser
        driver.quit();
    }
}
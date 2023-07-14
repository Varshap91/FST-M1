package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) {
        // Installing Firefox driver
        WebDriverManager.firefoxdriver().setup();

        // Suppressing browser log
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        // Initialize firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open a page
        driver.get("https://training-support.net/selenium/target-practice");

        // Print page title
        System.out.println("Page Title is: " + driver.getTitle());

        // Get 3rd header text
        WebElement h3 = driver.findElement(By.xpath("//h3[@id='third-header']"));
        System.out.println("3rd header is: " + h3.getText());

        // Get 5th header color
        WebElement h5 = driver.findElement(By.xpath("//h5[@class='ui green header']"));
        System.out.println("5th header color: " + h5.getCssValue("color"));

        // Violet button classes
        WebElement violet = driver.findElement(By.xpath("//button[text()='Violet']"));
        System.out.println("Violet button classes: " + violet.getAttribute("class"));

        //Grey button text
        WebElement grey = driver.findElement(By.xpath("//button[text()='Grey']"));
        System.out.println("Grey button text: " + grey.getText());

        driver.quit();
    }
}

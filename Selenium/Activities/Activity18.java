package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity18 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        // Suppressing browser log
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        // Initialize firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Open a page
        driver.get("https://training-support.net/selenium/selects");

        // Page title
        System.out.println("Title of page is: " + driver.getTitle());


        WebElement dropdown = driver.findElement(By.id("multi-select"));
        Select select = new Select(dropdown);

        // Select the "JavaScript" option
        select.selectByVisibleText("Javascript");
        System.out.println("Text selected: " + select.getFirstSelectedOption().getText());

        // Select the 4th, 5th and 6th options
        select.selectByIndex(5);
        select.selectByIndex(6);
        select.selectByIndex(7);

        // Select the "NodeJS" option
        select.selectByValue("node");
        System.out.println("Text selected: " + select.getFirstSelectedOption().getText());

        // Deselect the 5th option using index.
        select.deselectByIndex(6);

        driver.quit();
    }
}

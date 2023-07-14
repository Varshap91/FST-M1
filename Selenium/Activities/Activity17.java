package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity17 {
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

        WebElement dropdown = driver.findElement(By.id("single-select"));
        Select select = new Select(dropdown);

        // Select the second option using the visible text
        select.selectByVisibleText("Option 2");
        System.out.println("Second option: " + select.getFirstSelectedOption().getText());

        //Select the third option using the index
        select.selectByIndex(3);
        System.out.println("Third option: " + select.getFirstSelectedOption().getText());

        //Select the fourth option using the value
        select.selectByValue("4");
        System.out.println("Fourth option: " + select.getFirstSelectedOption().getText());

        // Get all the options
        List<WebElement> options = select.getOptions();
        for (WebElement opt: options) {
            System.out.println(opt.getText());
        }

        driver.quit();
    }
}

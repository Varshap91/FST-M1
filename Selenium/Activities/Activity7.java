package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Activity7 {
    public static void main(String[] args) throws InterruptedException {
        // Installing Firefox driver
        WebDriverManager.firefoxdriver().setup();

        // Suppressing browser log
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        // Initialize firefox driver
        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);

        // Open a page
        driver.get("https://training-support.net/selenium/drag-drop");
        System.out.println(driver.getTitle());

        //Identify ball and dropzones
        WebElement football = driver.findElement(By.id("draggable"));
        WebElement dragzone1 = driver.findElement(By.id("droppable"));
        WebElement dragzone2 = driver.findElement(By.id("dropzone2"));

        //perform drag and drop
        builder.dragAndDrop(football, dragzone1).build().perform();
        String message = driver.findElement(By.xpath("//div[@id='droppable']/p")).getText();
        System.out.println(message);

        builder.dragAndDrop(football, dragzone2).build().perform();
        message = driver.findElement(By.xpath("//div[@id='dropzone2']/p")).getText();
        System.out.println(message);

        driver.quit();
    }
}

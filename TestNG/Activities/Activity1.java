package TestNGActivities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
    }

    @Test
    public void homepageTest() {
        // Validate the page title
        String title1 = driver.getTitle();
        System.out.println("Page Title: " + title1);
        Assert.assertEquals(title1, "Training Support");

        // Tap on About Us button

        driver.findElement(By.id("about-link")).click();

        String title2 = driver.getTitle();
        System.out.println("Page Title: " + title2);
        Assert.assertEquals(title2, "About Training Support");

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}

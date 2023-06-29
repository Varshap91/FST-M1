package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Activity7 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void driverSetup() {
        // Installing Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Suppressing browser log
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        //Initializing the driver
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //Opening the browser
        driver.get("https://alchemy.hguy.co/jobs");
    }

    @Test
    public void createJobTest() throws InterruptedException {
        driver.findElement(By.id("menu-item-26")).click();
        driver.findElement(By.id("create_account_email")).sendKeys("testjob35@gmail.com");
        driver.findElement(By.id("job_title")).sendKeys("Associate System Engineer");
        driver.findElement(By.id("job_location")).sendKeys("Bangalore");
        driver.findElement(By.id("job_description_ifr")).sendKeys(" Test Job creation");
        driver.findElement(By.id("application")).sendKeys("https://lms.training-support.net");
        driver.findElement(By.id("company_name")).sendKeys("BIM Pvt Ltd");
        driver.findElement(By.id("company_website")).sendKeys("https://alchemy.hguy.co");
        driver.findElement(By.id("company_tagline")).sendKeys("All Problem One Solution");
        driver.findElement(By.id("company_video")).sendKeys("https://www.youtube.com/watch?v=QM2-MX1Lz-A");
        driver.findElement(By.id("company_twitter")).sendKeys("@Twitter");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='Preview']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='Submit Listing']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu-item-24")));
        driver.findElement(By.id("menu-item-24")).click();
        driver.findElement(By.id("search_keywords")).sendKeys("BIM Pvt Ltd");
        driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.className("company_logo")));
        String jobName = driver.findElement(By.className("position")).getText();
        Assert.assertEquals(jobName, "Associate System Engineer\nBIM Pvt Ltd All Problem One Solution");
    }

    @AfterClass
    public void closeBrowser() {
        //Closing the browser
        driver.quit();
    }
}

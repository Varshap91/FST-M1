package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Activity6 {
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
        //Initializing Wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //Opening the browser
        driver.get("https://alchemy.hguy.co/jobs");
    }

    @Test(priority = 0)
    public void searchJobTest() throws InterruptedException {
        driver.findElement(By.id("menu-item-24")).click();
        driver.findElement(By.id("search_keywords")).sendKeys("Banking");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.className("company_logo")));
    }

    @Test(priority = 1)
    public void applyJobTest() throws InterruptedException {
        driver.findElement(By.className("company_logo")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@value='Apply for job']")).click();
        Thread.sleep(2000);
        String jobEmail = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/div/div[3]/div/p/a")).getText();
        System.out.println("Job web or email: " + jobEmail);
    }

    @AfterClass
    public void closeBrowser() {
        //Closing the browser
        driver.quit();
    }
}
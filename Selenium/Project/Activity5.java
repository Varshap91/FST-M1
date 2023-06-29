package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity5 {
    WebDriver driver;

    @BeforeClass
    public void driverSetup() {
        // Installing Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Suppressing browser log
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        //Initializing the driver
        driver = new FirefoxDriver();
        //Opening the browser
        driver.get("https://alchemy.hguy.co/jobs");
    }

    @Test
    public void openJobsTest() {
        //Tap on Jobs button
        driver.findElement(By.id("menu-item-24")).click();

        //Get Page Title
        String jobsTitle = driver.getTitle();
        System.out.println(jobsTitle);

        //Assertion
        Assert.assertEquals("Jobs – Alchemy Jobs", jobsTitle);
    }

    @AfterClass
    public void closeBrowser() {
        //Closing the browser
        driver.quit();
    }
}

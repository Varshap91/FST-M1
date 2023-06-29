package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity2 {
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
    public void validateHeadingTest() {
        //Page Heading
        String heading1 = driver.findElement(By.className("entry-title")).getText();

        //Assertion
        Assert.assertEquals("Welcome to Alchemy Jobs", heading1);
    }

    @AfterClass
    public void closeBrowser() {
        //Closing the browser
        driver.quit();
    }
}


package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Activity8 {
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
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
    }

    @Test
    @Parameters({"username", "password"})
    public void loginTest(String username, String password) {
        //Find username and password fields
        WebElement userid = driver.findElement(By.id("user_login"));
        WebElement pwd = driver.findElement(By.id("user_pass"));

        //Enter values
        userid.sendKeys(username);
        pwd.sendKeys(password);

        //Click Log in
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //Assert Message
        String loginMsg = driver.findElement(By.className("display-name")).getText();
        Assert.assertEquals(loginMsg, "root");
    }
    @AfterClass
    public void closeBrowser() {
        //Closing the browser
        driver.quit();
    }
}

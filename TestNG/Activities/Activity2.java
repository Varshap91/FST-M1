package TestNGActivities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class Activity2 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test(priority = 0)
    public void Test1() {
        // Validate the page title
        String title1 = driver.getTitle();
        System.out.println("Page Title: " + title1);
        Assert.assertEquals(title1, "Target Practice");
    }

    @Test(priority = 3)
    public void Test2() {
        // Validate black button
        WebElement blackBtn = driver.findElement(By.cssSelector(".black"));
        Assert.assertEquals(blackBtn.getText(), "Green");
    }

    @Test(priority = 1, enabled = false)
    public void Test3() {
        String title2 = driver.getTitle();
        System.out.println("Page Title: " + title2);
        Assert.assertEquals(title2, "Target Practice");
    }

    @Test(priority = 2)
    public void Test4() {
        throw new SkipException("Skipping test case");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}

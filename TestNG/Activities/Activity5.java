package TestNGActivities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity5 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass (alwaysRun = true)
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test (alwaysRun = true)
    public void titleTest() {
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);
    }

    @Test (dependsOnMethods = {"titleTest"}, groups = {"HeaderTests"})
    public void thirdHeaderTest() {
        WebElement thirdHeader = driver.findElement(By.tagName("h3"));
        Assert.assertEquals(thirdHeader.getText(), "Third header");
    }

    @Test (dependsOnMethods = {"titleTest"}, groups = {"HeaderTests"})
    public void fifthHeaderTest() {
        WebElement fifthHeader = driver.findElement(By.tagName("h5"));
        Assert.assertEquals(fifthHeader.getCssValue("color"), "rgb(33, 186, 69)");
    }

    @Test (dependsOnMethods = {"titleTest"}, groups = {"ButtonTests"})
    public void oliveButtonTest() {
        WebElement oliveBtn = driver.findElement(By.xpath("//button[text()='Olive']"));
        Assert.assertEquals(oliveBtn.getText(), "Olive");
    }

    @Test (dependsOnMethods = {"titleTest"}, groups = {"ButtonTests"})
    public void brownButtonTest() {
        WebElement browneBtn = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[1]"));
        Assert.assertEquals(browneBtn.getText(), "Brown");
    }

    @AfterClass (alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

    }


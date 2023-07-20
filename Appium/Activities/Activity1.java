package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;

public class Activity1 {
    WebDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setPlatformName("android");
        caps.setAutomationName("UiAutomator2");
        caps.setAppPackage("com.android.calculator2");
        caps.setAppActivity(".Calculator");
        caps.noReset();

        // Appium Server URL
        URL servrURL = new URL("http://localhost:4723/wd/hub");

        // Initialize AndroidDriver
        driver = new AndroidDriver(servrURL, caps);
    }

    @Test
    public void multiplicationTest() throws IOException {
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_2")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String result1 = driver.findElement(By.id("com.android.calculator2:id/result")).getText();
        takeScreenshot(driver);
        assertEquals(result1, "10");
    }

    public static void takeScreenshot(WebDriver driver) throws IOException {
        File tempImg = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("src/test/resources/screenshot.jpg");
        FileUtils.copyFile(tempImg, screenshot);
        String imgPath = "../" + screenshot;
        String imgHtml = "<img src=" + imgPath + " />";
        Reporter.log(imgHtml);
    }

    @AfterClass
    public void closeApp() {
        driver.quit();
    }

}

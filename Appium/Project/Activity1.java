package liveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity1 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options task = new UiAutomator2Options();
        task.setPlatformName("android");
        task.setAutomationName("UiAutomator2");
        task.setAppPackage("com.google.android.apps.tasks");
        task.setAppActivity(".ui.TaskListsActivity");
        task.noReset();

        // Appium Server URL
        URL servrURL = new URL("http://localhost:4723/wd/hub");

        // Initialize AndroidDriver
        driver = new AndroidDriver(servrURL, task);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void addTaskTest() {
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Create new task")));

        WebElement addTask = driver.findElement(AppiumBy.accessibilityId("Create new task"));
        addTask.click();

        WebElement newTask = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='com.google.android.apps.tasks:id/add_task_title']"));
        WebElement save = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Save']"));

        newTask.sendKeys("Complete Activity with Google Tasks");
        save.click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@content-desc='Add star']")));
        addTask.click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@content-desc='Set date/time']")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Keep");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@content-desc='Add star']")));
        addTask.click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Add details")));
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='New task']")).sendKeys("Complete the second Activity Google Keep");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id='com.google.android.apps.tasks:id/add_task_done']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@content-desc='Add star']")));
        List<WebElement> tasks = driver.findElements(AppiumBy.xpath("//android.support.v7.widget.RecyclerView[@resource-id='com.google.android.apps.tasks:id/tasks_list']//android.widget.TextView"));
        Assert.assertEquals(tasks.size(), 3);

    }

    @AfterClass
    public void closeApp() {
        driver.quit();
    }

}

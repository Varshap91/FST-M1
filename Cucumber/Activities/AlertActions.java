package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertActions extends BaseClass {
    @Given("User is on the page")
    public void openPage() {
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
    }

    @When("User clicks the Simple Alert button")
    public void simpleAlert() {
        driver.findElement(By.id("simple")).click();
    }

    @When("User clicks the Confirm Alert button")
    public void confirmAlert() {
        driver.findElement(By.id("confirm")).click();
    }

    @When("User clicks the Prompt Alert button")
    public void promptAlert() {
        driver.findElement(By.id("prompt")).click();
    }

    @Then("Alert opens")
    public void alert() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    @Then("Read the text from it and print it")
    public void alertText() {
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: " + alert.getText());
    }

    @Then("Close the alert")
    public void closeAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Then("Close the alert with Cancel")
    public void cancelAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    @Then("Write a custom {string} in it")
    public void enterMsg(String message) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(message);
    }

    @Then("Read the result text")
    public void result() {

    }


}

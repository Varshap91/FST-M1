package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleSearchSteps extends BaseClass {
    @Given("User is on Google Home Page")
    public void openGooglePage() {
        driver.get("https://www.google.com");
    }

    @When("User types in Cheese and hits ENTER")
    public void searchText() {
        driver.findElement(By.id("APjFqb")).sendKeys("Cheese", Keys.RETURN);
    }

    @Then("Show how many search results were shown")
    public void thenFunctionName() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("result-stats")));
        String resultStats = driver.findElement(By.id("result-stats")).getText();
        System.out.println("Number of results found: " + resultStats);
    }
}

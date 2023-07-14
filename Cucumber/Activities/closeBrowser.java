package stepDefinitions;

import io.cucumber.java.en.Then;

public class closeBrowser extends BaseClass {
    @Then("Close the browser")
    public static void closeBrowser() {
        //close the browser
        driver.quit();
    }

}

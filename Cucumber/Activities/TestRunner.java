package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

//@CucumberOptions(
//        features = "src/test/java/Features",
//        glue = {"stepDefinitions"},
//        tags = "@SimpleAlert",
//        plugin = {"pretty"},
//        monochrome = true
//)
//@CucumberOptions(
//        features = "src/test/java/Features",
//        glue = {"stepDefinitions"},
//        tags = "@SimpleAlert",
//        plugin = {"html: test-reports"},
//        monochrome = true
//)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"stepDefinitions"},
        tags = "@SimpleAlert",
        plugin = {"json: test-reports/json-report.json"},
        monochrome = true
)

//@CucumberOptions(
//        features = "src/test/java/Features",
//        glue = {"stepDefinitions"},
//        tags = "@SmokeTest",
//        plugin = {"html: test-reports"},
//        monochrome = true
//)
//@CucumberOptions(
//        features = "src/test/java/Features",
//        glue = {"stepDefinitions"},
//        tags = "@SmokeTest",
//        plugin = {"pretty"},
//        monochrome = true
//)

//@CucumberOptions(
//        features = "Features",
//        glue = {"stepDefinitions"},
//        tags = "@activity1"
//)

//@CucumberOptions(
//        features = "Features",
//        glue = {"stepDefinitions"},
//        tags = "@activity2"
//)

//@CucumberOptions(
//        features = "Features",
//        glue = {"stepDefinitions"},
//        tags = "@activity3"
//)

//@CucumberOptions(
//        features = "Features",
//        glue = {"stepDefinitions"},
//        tags = "@activity4"
//)

//@CucumberOptions(
//        features = "Features",
//        glue = {"stepDefinitions"},
//        tags = "@activity5"
//)

public class TestRunner {

}

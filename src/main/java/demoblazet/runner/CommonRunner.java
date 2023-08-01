package demoblazet.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {"src/test/resources/FeatureFiles/"}, glue = {
        "demoblazet/stepDefinition"}, monochrome = true,tags = "@Smoke1",dryRun = false, plugin = {"pretty","html:target/cucumber-reports/cucumber-pretty", "json:target/cucumber-reports/CucumberTestReports.json", "rerun:target/cucumber-reports/rerun.txt"
})


public class CommonRunner extends AbstractTestNGCucumberTests {

}

//C:\Users\91937\IdeaProjects\demoblaze\src\main\java\demoblazet\stepDefinition\DemoBlazeStepDefinition.java
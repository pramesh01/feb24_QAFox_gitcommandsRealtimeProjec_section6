package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features="src/test/resources/features/",
		glue= {"stepdef","hooks"},
		//publish=true,
		plugin={"html:target/CucumberReports/cucumberreports.html"}
		)

   public class TestRunner extends AbstractTestNGCucumberTests{
	

     }

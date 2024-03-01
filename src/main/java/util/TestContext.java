package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestContext {
	ExtentReports report;
	ExtentTest test;
	
	public TestContext() {
		report=ExtentManager.generatereports();	
	}
	
	public void createScenario(String scenario) {
		test=report.createTest(scenario);	
	}

	public void endScenario(String scenario) {
		report.flush();
	}
	
	public void log(String message) {
		test.log(Status.INFO, message);
	}
}
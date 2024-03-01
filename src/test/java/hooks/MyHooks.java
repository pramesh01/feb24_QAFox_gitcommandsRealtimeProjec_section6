package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import util.PropertyFileReader;
import util.TestContext;

public class MyHooks {
	
	/*WebDriver driver;
	TestContext context;
	
	public MyHooks(TestContext context) {
		this.context=context;
	}
	
	
	@Before
	public void setup(Scenario sc) {
		Properties prop=PropertyFileReader.initializePropertyfile();
		driver=DriverFactory.initializeBrowser(prop.getProperty("browserName"));
		context.createScenario(sc.getName());
		driver.get(prop.getProperty("url"));
	 }
	
	@After
	public void teardown(Scenario sc) {
		String scr=sc.getName().replace(" ","_");
		if(sc.isFailed()) {
			byte[] scrfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(scrfile, "image/png", scr);
		}
		
		context.endScenario(sc.getName());
		driver.quit();
	 }*/
}

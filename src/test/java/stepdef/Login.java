package stepdef;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.LoginPage;
import util.PropertyFileReader;
import util.TestContext;

public class Login {
	//new added comment
	 WebDriver driver;
	 LoginPage lp;
	 TestContext context;
	 
	 public Login( TestContext context){
		 this.context=context;
		 
	 }
	 
	 @Before
		public void setup(Scenario sc) {
		 context.createScenario(sc.getName());
			Properties prop=PropertyFileReader.initializePropertyfile();
			driver=DriverFactory.initializeBrowser(prop.getProperty("browserName"));
			//context.createScenario(sc.getName());
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
		 }
	
	@Given("goto application login page")
	public void goto_application_login_page() {
	 context.log("navigating to login page.");
	   driver=DriverFactory.getDriver();
	  
	   HomePage hp=new HomePage(driver);
	   lp=hp.navigateToLoginPage();
	  
	 }
	
	@When("^enter valid useremail (.+)$")
	public void enter_valid_useremail(String emailid) {
		context.log("entering the valid email");
		//lp=new LoginPage(driver);
		lp.enterusername(emailid);
	   
	  }
	
	@When("enter invalid useremail {string}")
	public void enter_invalid_useremail(String emailid) {
		context.log("entering invalid eamil id");
		//lp=new LoginPage(driver);
		lp.enterusername("bloggerdelhi123x@gmail.com");
	    
	  }
	
	@And("^enter valid password (.+)$")
	public void enter_valid_password(String password) {
		context.log("entering valid password");
		lp.enterpassword(password);
		//test comment 01 march 2024
	}
	
	@And("enter invalid password {string}")
	public void enter_invalid_password(String password) {
		lp.enterpassword(password);
	}
	
	@When("enter blank useremail")
	public void enter_blank_useremail() {
		//lp=new LoginPage(driver);
		lp.enterblankusername("");
	}
	
	@And("enter blank password")
	public void enter_blank_password() {
		lp.enterblankpassword("");
		
	}

	@And("click on login button")
	public void click_on_login_button() {
	  
		lp.clickLoginButton();
	}

	@Then("user should be logged in to website successfully")
	public void user_should_be_logged_in_to_website_successfully() {
		lp.verify_userLoggedin_Successfully();
	}
	
	@Then("user should be prevented to be logged in to website and proper eroor message be displayed")
	public void user_should_be_prevented_to_be_logged_in_to_website() {
	 lp.verify_userNOTLoggedin();
		
	}
}
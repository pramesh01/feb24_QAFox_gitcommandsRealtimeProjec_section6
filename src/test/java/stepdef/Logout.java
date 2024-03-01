package stepdef;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.AfterLogoutPage;
import pages.UserDashboardPage;
import util.TestContext;


public class Logout {

	 WebDriver driver;
	 UserDashboardPage udp;
	 AfterLogoutPage alp;
	 
TestContext context;
	 
	 public Logout( TestContext context){
		 this.context=context;
	 }
	 
	@Then("click on logOUT link from breadcrumb")
	public void click_on_log_out_link_from_breadcrumb() {
	    driver=DriverFactory.getDriver();
	  
	    udp=new UserDashboardPage(driver);
	    alp=udp.gotoLogoutPage(); 
	   // Assert.fail();-> intentionally failled to check few screen shot attach scenarios on test failure.
	}

	@And("user should be logout from the application successfully")
	public void user_should_be_logout_from_the_application_successfully() {
		alp.verifyLogoutisSuccessfull();
	}
}

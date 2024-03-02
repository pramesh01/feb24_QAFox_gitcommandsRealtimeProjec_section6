package stepdef;


import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.RegisterPage;
import util.TestContext;
import util.TimeStamp;

public class Register {
	
	WebDriver driver;
	HomePage hp;
	RegisterPage rp;
	TestContext context;
	 
	 public Register( TestContext context){
		 this.context=context;
	 }
	
	@Given("goto application registration page")
	public void goto_application_registration_page() {
	   System.out.println("launching application registration page");
	   driver=DriverFactory.getDriver();
	  
	   hp=new HomePage(driver);
	   rp=hp.navigatetoRegisterPage();
	}

	@When("user enters the following details with unique emailid")
	public void user_enters_the_following_details_unique_emailid(DataTable dataTable) {
	   System.out.println("entering the details of mandatoryfields");
	   Map<String,String> dataMap=dataTable.asMap(String.class, String.class);
	   rp.enterfirstname(dataMap.get("firstname"));
	   rp.enterlastname(dataMap.get("lastname"));
	   rp.emailfield(TimeStamp.getElementwithTimestamp());
	   rp.entertelephone(dataMap.get("telephone"));
	   rp.enterpassword(dataMap.get("password"));
	   rp.confirmpassword(dataMap.get("confirmpassword"));
	  
	 }
	
	@When("user enters the following details with duplicate emailid")
	public void user_enters_the_following_details_duplicate_emailid(DataTable dataTable) {
	   System.out.println("entering the details of mandatoryfields");
	   Map<String,String> dataMap=dataTable.asMap(String.class, String.class);
	   rp.enterfirstname(dataMap.get("firstname"));
	   rp.enterlastname(dataMap.get("lastname"));
	   rp.emailfield(dataMap.get("emailid"));
	   rp.entertelephone(dataMap.get("telephone"));
	   rp.enterpassword(dataMap.get("password"));
	   rp.confirmpassword(dataMap.get("confirmpassword"));
	 }

	@When("user select the policy checkbox")
	public void user_select_the_policy_checkbox() {
		rp.selectPrivacypolicy();
	    System.out.println("clicked the privacy checkbox");
	}

	@When("user click on continue button")
	public void user_click_on_continue_button() {
		rp.clickcontinuebuttonforregisteruser();
	 System.out.println("clicked on continue button.");  
	 }

	@Then("user account should be created successfully")
	public void user_account_should_be_created_successfully() {
		rp.verifyifuserisregisteredsuccessfully();
	}
	
	@And("user should get duplicate email warning message")
	public void duplicate_email_warningMessage() {
		rp.verifyifuserisNOTregistered_duetoinvalidorduplicate_emailid();		
	}
	
	@And("user should get proper warning message for privacy selection")
	public void privacy_warningMessage() {
		String expectedwarningmessage="Warning: You must agree to the Privacy Policy!";
		String actualwarningmessage= driver.findElement(By.xpath("//*[@id='account-register']/div[1]")).getText();
		Assert.assertEquals(actualwarningmessage, expectedwarningmessage);
		System.out.println("test passed because got successfull warning message of Policy related Issue.");
	}	
}
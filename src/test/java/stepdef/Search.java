package stepdef;

import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import util.TestContext;

public class Search {
	WebDriver driver;
	HomePage hp;
	TestContext context;
	 
	 public Search( TestContext context){
		 this.context=context;
	 }
	
	 @Given("goto application primary search page")
	  public void goto_product_searchPage() {
	   System.out.println("opened the search page of application"); 
	   driver=DriverFactory.getDriver();
	  }

	@When("user enters the product {string} in searchbox")
	public void user_enters_the_product_in_searchbox(String item) {
		hp=new HomePage(driver);
		hp.entersearchitem(item);
	   
	  }

	@When("user clicks on search button")
	public void user_clicks_on_search_button() {
		hp.clickonsearchicon();
	    }

	@Then("user should get the product displayed in search results")
	public void user_should_get_the_product_displayed_in_search_results() {
		hp.validateifitemavailableaftersearch();
	    /*System.out.println("As result user must get the correct products in search result page.");
	String actualText=driver.findElement(By.xpath("//*[@id='content']/div[3]/div/div/div[2]/div[1]/h4/a")).getText(); 
	String expectedText="HP LP3065";
	Assert.assertEquals(actualText, expectedText);
	System.out.println("item available after search in search box.");*/
	}

	@Then("user should get the proper warning message item not available")
	public void user_should_get_the_proper_warning_message() {
		hp.validateifitemisNOTavailableaftersearch();
	  /* System.out.println("user must get the proper message if product not found in search page");
		String expectedText="There is no product that matches the search criteria.";
		String actualText=driver.findElement(By.xpath("//*[@id='content']/p[2]")).getText();
		Assert.assertEquals(actualText, expectedText);
		System.out.println("item search not found , message found successfully.");*/
	 }
       }

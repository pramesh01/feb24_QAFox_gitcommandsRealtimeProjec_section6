package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AfterLogoutPage {

	WebDriver driver;
	public AfterLogoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	  }
	
	public void verifyLogoutisSuccessfull() {
		String expectedlogoutconfirmmsg="You have been logged off your account. It is now safe to leave the computer.";
		String actuallogoutconfirmmsg=driver.findElement(By.xpath("//*[@id='content']/p[1]")).getText();
		Assert.assertEquals(actuallogoutconfirmmsg, expectedlogoutconfirmmsg);
		System.out.println("Logged Out successfully from console.");
		
	  }
       }

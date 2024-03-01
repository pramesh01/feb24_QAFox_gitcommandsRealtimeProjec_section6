package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	  }
	
	@FindBy(id="input-email")
	WebElement enterusername;
	
	@FindBy(id="input-password")
	WebElement enterpassword;
	
	@FindBy(xpath="//*[@id='content']/div/div[2]/div/form/input")
	WebElement signinButton;
	
	public void enterusername(String emailid) {
		enterusername.sendKeys(emailid);
	}
	public void enterpassword(String password) {
		enterpassword.sendKeys(password);
	}
	public void enterblankusername(String emailid) {
		enterusername.sendKeys(emailid);
	}
	public void enterblankpassword(String password) {
		enterpassword.sendKeys(password);
	}
	public UserDashboardPage clickLoginButton() {
		signinButton.click();
		return new UserDashboardPage(driver);
	}
	public void verify_userLoggedin_Successfully() {
		 String expectedText="Edit your account information";
			String actualText=driver.findElement(By.xpath("//*[@id='content']/ul[1]/li[1]/a")).getText();
			Assert.assertEquals(actualText, expectedText);
			System.out.println("User is Logged Successfully.");
	}
	public void verify_userNOTLoggedin() {
		 System.out.println("user is not allowed to be login due to wrong crdedentials");
		  String actualWarningMessage="Warning: No match for E-Mail Address and/or Password.";
			String expectedWarningMessage=driver.findElement(By.xpath("//*[@id='account-login']/div[1]")).getText();
			Assert.assertEquals(actualWarningMessage, expectedWarningMessage);
			System.out.println("login credentials are incorrect , so resisting login to console.");
	}
	
	
}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegisterPage {

	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	  }
	
	@FindBy(id="input-firstname")
	WebElement firstnamefield;
	@FindBy(id="input-lastname")
	WebElement lastnamefield;
	@FindBy(id="input-email")
	WebElement emailtextfield;
	@FindBy(id="input-telephone")
	WebElement telephonetextfield;
	@FindBy(id="input-password")
	WebElement passwordtextfield;
	@FindBy(id="input-confirm")
	WebElement passwordconfirmfield;
	@FindBy(xpath="//*[@id='content']/form/div/div/input[1]")
	WebElement privacypolicycheckbox;
	@FindBy(xpath="//*[@id='content']/form/div/div/input[2]")
	WebElement continuebutton;
	
	public void enterfirstname(String fname) {
		firstnamefield.sendKeys(fname);
	}
	public void enterlastname(String lname) {
		lastnamefield.sendKeys(lname);
	}
	public void emailfield(String email) {
		emailtextfield.sendKeys(email);
	}
	public void entertelephone(String phonenumber) {
		telephonetextfield.sendKeys(phonenumber);
	}
	public void enterpassword(String password) {
		passwordtextfield.sendKeys(password);
	}
	public void confirmpassword(String confirmpassword) {
		passwordconfirmfield.sendKeys(confirmpassword);
	}
	
	public void selectPrivacypolicy() {
		privacypolicycheckbox.click();
	}
	
	public void clickcontinuebuttonforregisteruser() {
		continuebutton.click();
	}
	public void verifyifuserisregisteredsuccessfully() {
	System.out.println("user account has been created successfully.");
	String expectedConfirmationTextMessage="Congratulations! Your new account has been successfully created!";
	String actualConfirmationTextmessage=driver.findElement(By.xpath("//*[@id='content']/p[1]")).getText();
	Assert.assertEquals(actualConfirmationTextmessage, expectedConfirmationTextMessage);
	System.out.println("User is Registered successfully.got the successful registered message.");	
	}
	
public void verifyifuserisNOTregistered_duetoinvalidorduplicate_emailid() {
	String expectedwarningmessage="Warning: E-Mail Address is already registered!";
	String actualwarningmessage= driver.findElement(By.xpath("//*[@id='account-register']/div[1]")).getText();
	Assert.assertEquals(actualwarningmessage, expectedwarningmessage);
	System.out.println("test passed because got successfull warning message of already registered user.");
	
	}
      }

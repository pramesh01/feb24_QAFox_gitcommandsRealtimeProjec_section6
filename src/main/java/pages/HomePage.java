package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	  }
	@FindBy(xpath="//*[@id='top-links']/ul/li[2]/a/span[1]")
	WebElement myAccountBreadcrumb;
	
	@FindBy(xpath="//*[@id='top-links']/ul/li[2]/ul/li[2]/a")
	WebElement loginFromBreadcrumb;
	
	@FindBy(xpath="//*[@id='top-links']/ul/li[2]/ul/li[1]/a")
	WebElement RegisterLink;
	
	@FindBy(xpath="//input[@name='search']")
	WebElement searchtextbox;
	
	@FindBy(xpath="//*[@id='search']/span/button")
	WebElement searchbuttonlink;
	
	public LoginPage navigateToLoginPage() {
		myAccountBreadcrumb.click();
		loginFromBreadcrumb.click();
		System.out.println("successfully navigated to username and password entry Page");
		return new LoginPage(driver);
	  }
	
	public RegisterPage navigatetoRegisterPage() {
		myAccountBreadcrumb.click();
		RegisterLink.click();
		return new RegisterPage(driver);
	     }
	
	public void entersearchitem(String itemName) {
		searchtextbox.sendKeys(itemName);
		
	  }
	
	public void clickonsearchicon() {
		searchbuttonlink.click();
	  }
		
		public void validateifitemavailableaftersearch(){
		String actualText=driver.findElement(By.xpath("//*[@id='content']/div[3]/div/div/div[2]/div[1]/h4/a")).getText(); 
		String expectedText="HP LP3065";
		Assert.assertEquals(actualText, expectedText);
		}
		
		public void validateifitemisNOTavailableaftersearch(){
		String expectedText="There is no product that matches the search criteria.";
		String actualText=driver.findElement(By.xpath("//*[@id='content']/p[2]")).getText();
		Assert.assertEquals(actualText, expectedText);
       }
}
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDashboardPage {

	WebDriver driver;
	public UserDashboardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	  }
	
	@FindBy(xpath="//*[@id='top-links']/ul/li[2]/a/span[1]")
	WebElement myAccountBreadcrumb;	
	
	@FindBy(xpath="//*[@id='top-links']/ul/li[2]/ul/li[5]/a")
	WebElement logOutfield;
	
	public AfterLogoutPage gotoLogoutPage() {
		myAccountBreadcrumb.click();
		logOutfield.click();
		return new AfterLogoutPage(driver);
    	}
          }

package factory;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import util.ExtentManager;

public class DriverFactory {
	
	static WebDriver driver=null;
	
	public static WebDriver initializeBrowser(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			driver=new ChromeDriver();
			//driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		return driver;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
      }
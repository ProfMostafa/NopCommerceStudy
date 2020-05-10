package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.Helper;

public class testbase extends Helper
{
	public static WebDriver driver;
	
	@BeforeSuite
	@Parameters({"browser" , "URL"})
	public void startDriver(@Optional("chrome") String browser, 
			@Optional("https://demo.nopcommerce.com") String URL)
	{
		if(browser.equalsIgnoreCase("Chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
					+ "\\drivers\\chromedriver.exe");		
			ChromeOptions options = new ChromeOptions();
			options.addArguments("enable-automation");
			options.addArguments("--window-size=1920,1080");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-extensions");
			options.addArguments("--dns-prefetch-disable");
			options.addArguments("--disable-gpu");
		//	options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new ChromeDriver(options);		
		}
		else if (browser.equalsIgnoreCase("Firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")
					+ "\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}		
		driver.navigate().to(URL);
		driver.manage().window().maximize();
		//wait for mentioned time till you open the page
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);		
	}
	
	@AfterMethod
	public void takescrshtOnFailure(ITestResult Result)
	{
		if(Result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Failed");
			System.out.println("Taking a schreenshot ....");
			Helper.captureScreenShot(driver, Result.getName());	
		}
	}
	
	@AfterSuite
	public void stopdriver()
	{
		driver.quit();
	}

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Pagebase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Register")
	WebElement registerationlink;
	
	public void openRegistrationPage() 
	{
		registerationlink.click();
	}
}

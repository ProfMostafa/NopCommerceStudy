package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends Pagebase
{

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "input.gender-male")
	WebElement GenderRadiobutton;
	
	@FindBy(id = "FirstName")
	WebElement FirstNameTextBox;
	
	@FindBy(id = "LastName")
	WebElement LastName;
	
	@FindBy(id = "Email")
	WebElement Email;
	
	@FindBy(id = "Password")
	WebElement Password;
	
	@FindBy(id = "ConfirmPassword")
	WebElement ConfirmPassword;
	
	@FindBy(className = "valid")
	WebElement Day;
	
	@FindBy(name = "DateOfBirthMonth")
	WebElement Month;
	
	@FindBy(name = "DateOfBirthYear")
	WebElement Year;
	
	@FindBy(id = "register-button")
	WebElement RegisterButton;
	
	@FindBy(className = "result")
	public WebElement Result;
	
	public void Register(String fname, String lname, String day, String month, String year
			, String email, String password, String confirmpassword)
	{
		clickButton(GenderRadiobutton);
		setText(FirstNameTextBox, fname);
		setText(LastName, lname);
		setDDL(Day, day);
		setDDL(Month, month);
		setDDL(Year, year);
		setText(Email, email);
		setText(Password, password);
		setText(ConfirmPassword, confirmpassword);
		clickButton(RegisterButton);
		
	}
	
	
	

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Pagebase {
	protected WebDriver driver;
	
	
	public Pagebase(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	protected static void clickButton(WebElement btn) 
	{
		btn.click();
	}
	
	protected static void setText(WebElement textbox, String value) 
	{
		textbox.sendKeys(value);
	}
	
	protected static void setDDL(WebElement DDL, String value) 
	{
		Select select = new Select(DDL);
		select.selectByVisibleText(value);
	}
	
	
}

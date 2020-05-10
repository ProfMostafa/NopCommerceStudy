package tests;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import data.ExcelReader;
import pages.HomePage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends testbase 
{
	HomePage homePage;
	UserRegistrationPage userRegistrationPage;

	@DataProvider(name = "ExcelData")
	public Object[][] userRegisterData() throws IOException
	{
		ExcelReader ER = new ExcelReader("F:\\Java_Output\\NopCommerceStudy\\src\\test\\java\\data\\UserData.xls", 0);
		//System.out.println(ER.getExcelData());
		return ER.getExcelData();

	}

	@Test (dataProvider = "ExcelData" )
	public void userCanRegister(String fname, String lname,String day,
			String month,String year,String email, String password, String confirmpassword)
	{
		homePage = new HomePage(driver);
		homePage.openRegistrationPage();
//		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
//		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		userRegistrationPage = new UserRegistrationPage(driver);
//		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
//		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		userRegistrationPage.Register(fname,lname,day,month,year,email,password,confirmpassword);
		Assert.assertTrue(userRegistrationPage.Result.getText().contains("Your registration completed"));
	}



}

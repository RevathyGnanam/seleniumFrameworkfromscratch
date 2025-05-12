package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_RegistrationTest extends BaseClass {
	
	
	@Test(groups= {"Regression","Master"})
	public void verify_Account_Registration() {
		
		logger.info("------------Reached the home page-------------------");
		HomePage homepage = new HomePage(driver);
		homepage.clickRegister();
		
		logger.info("------------Clicked on register page-------------------");
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		logger.info("------------providing customer details-------------------");
		regpage.selectgender();
		regpage.enterFirstName(randomString());
		regpage.enterLastName(randomString());
		regpage.enterEmail(randomAlphaNumerics()+"@gmail.com");
		String password = randomAlphaNumeric();
		regpage.enterPassword(password);
		regpage.enterConfirmPassword(password);
		regpage.clickOnRegisterButton();
		String confirmmessage =regpage.getConfirmationMessage();
		Assert.assertEquals(confirmmessage, "Your registration completed");
		regpage.clickonContinueButton();
				
	}
	



}

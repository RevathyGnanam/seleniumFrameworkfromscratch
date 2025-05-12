package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DemoHomePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginFromDataDriven extends BaseClass{
	
	@Test(dataProvider="LoginData", dataProviderClass = DataProviders.class,groups="dataDriven")
	public void verify_LoginFromDD(String email,String pass) {
		
		logger.info("--------------TC002_LoginTest------------");
		//HomePage
		HomePage homepage = new HomePage(driver);
		homepage.clickLogin();
		
		//LoginPage
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailId(email);
		loginPage.enterPassword(pass);
		loginPage.clickOnLoginButton();
		
		//LoginDemoPage
		DemoHomePage demoHomePage = new DemoHomePage(driver);
		Assert.assertTrue(demoHomePage.VerifyLogoutButton());
		demoHomePage.clickLogoutButton();
		
		logger.info("--------------Finished Logouts------------");
		
		
		
		
	}

}

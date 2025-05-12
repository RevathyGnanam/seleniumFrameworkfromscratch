package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DemoHomePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups= {"Sanity","Master"})
	public void verify_Login() {
		
		logger.info("--------------TC002_LoginTest------------");
		//HomePage
		HomePage homepage = new HomePage(driver);
		homepage.clickLogin();
		
		//LoginPage
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailId(p.getProperty("userName"));
		loginPage.enterPassword(p.getProperty("passWord"));
		loginPage.clickOnLoginButton();
		
		//LoginDemoPage
		DemoHomePage demoHomePage = new DemoHomePage(driver);
		Assert.assertTrue(demoHomePage.VerifyLogoutButton());
		
		logger.info("--------------Finished LoginTest------------");
		
		
		
	}

}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(id="Email")	
	WebElement emailtextBox;

	@FindBy(id="Password")	
	WebElement passwordtextBox;

	@FindBy(xpath = "//*[@class='button-1 login-button']")	
	WebElement loginButton;
	
	public void enterEmailId(String emailId) {
		emailtextBox.sendKeys(emailId);;
	}

	public void enterPassword(String password) {
		passwordtextBox.sendKeys(password);
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	
}

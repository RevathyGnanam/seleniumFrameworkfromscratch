package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);

	} 


	@FindBy(id="gender-female")	
	WebElement genderBulletButton;

	@FindBy(id="FirstName")	
	WebElement firstNametextBox;

	@FindBy(id = "LastName")	
	WebElement lastNametextBox;

	@FindBy(id="Email")	
	WebElement emailtextBox;

	@FindBy(id="Password")	
	WebElement passwordTextBox;

	@FindBy(id="ConfirmPassword")	
	WebElement confirmPasswordTextBox;
	
	@FindBy(id="register-button")	
	WebElement registerButton;
	

	@FindBy(xpath="//*[contains(text(),'Your registration completed')]")	
	WebElement confirmMessage;

	@FindBy(xpath="(//*[@type='button'])[2]")	
	WebElement continueButton;




	public void selectgender() {
		genderBulletButton.click();
	}

	public void enterFirstName(String fname) {
		firstNametextBox.sendKeys(fname);;
	}

	public void enterLastName(String lname) {
		lastNametextBox.sendKeys(lname);
	}
	
	public void enterEmail(String email) {
		emailtextBox.sendKeys(email);
	}
	

	public void enterPassword(String password) {
		passwordTextBox.sendKeys(password);
	}

	public void enterConfirmPassword(String confirmpass) {
		confirmPasswordTextBox.sendKeys(confirmpass);
	}
	
	public void clickOnRegisterButton() {
		registerButton.click();
	}
	
	public String getConfirmationMessage() {
		try {
		return confirmMessage.getText();

	}
		catch(Exception e) {
			return (e.getMessage());
		}
	}


	public void clickonContinueButton() {
		continueButton.click();
	}





}

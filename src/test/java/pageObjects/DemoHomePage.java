package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoHomePage extends BasePage {

	public DemoHomePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//*[@class='ico-logout']")	
	WebElement linkLogout;
	
	public boolean VerifyLogoutButton() {
		try {
		return linkLogout.isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
		
	}
	
	public void clickLogoutButton() {
		linkLogout.click();
	}

}

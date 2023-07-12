package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement sendEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement setPassword;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement btn_submit;
	
	
	
	public void setEmail(String email)
	{
		sendEmail.sendKeys(email);
		
	}
	public void setPassword(String psswd)
	{
		setPassword.sendKeys(psswd);
		
	}

	public void clickOnLogin() {
		btn_submit.click();
	}
	
}

package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	
	public  AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Elements
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement confPassword;
	
	@FindBy(name="agree")
	WebElement agree;
	
	@FindBy(xpath="button[type='submit']")
	WebElement btn_Submit;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement telephone;
	
	//Actions
	
	public void setFirstName(String fName)
	{
		firstName.sendKeys(fName);
	}
	public void setlastName(String lName)
	{
		lastName.sendKeys(lName);
	}
	
	public void Email (String mail)
	{
		email.sendKeys(mail);
	}
	public void password (String pswd)
	{
		password.sendKeys(pswd);
	}
	
	public void confirmPassword(String psswd)
	{
		confPassword.sendKeys(psswd);
	}
	
	public void setTelephone(String num)
	{
		telephone.sendKeys(num);
	}
	
	public void agreePolicy ()
	{
		agree.click();
	}
	public void btn_Submit ()
	{
		btn_Submit.click();
	}
	
	public String getConfirmationMsg() {
		try {
			WebElement msgConfirmation = null;
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}

	}
}


package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;
public class TC_001_AccountRegistationTest extends BaseClass {
	
	
	
	@Test(groups = {"Regression","Master"} )
	public void test_account_Registration() throws InterruptedException
	{
		logger.debug("Running application");
		logger.info("***Starting TC_001_AccountRegistrationTest***");
		
		try
		{
			HomePage hp = new HomePage(driver);
			
		hp.clickMyAccount();
		logger.info("Clicked on my account");
		hp.clickRegister();
		logger.info("Clicked on my register");
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		regpage.setFirstName(randomString());
		regpage.setlastName(randomString());
		regpage.Email(randomString()+ "@gmail.com");
	    regpage.setTelephone(randomNumber());
		
		String p = randomAlphaNumeric();
		regpage.password(p);
		regpage.confirmPassword(p);
		regpage.agreePolicy();
		logger.info("Clicked on my agree");
		regpage.btn_Submit();
		
      String confmsg=regpage.getConfirmationMsg();
		
		logger.info("Validating expected message");
		Assert.assertEquals(confmsg, "Your Account Has Been Created!","Test failed");
		
		}catch(Exception e)
		{
			
		}
		logger.info("***  Finished TC_001_AccountRegistrationTest ***");		
		}
	
	
}

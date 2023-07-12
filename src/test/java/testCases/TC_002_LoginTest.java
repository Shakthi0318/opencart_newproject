package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	
	@Test (groups = {"Sanity","Master"})
	public void test_login()
	{
		logger.info("Starting TC_002_LoginTest****");
		
		try
		{				
			HomePage hp=new HomePage(driver);
			
			hp.clickMyAccount();
			
			logger.info("Clicking on my account");
						
			hp.clickLogin();
			logger.info("Clicking on Login Link");
			
			LoginPage lp=new LoginPage(driver);
			
			logger.info("Providing login details");
			
			lp.setEmail(rb.getString("email")); // valid email, get it from properties file
			
			lp.setPassword(rb.getString("password")); // valid password, get it from properties file
			
			lp.clickOnLogin();
			
			MyAccountPage macc=new MyAccountPage(driver);
			
			boolean targetpage=macc.isMyAccountPageExists();
						
			Assert.assertEquals(targetpage, true);
			
		}	
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info(" Finished TC_002_LoginTest");
		
	}
	
	
}



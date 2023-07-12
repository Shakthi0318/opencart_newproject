package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void test_LoginDDT(String email, String password, String exp)
	
	
	{
		
		
		logger.info("**Starting TC_003_LoginDDT***");
		try
		{
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();		
			hp.clickLogin();
		
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(email); // valid email, get it from properties file
			lp.setPassword(password); // valid password, get it from properties file
			lp.clickOnLogin();
			
			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetpage=macc.isMyAccountPageExists();
			
			if(exp.equals("Valid"))
			{
				if(targetpage==true)
				{
					macc.clickLogout();
					Assert.assertTrue(true);
				}
			}
			
			else {
				Assert.assertFalse(false);
			}
			
			if(exp.equals("Invalid"))
			{
				if(targetpage==true)
				{
					MyAccountPage macc1=new MyAccountPage(driver);
					macc1.clickLogout();
					Assert.assertTrue(false);
				}
			}
			
			else
			{
				Assert.assertTrue(true);
			}
		}	
			catch(Exception e)
			{
				Assert.fail();
			}
		
			logger.info("Finished TC_003_LoginDataDrivenTest");
			
		}
}
	

	
	

	




	
	



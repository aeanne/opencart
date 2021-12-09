package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.AccountRegistrationPage;
import pageobjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass{
	

	
	@Test(groups={"regession","master"})// this is grouping the test cases
	public void test_account_Registration()
	{
		
		try
		{
		logger.info(" Starting TC_001_Account Registration Page ");
		
		driver.get(rb.getString("appURL"));
		logger.info("Home Page displayed. ");
		driver.manage().window().maximize();
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount ");
		
		hp.clickRegister();
		logger.info("Clicked on Register ");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName("John");
		logger.info("Provided FirstName ");
		
		regpage.setLastName("Canedy");
		logger.info("Provided LastName ");
		
		regpage.setEmail(randomestring()+"@gmail.com");
		logger.info("Provided Email ");
		
		regpage.setTelephone("65656565");
		logger.info("Provided PhoneNumber ");
		
		regpage.setPassword("abcxyz");
		logger.info("Provided Password ");
		
		regpage.setConfirmPassword("abcxyz");
		logger.info("Provided Confirmed Password ");
		
		regpage.setPrivacyPolicy();
		
		regpage.clickContinue();
		logger.info("Clicked on Continue ");
		
		String confmsg=regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("Account Registration Success ");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Account Registration Failed ");
			captureScreen(driver,"test_account_Registration");
			Assert.assertTrue(false);
		}
		
		}
		catch(Exception e)
		{
			logger.error("Account Registration Failed ");
			Assert.fail();
		}
		
		logger.info(" Finished TC_001_Account Registration Page ");
		
		}
	
	
		

}

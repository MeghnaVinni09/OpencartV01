package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_02_LoginTest extends BaseClass {

	
@Test(groups = {"Sanity","Master"})
public void verify_loginTest()
{
	
	try {
		logger.info("TC_02 Started");
	HomePage hp= new HomePage(driver);
	hp.clickMyAccount();
	hp.clickLogin();
	
	LoginPage lp=new LoginPage(driver);
	lp.enterEmail(p.getProperty("email"));
	lp.enterPwd(p.getProperty("password"));
	lp.clickLogin();
	
	MyAccountPage ap= new MyAccountPage(driver);
	boolean loginConfirmationMessage= ap.loginConfirmation();
	Assert.assertEquals(loginConfirmationMessage, true);
}
	catch (Exception e) {
		logger.error("Test Failed");
		logger.debug("Debug logs..");
		Assert.fail();
		}

	logger.info("TC_02  ended");
}
}

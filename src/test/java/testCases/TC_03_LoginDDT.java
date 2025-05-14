package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_03_LoginDDT extends BaseClass {
	
	@Test(dataProvider = "Login Data", dataProviderClass = DataProviders.class,groups = "Datadriven")//getting data provider from different class
	public void verify_loginDDT(String email, String pwd, String exp)
	{
		try {
	HomePage hp= new HomePage(driver);
	hp.clickMyAccount();
	hp.clickLogin();
	
	LoginPage lp=new LoginPage(driver);
	lp.enterEmail(p.getProperty(email));
	lp.enterPwd(p.getProperty(pwd));
	lp.clickLogin();

	MyAccountPage ap= new MyAccountPage(driver);
	boolean loginConfirmationMessage= ap.loginConfirmation();
	
	/*Data is valid - login success - test pass- logout
	 * 			    -login unsuccessful-test fail
	 * Data is invalid- login unsuccessful- test pass
	 * 				-login succes-test fail-logout
	 */
	
	if(exp.equalsIgnoreCase("Valid"))
	{
		if(loginConfirmationMessage==true)
		{
			ap.clickLogout();
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	if(exp.equalsIgnoreCase("Invalid"))
	{
		if(loginConfirmationMessage==true)
		{
			ap.clickLogout();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
		}
	}
		}
		catch (Exception e) {
			Assert.fail();
	
}
	}
}

package testCases;
import testBase.BaseClass;
import java.time.Duration;
import java.util.Random;
import java.util.RandomAccess;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import net.bytebuddy.utility.RandomString;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_01_AccountRegistration extends BaseClass {

	
@Test(groups = {"Regression","Master"})
public void verify_account_registration()
{
	
	try {
		
		logger.info("****Test case TC_01_Account Registration started****");
	HomePage hp = new HomePage(driver);
	hp.clickMyAccount();
	hp.clickRegister();
	
	logger.info("****Registration process ****");
	AccountRegistrationPage  regpage = new AccountRegistrationPage(driver);
	regpage.setFirstName(randomString().toUpperCase());
	regpage.setLastName(randomString().toUpperCase());
	regpage.setEmail(randomString()+"@gmail.com");
	regpage.setTelephone(randomNumber());
	
	//generating random password
	String rndPwd= randomAlphaNumeric();
	regpage.setPassword(rndPwd);
	regpage.confirmPassword(rndPwd);
	logger.info("****Agree the page****");
	regpage.clickAgree();
	regpage.clickContinue();
	
	logger.info("Validating sucess message");
	String confirmMessage = regpage.getConfirmationMsg();
	Assert.assertEquals(confirmMessage, "Your Account Has Been Created!");
	
	}
	catch (Exception e) {
	logger.error("Test Failed");
	logger.debug("Debug logs..");
	}
	
	logger.info("Finished test case");

}

}

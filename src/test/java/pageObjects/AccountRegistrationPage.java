package pageObjects;

import java.security.PublicKey;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
@FindBy(xpath="//input[@id='input-firstname']")
WebElement txtFirstName;
	
@FindBy(xpath="//input[@id='input-lastname']")
WebElement txtLastName;

@FindBy(xpath="//input[@id='input-email']")
WebElement txtEmail;

@FindBy(xpath="//input[@id='input-telephone']")
WebElement txtTelephone;

@FindBy(xpath="//input[@id='input-password']")
WebElement txtPwd;

@FindBy(xpath="//input[@id='input-confirm']")
WebElement txtConfirmPwd;

@FindBy(xpath="//input[@name='agree']")
WebElement chkAgree;

@FindBy(xpath="//input[@value='Continue']")
WebElement btnContinue;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement confirmMsg;



public void setFirstName(String fName)
{
	txtFirstName.sendKeys(fName);
}

public void setLastName(String LName)
{
	txtLastName.sendKeys(LName);
}

public void setTelephone(String tel)
{
	txtTelephone.sendKeys(tel);
}

public void setEmail(String email)
{
	txtEmail.sendKeys(email);
}

public void setPassword(String pwd)
{
	txtPwd.sendKeys(pwd);
}

public void confirmPassword(String confirmPwd)
{
	txtConfirmPwd.sendKeys(confirmPwd);
}

public void clickAgree()
{
	chkAgree.click();
}

public void clickContinue()
{
	btnContinue.click();
}


public String getConfirmationMsg()
{
	try {
		return(confirmMsg.getText());
	} catch (Exception e) {
		// TODO: handle exception
		return (e.getMessage());
	}
}
	
	
	
}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
@FindBy(xpath="//input[@id='input-email']")
WebElement txtEmail;

@FindBy(xpath="//input[@id='input-password']")
WebElement txtPassword;

@FindBy(xpath="//input[@value='Login']")
WebElement btnLogin;


@FindBy(xpath="//h2[normalize-space()='My Account']")
WebElement loginConfirmMsg;


public void enterEmail(String email)
{
	txtEmail.sendKeys(email);
}


public void enterPwd(String pwd)
{
	txtPassword.sendKeys(pwd);
}


public void clickLogin()
{
	
	btnLogin.click();
}

public String loginConfirmation()
{
	try {
		return loginConfirmMsg.getText();
	} catch (Exception e) {
		return (e.getMessage());
	}
	
}
	
	
	
}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	

@FindBy(xpath="//h1[normalize-space()='Account']")
WebElement loginConfirmMsg;


@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
WebElement btnLogout;



public boolean loginConfirmation()
{
	try {
		return loginConfirmMsg.isDisplayed();
	} catch (Exception e) {
		return false;
	}
	
}

public void clickLogout()
{
	btnLogout.click();
}
	//https://demo.opencart.com.gr/
	
	
}

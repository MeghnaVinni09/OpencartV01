package testBase;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pageObjects.MyAccountPage;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;//Log4j
	public Properties p;
	
	//logger ininitalization
	 public BaseClass()
	 {
			this.logger =LogManager.getLogger(this.getClass());
	 }
	@BeforeClass(groups = {"Sanity,Regression,Master,Datadriven"})
	@Parameters({"os","browser"})
	public void setUp(String os, String br) throws IOException
	{
		//load the configuration file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p= new Properties();
		p.load(file);
		
		
		
		
		//getting the browser from the parameters from xml file
		switch(br.toLowerCase())
		{
		case "chrome":driver= new ChromeDriver(); break;
		case "edge":driver= new EdgeDriver(); break;
		default: System.out.println("Invalid browser name"); return;
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appURL1"));
		//https://demo.opencart.com/en-gb?route=common/home
		//https://tutorialsninja.com/demo/
		driver.manage().window().maximize();
	}
		
	@AfterClass(groups = {"Sanity,Regression,Master,Datadriven"})
	public void tearDown()
	{
		MyAccountPage ap= new MyAccountPage(driver);
		ap.clickLogout();
		driver.quit();
	}

	
	public String randomString()
	{
		String randomString = RandomStringUtils.randomAlphabetic(10);
		return randomString; 
	}

	public String randomNumber()
	{
		String randomNumber = RandomStringUtils.randomNumeric(10);
		return randomNumber; 
	}

	public String randomAlphaNumeric()
	{
		String randomNumber = RandomStringUtils.randomNumeric(10);
		String randomString = RandomStringUtils.randomAlphabetic(10);
		return (randomNumber+"@"+randomString); 
	}
	
	public String captureScreen(String tname) {
		
		String timeStamp= new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath= System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp;
		File targetFile= new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
}

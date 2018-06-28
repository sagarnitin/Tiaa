package IWC;

import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.ExcelUtilities;
import Utilities.TestCaseRunner;
import Utilities.TestConfig;
import Utilities.WebDriverUtilities;
import Utilities.XMLUtilities;



public class IWCLogin 
{
	public static RemoteWebDriver driver;
	static String testdatapath=XMLUtilities.getXMLvalues("testdatapath");
	//public static TestConfig testconfig=new TestConfig();
	
	 static String url=ExcelUtilities.getCellData(testdatapath, "Sheet1", "URL",2);
	 static String username=ExcelUtilities.getCellData(testdatapath, "Sheet1", "Username",2);
	 static String password=ExcelUtilities.getCellData(testdatapath, "Sheet1", "Password",2);
	 IWCElements iwcelements=new IWCElements();
	
	
	
	
	
	
	@BeforeTest
	public void openBrowser()
	{
		
	driver=	WebDriverUtilities.openBrowser(driver);
	
	}
	
	@Test
	public void login()
	{
		 String testdatapath=XMLUtilities.getXMLvalues("testdatapath");
		try {
		driver.get(url);
		WebDriverUtilities.waitandType(driver, By.xpath(iwcelements.IWCUsername), "Login", username);
		WebDriverUtilities.waitandType(driver, By.xpath(iwcelements.IWCPassword), "Loging username", password);
		WebDriverUtilities.waitandclick(driver, By.xpath(iwcelements.IWCLoginbutton), "LoginButton");
		
		
		
		
		
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterTest
	public void Close()
	{
		driver.quit();
	}
}

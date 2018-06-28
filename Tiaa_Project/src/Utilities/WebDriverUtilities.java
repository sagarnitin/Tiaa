package Utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class WebDriverUtilities {
	public static String timeout=XMLUtilities.getXMLvalues("timeout");


	public static RemoteWebDriver openBrowser(RemoteWebDriver driver) {

		try{

			String browsername=	XMLUtilities.getXMLvalues("browser");
			String huburl=	XMLUtilities.getXMLvalues("huburl");

			if(Utils.verifyhub(huburl)==false)
			{
				Assert.fail();		
			};

			if(browsername.contains("FF"))
			{
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
				DesiredCapabilities capabilitied= DesiredCapabilities.firefox();
				capabilitied.setCapability("marionette", true);
				driver=new FirefoxDriver(capabilitied);
				

			}
			

			driver.manage().window().maximize();

		}catch(Exception e)
		{
			e.printStackTrace();
		}

		return driver;
	}






public static RemoteWebDriver waitandclick(RemoteWebDriver driver, By by,String elementDescription)
{
	
	WebDriverWait wait= new WebDriverWait(driver, Integer.parseInt(timeout));
	try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		if(driver.findElement(by).isDisplayed())
		{
			driver.findElement(by).click();		
		}	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	
	
	return driver;
	
	
	
}

public static RemoteWebDriver waitandType(RemoteWebDriver driver, By by,String elementDescription,String data)
{
	WebDriverWait wait= new WebDriverWait(driver, Integer.parseInt(timeout));
	try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		if(driver.findElement(by).isDisplayed())
		{
			driver.findElement(by).clear();
			driver.findElement(by).sendKeys(data);
		}	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	
	
	
	return driver;
}

public static RemoteWebDriver verifyElement(RemoteWebDriver driver, By by,String elementDescription)
{
	WebDriverWait wait= new WebDriverWait(driver, Integer.parseInt(timeout));
	try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		if(driver.findElement(by).isDisplayed())
		{
			System.out.println(elementDescription);
		}	
	}
	catch(Exception e)
	{
		Assert.fail(elementDescription);
		e.printStackTrace();
	}
	return driver;
}




}

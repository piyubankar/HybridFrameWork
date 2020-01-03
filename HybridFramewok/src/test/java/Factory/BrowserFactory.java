package Factory;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserFactory
{
     
	static WebDriver driver;
	
	
	public static WebDriver getBrowser(String browserName)
	{
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			
			System.out.println(DataProviderFactory.getConfig().getAChromePath());
	        System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getAChromePath());
	        
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			
			System.setProperty("webdriver.gecko.driver", DataProviderFactory.getConfig().getAFirefoxPath());
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	 
	public static void closeBrowser(WebDriver Idriver)
	{
		Idriver.quit();
	}
	
}


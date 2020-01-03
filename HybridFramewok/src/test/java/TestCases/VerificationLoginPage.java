/**
 * 
 */
package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import Pages.LoginPage;


public class VerificationLoginPage
{     
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		
		 driver= BrowserFactory.getBrowser("chrome");
	     driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		
	}
	
    @Test
    public void testPage() throws InterruptedException
    {
    	
		
    	LoginPage page=PageFactory.initElements(driver, LoginPage.class);
    	String title=page.getApplicationTitle();
    	System.out.println("My Application Title is:"+title);
    //	page.loginApplcation("sheetalbankar21@gmail.com", "sb2192@b");
    	//System.out.println(DataProviderFactory.getExcel().getData(0, 0, 0));
    	//System.out.println(DataProviderFactory.getExcel().getData(0, 0, 1));
    	page.loginApplcation(DataProviderFactory.getExcel().getData(0, 0, 0),DataProviderFactory.getExcel().getData(0, 0, 1));
    }
    
    @AfterMethod 
    public void tearDown()
    {
    	BrowserFactory.closeBrowser(driver);
    }
}

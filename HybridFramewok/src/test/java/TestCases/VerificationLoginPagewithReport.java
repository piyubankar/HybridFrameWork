/**
 * 
 */
package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import Pages.LoginPage;


public class VerificationLoginPagewithReport
{     
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setUp()
	{    
		report= new ExtentReports("./Reports/LoginPageReport.html",true);
		logger= report.startTest("Verify Test Login");
		 driver= BrowserFactory.getBrowser("chrome");
	     driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	    logger.log(LogStatus.INFO, "Application is up and running");
		
	}
    @Test
    public void testPage() throws InterruptedException
    {
    	LoginPage page=PageFactory.initElements(driver, LoginPage.class);
    	String title=page.getApplicationTitle();
    	Assert.assertTrue(title.contains("Gmail"));
    	logger.log(LogStatus.PASS, "Login Page Loaded");
    	System.out.print("My Application Title is:"+title);
       logger.log(LogStatus.INFO, "Application is up and running");
    
        page.loginApplcation(DataProviderFactory.getExcel().getData(0,0,0),DataProviderFactory.getExcel().getData(0, 0, 1));
        logger.log(LogStatus.INFO, "Login to Application");
        page.signOutLink();
      logger.log(LogStatus.PASS, "Signout Link is Present");
    }
    
   @AfterMethod 
    public void tearDown()
    {
    	BrowserFactory.closeBrowser(driver);
    	report.endTest(logger);
    	report.flush();
    }
}

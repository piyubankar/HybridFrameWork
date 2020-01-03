package Pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage 
{

     WebDriver driver;
	
	public LoginPage(WebDriver Idriver)
	{
		this.driver= Idriver;
		
	}
	public String getApplicationTitle()
	{
		
		return driver.getTitle();
		
	}
	
	@FindBy(xpath="//input[@id='Email'] | //input[@id='identifierId']") WebElement username;
	@FindBy(xpath="//span[@class='CwaK9'] | //input[@id='next']") WebElement next;
	@FindBy(xpath="//input[@name='password'] | //input[@name='Passwd']")WebElement password;
	//@FindBy(xpath="//span[@class='CwaK9'] | //input[@id='signIn'] | //span[contains(text(),'Next')]")WebElement sumbit;
	@FindBy(xpath="//input[@id='signIn'] | //span[contains(text(),'Next')]")WebElement sumbit;
	@FindBy(xpath="//span[@class='gb_xa gbii']") WebElement logo;
	@FindBy(xpath="//a[@id='gb_71']")WebElement signout;
	


   public void loginApplcation(String user,String pass) throws InterruptedException
   { 
	  
	   username.sendKeys(user);
	   next.click();
	   password.sendKeys(pass);
	   Thread.sleep(2000);
	   sumbit.click();
	   Thread.sleep(5000);
	  
	  
	   
   }
   
   public void signOutLink() throws InterruptedException
   {
	   logo.click();
	   Thread.sleep(7000);
	  
	  signout.click();
	  
			   
			   
   }
   
  
  
}
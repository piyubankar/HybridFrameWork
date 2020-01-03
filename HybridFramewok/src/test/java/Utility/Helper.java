package Utility;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
/// Capturing Screenshot///
//import java.io.File;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Helper
{

	 public static String captureScreenShot(WebDriver driver,String screenshotname)
	 {

			// capture full screen shot of page   
		/*Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
	 ru.yandex.qatools.ashot.Screenshot screenshot = new AShot().takeScreenshot(driver);
			try {
				ImageIO.write( screenshot.getImage(),"PNG",new File("C:\\Users\\Nilesh\\eclipse-workspace\\HybridFramewok\\Screenshot\\"+screenshotname +System.currentTimeMillis()+".png"));
			//String DestFile="C:\\Users\\Nilesh\\eclipse-workspace\\HybridFramewok\\Screenshot\\"+screenshotname +System.currentTimeMillis()+".png";
				
			} catch (Exception e) 
			{
				  System.out.println("Exception is:"+e.getMessage());
			}
			return screenshotname;*/
			    
		 
		 
		// capture only current page
			
		 TakesScreenshot scrShot =((TakesScreenshot)driver); 
	   
	      //Call getScreenshotAs method to create image file

          File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        
           //Move image file to new destination

           String DestFile="C:\\Users\\Nilesh\\eclipse-workspace\\HybridFramewok\\Screenshot\\"+screenshotname +System.currentTimeMillis()+".png";
            //Copy file at destination

          try {
			Files.copy(SrcFile,new File(DestFile));
		} catch (Exception e)
           {
			System.out.println("Failed to capture Screenshot"+e.getMessage());
		   }
          return DestFile;
	 }


}

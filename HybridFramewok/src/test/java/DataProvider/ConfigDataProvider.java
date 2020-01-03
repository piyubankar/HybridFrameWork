package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider
{
	Properties pro;

	public ConfigDataProvider()
	{
		
		File src =new File("./Configuration/config.properties");
		try
		{
			FileInputStream fis = new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e)
		{
			System.out.println("Exception is:"+e.getMessage());
		}
	}
		
	
	public String getAChromePath()
	{
		
		String path=pro.getProperty("ChromePath");
		return path;
	}
	
	public String getAFirefoxPath()
	{
		
		String path=pro.getProperty("FirefoxPath");
		return path;
	}
		public String getApplicationUrl()
		{
			
			String url=pro.getProperty("url");
			System.out.println(url);
			return url;
		}
		
		
		
		
		
	}


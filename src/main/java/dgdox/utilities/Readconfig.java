package dgdox.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
	
	Properties pro;
	public  Readconfig()
	{
		File srcFile=new File("./Resources/config.properties");
		try {
			FileInputStream fileInputStream=new FileInputStream(srcFile);
			pro=new Properties();
			pro.load(fileInputStream);
			
		}
		catch(Exception e)
		{
			System.out.println("Exception is"+e.getMessage());
		}
	}
	
	public String UN1212()
	{
		String UN1212=pro.getProperty("UN1212");
		return UN1212;
				
	}
	public String UN1234()
	{
		String UN1234=pro.getProperty("UN1234");
		return UN1234;
				
	}
	public String UN1207()
	{
		String UN1207=pro.getProperty("UN1207");
		return UN1207;
				
	}
	
	public String UNNumber()
	{
		String UNNumber=pro.getProperty("UNNumber");
		return UNNumber;
	}
	public String UN1203()
	{
		String UN1203=pro.getProperty("UN1203");
		return UN1203;
				
	}
	
	public String UN1224()
	{
		String UN1224=pro.getProperty("UN1224");
		return UN1224;
	}
	
	public String UN1204()
	{
		String UNNumber1204=pro.getProperty("UN1204");
		return UNNumber1204;
	}
	
	public String getAircraftType()
	{
		String Aircraft=pro.getProperty("Aircraft");
		return Aircraft;
	}
				
	public String getApplicationURL()
	{
		String baseURL=pro.getProperty("baseURL");
		return baseURL;
	}
	
    public String pageTitle()
	{
		String loginpageTitle=pro.getProperty("loginpageTitle");
		return loginpageTitle;
	}
	public String getuserName()
	{
		String userName=pro.getProperty("userName");
		return userName;
	}
	public String getpassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	
			
			
			public String getBrowser()
			{
		String browser=pro.getProperty("browser");
		return browser;
			}
			public String mode()
			{
				String mode=pro.getProperty("mode");
				return mode;
			}
		
	
	
	

}

package dgdox;

//import org.apache.logging.log4j.*;


import java.io.File;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

//import org.apache.commons.compress.harmony.pack200.NewAttribute;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;

 //import org.apache.logging.log4j.LogManager;
 
// import org.apache.logging.log4j.Logger;
 

 import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



import dgdox.utilities.Readconfig;
import io.github.bonigarcia.wdm.WebDriverManager;


/*   Ideabytes Inc
Project 3PLDgdox 
Objective: Test Login .....
Developed by: Krishnaveni
Date: 
Version: 1.0
Revision history:  
*/

public class Baseclass {
	
	Readconfig read = new Readconfig();

	public String baseURL = read.getApplicationURL();
	public String loginpageTitle = read.pageTitle();
	//public String userName = read.getuserName();
	//public String password = read.getpassword();
	//public String mode = read.mode();
//	public String Aircraft=read.getAircraftType();
	public String UN1204=read.UN1204();
//	public String UN1224=read.UN1224();
	public String UN1203=read.UN1203();
	public String UN1212=read.UN1212();
	public String UN1207=read.UN1207();
	public String UN1234=read.UN1234();
	
	public String UNNumber=read.UNNumber();
	
	//for giving browser option through maven and jenkins
	//public String browser=System.getProperty("browser");

	public String browser = read.getBrowser();

	public static WebDriver driver;
	//public WebDriver driver;
	public static Logger logger;
	
	
	public WebDriver setupBrowser() {
		logger = LogManager.getLogger(Baseclass.class.getName());

		PropertyConfigurator.configure(System.getProperty("user.dir") + "/log4j.properties");

		BasicConfigurator.configure();

		if (browser.equals("chrome")) {
			try {
				WebDriverManager.chromedriver().setup();

				driver = new ChromeDriver();
				logger.info("Chrome browser iniatialized successfully");

			} catch (Exception e) {
				System.out.println(e.getMessage());
				logger.error("Couldnot open browser");
			}
		} else if (browser.equals("firefox")) {
			try {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				logger.info("Firefox browser iniatialized successfully");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				logger.error("Couldnot open browser");
			}
		} else if (browser.equals("edge")) {
			try {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				logger.info("Edge browser iniatialized successfully");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				logger.error("Couldnot open browser");
			}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		
		
		return driver;
	}
	
     //screenshot code 
	public String getScreenShotPath(String testcaseName, WebDriver driver) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src
		// folder
		String destination = System.getProperty("user.dir") + "\\reports\\" + testcaseName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	/*public static void expWait()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}*/

	

}

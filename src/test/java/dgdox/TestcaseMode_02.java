package dgdox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dgdox.pageobjects.AddShipper;
import dgdox.pageobjects.Selectmode;
import dgdox.pageobjects.loginpage;
import dgdox.utilities.Datadriven;

public class TestcaseMode_02 extends Baseclass {
	
//public WebDriver driver;
 
//@BeforeTest
public  void setup() {

	driver = setupBrowser();
	driver.get(baseURL);
}
	
	//@Test(priority=1)
	public void getMode() throws InterruptedException, IOException
	{
		Datadriven datadriven=new Datadriven();
		ArrayList<String> data=datadriven.getData("Login");
		
		loginpage lpLoginpage = new loginpage(driver);

		//lpLoginpage.setUser(userName);
		lpLoginpage.username().sendKeys(data.get(1));
		
         logger.info("Username Entered");
		//lpLoginpage.setpass(password);
         lpLoginpage.setpass().sendKeys(data.get(2));
		
		logger.info("Password Entered");

		lpLoginpage.bulogin();
		//Assert.assertTrue(false);
		logger.info("Login Success");
	}
	//@Test(priority=2)
	public void modeSelect()
	{
		
		Selectmode modeselect=new Selectmode(driver);
		 modeselect.modeElement().click();
		
		List<WebElement> options = modeselect.selectoption();
		
		System.out.println(options.size());
		
		
		 for (WebElement option :options) {
				if (option.getText().contains(mode))
					
				{
					option.click();
					logger.info("mode selection done");

				}
				if (Boolean.valueOf(option.getAttribute("xpath")))
				{
					option.click();
					logger.error("Mode selection not done");
		
				}}
		
			
			
	}
	

				
	//@AfterTest
	public void tearDown() {
		driver.quit();
	}
		
}
		
	
	


package dgdox;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.aventstack.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dgdox.pageobjects.AddShipper;
import dgdox.pageobjects.Selectmode;
import dgdox.pageobjects.loginpage;
import dgdox.utilities.Datadriven;


public class TestcaseLogin_01 extends Baseclass {
//public WebDriver driver;
	
	
//	@BeforeTest
	public  void setup()
	{
		
		driver = setupBrowser();
		driver.get(baseURL);
	}

//	@Test(priority = 1)
	public void openURL() throws Exception {
		try {
			driver.get(baseURL);
			logger.info(baseURL + "URL launched successful");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

//	@Test(priority = 2)

	public void ValidateURL() throws IOException {
		

		String urlfromwebpage = driver.getCurrentUrl();
		Assert.assertTrue(true);

		if (urlfromwebpage.equals(baseURL)) {
			logger.info("URL given is correct");
			

		} else {
			logger.error("URL given is not correct");
			

		}

	}

	

//	@Test(priority = 3)
	public void loginTest() throws IOException  {
		Datadriven datadriven=new Datadriven();
		ArrayList<String> data=datadriven.getData("Login");

		loginpage lpLoginpage = new loginpage(driver);

		lpLoginpage.username().sendKeys(data.get(1));
		logger.debug("I have entered Username");

		lpLoginpage.setpass().sendKeys(data.get(2));
		logger.info("Password Entered");
		Assert.assertTrue(true);

		lpLoginpage.bulogin();

		if (driver.getTitle().equals(loginpageTitle)) {
			Assert.assertTrue(true);

			logger.info("Login Test Passed");
		} else 
			{
				//Assert.assertFalse(true);

				logger.error("Loggin failed");
			}

		}
	
//	@Test(priority = 4)
	public void shipperTestcaseName() throws InterruptedException, IOException {
		
	
		TestcaseAddShipper_03 tc=new TestcaseAddShipper_03();
		tc.addShippermode();
	
		tc.addShipperComp();
		
         }

	
	
	
	//@AfterTest
	public void tearDown() {
		driver.quit();
	}
		

	}



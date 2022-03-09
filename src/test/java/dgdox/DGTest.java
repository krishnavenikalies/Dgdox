package dgdox;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dgdox.pageobjects.loginpage;
import dgdox.utilities.Datadriven;

public class DGTest extends Baseclass {

	
public  WebDriver driver;
	
	
	@BeforeTest
	public  void setup()
	{
		
		driver = setupBrowser();
		driver.get(baseURL);
	}
	
	
	
	@Test(priority=1)
	public void Login() throws IOException
	{
		TestcaseLogin_01 testcase=new TestcaseLogin_01();
		
		testcase.loginTest();
	}
	@Test(priority=2)
	public void mode()
	{
		TestcaseMode_02  mode_02=new TestcaseMode_02();
	    mode_02.modeSelect();
		
	}
	@Test(priority=3)
	public void addShiper() throws InterruptedException, IOException
	{
		TestcaseAddShipper_03 addShip=new TestcaseAddShipper_03();
		addShip.addShipperComp();
	}
	
	@Test(priority=4)
	public void addConsignee() throws InterruptedException, IOException
	{
		TestcaseAddShipper_03 addShip1=new TestcaseAddShipper_03();
		addShip1.addConsignee();
	}
	
	@Test(priority=5)
	public void AddShipment() throws InterruptedException, IOException
	{
		TestcaseAddShipper_03 addShip2=new TestcaseAddShipper_03();
		addShip2.AddShip();
	}
	
	@AfterTest
	public void tear()
	{
		driver.close();
	}
}



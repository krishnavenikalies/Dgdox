package dgdox;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
/*   Ideabytes Inc
     Project 3PLDgdox 
     Objective: Test Login .....
     Developed by: Krishnaveni
     Date: 
     Version: 1.0
     Revision history:  
*/
public class LoginTest {

	public static void main(String[] args) throws InterruptedException 
	{ // have a class  set up Driver(bowser type) return result
		// Browser open
		//Log activity ( logger class, or write your own logger)
	// array of screen shots[]
		
		WebDriverManager.firefoxdriver().setup();
		
		WebDriver driver = new FirefoxDriver();   
		// if !driver handle error condition else open page
		
		driver.get("https://3pl.dgdox.com/"); // avoid hard coding - always put in in aconstant file, or pass ias an arg, or read if from a config file
		
		System.out.println(driver.getTitle());

		String urlfromwebpage = driver.getCurrentUrl();

		// validation(open) of url error code if incorrect

		if (urlfromwebpage.equals("https://3pl.dgdox.com/")) {
			System.out.println("URL given is correct"); // Strings - put in a db Stringid, text En, test 

		} else {
			System.out.println("Url given is incorrect");
			//break;report error  halt;

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));// 30 constant

		driver.findElement(By.id("username")).sendKeys("KrishnaV9");

		driver.findElement(By.id("password")).sendKeys("Kveni@123");

		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='transMode_chosen']")).click();

		// Selection of mode

		List<WebElement> mode = driver.findElements(By.xpath("//ul[@class='chosen-results']/li"));
	int count=	driver.findElements(By.xpath("//ul[@class='chosen-results']/li")).size();
		
		System.out.println(count);

		for (WebElement option : mode) {
			if (option.getText().contains("IATA (Air)"))
				
			{
				option.click();

			}
			if (Boolean.valueOf(option.getAttribute("xpath")))
				option.click();
		}

		Thread.sleep(3000); // constant 3000
		driver.findElement(By.xpath("//a[@id='shipper_temp']//i[@title='Add']")).click();

		// Adding Shipper Details

		Thread.sleep(2000);
		driver.findElement(By.id("shippingCompanyName_add_input")).sendKeys("Test12");
		Thread.sleep(2000);

		driver.findElement(By.id("address1_add")).sendKeys("234,sdsfdf");
		driver.findElement(By.id("unitNo_add")).sendKeys("2345");

		driver.findElement(By.id("city_add")).sendKeys("Northyork");

		driver.findElement(By.xpath(
				"//span[@aria-labelledby='select2-selectCountry_add-container']//span[@class='select2-selection__arrow']"))
				.click();

		List<WebElement> Shipcountry = driver
				.findElements(By.xpath("//ul[@id='select2-selectCountry_add-results']//li"));//42
		int count1=Shipcountry.size();
		System.out.println(count1);

		for (WebElement opt : Shipcountry) {
			// llop through all the contries and see if it is in the drop down
			// 
			if (opt.getText().contains("CANADA"))
			
			{
				opt.click();

			}
		}
		Thread.sleep(3000);

		driver.findElement(By.xpath(
				"//span[@aria-labelledby='select2-selectState_add-container']/span[@class='select2-selection__arrow']"))
				.click();

		List<WebElement> state = driver.findElements(By.xpath("//ul[@id='select2-selectState_add-results']//li"));

		for (WebElement opt1 : state) {
			if (opt1.getText().contains("Ontario"))
				;
			{
				opt1.click();

			}
		}

		driver.findElement(By.id("zipCode_add")).sendKeys("M2J0E8");
		driver.findElement(By.id("emailAddEdit_add")).sendKeys("abcd@gmail.com");
		driver.findElement(By.xpath("//button[@class='btn btn-primary-add submitType']")).click();

		// Validating string name

		String shippername = driver.findElement(By.xpath("//div[@id='shipper_chosen']//span")).getText();

		if (shippername.equals("Test12, Central Depot")) {
			System.out.println("shippername checked");
		}
		else {
			{
				System.out.println("mismatch");
			}
		}

		Thread.sleep(2000);

		// Add Consignee Details

		/*driver.findElement(By.xpath("//a[@id='consignee_temp']//i[@title='Add']")).click();
		driver.findElement(By.name("shippingCompanyName_add1_input")).sendKeys("krishnaTester");

		driver.findElement(By.xpath("//input[@id='address1_add1']")).sendKeys("123,krish street");
		driver.findElement(By.xpath("//input[@id='unitNo_add1']")).sendKeys("1234");
		driver.findElement(By.xpath("//input[@id='city_add1']")).sendKeys("NorthYork");

		// driver.findElement(By.xpath("//input[@id='zipCode_add1']")).sendKeys("123veni@abc.com");
		driver.findElement(By.xpath("//input[@id='zipCode_add1']")).sendKeys("625001");

		driver.findElement(By.xpath(
				"//span[@aria-labelledby='select2-selectCountry_add1-container']//span[@class='select2-selection__arrow']"))
				.click();

		List<WebElement> option2 = driver
				.findElements(By.xpath("//ul[@id='select2-selectCountry_add1-results']/li[111]"));

		for (WebElement country : option2) {
			if (country.getText().contains("INDIA"))
				
			{
				country.click();

			}
		}
		Thread.sleep(3000);

		driver.findElement(By.xpath(
				"//span[@aria-labelledby='select2-selectState_add1-container']/span[@class='select2-selection__arrow']"))
				.click();

		List<WebElement> state1 = driver.findElements(By.xpath("//ul[@id='select2-selectState_add1-results']/li[31]"));

		for (WebElement opt2 : state1) {
			if (opt2.getText().contains("Tamil Nadu"))
				
			{
				opt2.click();
// country is visible in the box
			}
		}

		driver.findElement(By.xpath("//button[@class='btn btn-primary-add submitType']")).click();

		driver.close();*/

	}
}
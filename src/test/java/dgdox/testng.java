package dgdox;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testng {

	WebDriver driver;

	@BeforeSuite
	public void OpenBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://3pl.dgdox.com/");

		String urlfromwebpage = driver.getCurrentUrl();

		if (urlfromwebpage.equals("https://3pl.dgdox.com/")) {
			System.out.println("Url given is correct");

		} else {
			System.out.println("Url given is incorrect");
		}
	}

	@AfterSuite
	private void quit() throws InterruptedException {
		Thread.sleep(2000);
		// TODO Auto-generated method stub
		driver.close();
	}

	@Parameters({ "user", "pass" })
	@Test(priority = 1)
	public void Details(String uservalue, String Passvalue) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.id("username")).sendKeys(uservalue);

		driver.findElement(By.id("password")).sendKeys(Passvalue);

		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='transMode_chosen']")).click();

		List<WebElement> mode = driver.findElements(By.xpath("//ul[@class='chosen-results']/li[2]"));

		for (WebElement option : mode) {
			if (option.getText().contains("IATA (Air)"))
				
			{
				option.click();

			}
			if (Boolean.valueOf(option.getAttribute("xpath")))
				option.click();
		}

		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='shipper_temp']//i[@title='Add']")).click();

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
				.findElements(By.xpath("//ul[@id='select2-selectCountry_add-results']//li[42]"));

		for (WebElement opt : Shipcountry) {
			if (opt.getText().contains("CANADA)"))
				;
			{
				opt.click();

			}
		}
		Thread.sleep(3000);

		driver.findElement(By.xpath(
				"//span[@aria-labelledby='select2-selectState_add-container']/span[@class='select2-selection__arrow']"))
				.click();

		List<WebElement> state = driver.findElements(By.xpath("//ul[@id='select2-selectState_add-results']//li[12]"));

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
		Assert.assertEquals(shippername, "Test12, Central Depot");

		/*
		 * if(shippername.equals("Test12, Central Depot")) {
		 * System.out.println("shippername checked"); }
		 */

		Thread.sleep(3000);
	}

}

package dgdox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class consigneeDetails extends testng {

	@Test(dependsOnMethods = { "Details" })
	public void consignee() throws InterruptedException {
		driver.findElement(By.xpath("//a[@id='consignee_temp']//i[@title='Add']")).click();
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

			}
		}

		driver.findElement(By.xpath("//button[@class='btn btn-primary-add submitType']")).click();

	}

}

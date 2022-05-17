package dgdox;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practice5 {
	
	@Test
	public void setup() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.cssSelector("input[value='radio1']")).click();
		
		WebElement element=driver.findElement(By.id("autocomplete"));
		element.sendKeys("india");
		
		element.sendKeys(Keys.ARROW_DOWN);
		element.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		Select dropSelect=new Select(driver.findElement(By.id("dropdown-class-example")));
		dropSelect.selectByVisibleText("Option2");
		
		driver.close();
		
	}

}

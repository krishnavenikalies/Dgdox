package dgdox.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

public class Selectmode {
	private WebDriver driver;
	

	public Selectmode(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath ="//div[@id='transMode_chosen']" )
	WebElement modeClickElement;
	
		@FindBy(xpath="//ul[@class='chosen-results']/li")
	List<WebElement> select;
		
		@FindBy(xpath="//a[@id='shipper_temp']//i[@title='Add']")
	
		WebElement addElement;

		
		
	public List<WebElement> selectoption()
	{
		select.size();
		return select;
	}


	public WebElement modeElement() {
		// TODO Auto-generated method stub
		return modeClickElement;
			
			
	}
	
	public WebElement Add()
	{
		return addElement;
	}
}

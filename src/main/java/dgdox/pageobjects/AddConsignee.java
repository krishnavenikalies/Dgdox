package dgdox.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class AddConsignee {
	
private WebDriver driver;
	

	public AddConsignee(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//a[@id='consignee_temp']//i[@title='Add']")
	WebElement addCon;
	@FindBy(name="shippingCompanyName_add1_input")
	WebElement namElement;
	@FindBy(xpath="//input[@id='address1_add1']")
	WebElement addressElement;
	@FindBy(xpath="//input[@id='unitNo_add1']")
	WebElement uniElement;
	@FindBy(xpath="//input[@id='city_add1']")
	WebElement cityElement;
	@FindBy(xpath="//input[@id='zipCode_add1']")
	WebElement zipcodElement;
	@FindBy(xpath="//span[@aria-labelledby='select2-selectCountry_add1-container']//span[@class='select2-selection__arrow']")
	WebElement selectCounElement;
	@FindBy(xpath="//ul[@id='select2-selectCountry_add1-results']//li[111]")//111
	List<WebElement> countryElements;
	
	@FindBy(xpath="//span[@aria-labelledby='select2-selectState_add1-container']/span[@class='select2-selection__arrow']")
	WebElement statElement;
	@FindBy(xpath="//ul[@id='select2-selectState_add1-results']//li[31]")
	List<WebElement> stateSelectElements;
	
	@FindBy(xpath="//button[@class='btn btn-primary-add submitType']")
	WebElement submitConsigneeElement;
	
	
	public WebElement AddCon()
	{
		return addCon;
	}
	public WebElement namElement()
	{
		return namElement;
	}
	
	public WebElement Address()
	{
		return addressElement;
	}
	public WebElement unit()
	{
		return uniElement;
	}
	public WebElement city()
	{
		return cityElement;
	}
	
	public WebElement Zip()
	{
		return zipcodElement;
	}
	
	public WebElement selectCoun()
	{
		return selectCounElement ;
	}
	
	public List<WebElement> Country()
	{
		return countryElements;
	}
	public WebElement state()
	{
	
	return statElement;
	}
	
	public List<WebElement> StateSelect()
	{
		return stateSelectElements;
	}
	
	public WebElement Addconsig()
	{
		return submitConsigneeElement;
	}
	

}

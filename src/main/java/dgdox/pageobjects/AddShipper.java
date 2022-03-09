package dgdox.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddShipper {
	
private WebDriver driver;
	

	public AddShipper(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="shippingCompanyName_add_input")
	WebElement shippingName;
	@FindBy(id="address1_add")
	WebElement address1;
	@FindBy(id="unitNo_add")
	WebElement unitNo;
	@FindBy(id="city_add")
	WebElement city;
	
	@FindBy(xpath="//span[@aria-labelledby='select2-selectCountry_add-container']//span[@class='select2-selection__arrow']")
	WebElement selectCountry;
	
	
	@FindBy(xpath="//ul[@id='select2-selectCountry_add-results']//li")//42
	List<WebElement> shipCountry;
	
	@FindBy(xpath="//span[@aria-labelledby='select2-selectState_add-container']/span[@class='select2-selection__arrow']")
	WebElement state;
	
	@FindBy(xpath="//ul[@id='select2-selectState_add-results']//li[12]")
	List<WebElement> stateElement;
	
	@FindBy(xpath="//button[@class='btn btn-primary-add submitType']")
	WebElement buttonAdd;
	

	@FindBy(id="zipCode_add")
	WebElement zipCode;
	
	@FindBy(id="shipper_chosen")
	WebElement shipvalidElement;
	
	
	@FindBy(xpath="//div[@id='shipper_chosen']//span")
	WebElement shipperNameElement;
	

	
	
	public WebElement shipperNameElement()
	{
		return shipperNameElement;
	}
	
	
	
		

	public WebElement shipCompany()
	{
		return shippingName;
	}
	
	
public WebElement addressElement()
{
	return address1;
	
}

public WebElement unitNo()
{
	return unitNo;
}
public WebElement City()
{
	return city;
}
public WebElement selectCountry()
{
	return selectCountry;
	
	
}

public WebElement state()
{
	return state;
}

public List<WebElement> Shipcountry()
{
	return shipCountry;
	
	
}

public List<WebElement> State()
{
	return stateElement;
	
	
}
public WebElement zipCode()
{
	return zipCode;
}

public WebElement AddClick()
{
	return buttonAdd;
}

public WebElement shipValid() {
	// TODO Auto-generated method stub
	return shipvalidElement;
}


}

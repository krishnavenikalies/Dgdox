package dgdox.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblLayoutType;

public class AddShipment {
private WebDriver driver;
	

	public AddShipment(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//button[@id='add_product_clone']")
	WebElement addClone;
	
	
	@FindBy(xpath="//input[@id='units_clone']")
	WebElement unitAddElement;
	
	@FindBy(id="total_net_pkg_wt")
	WebElement totalnet;
	@FindBy(className ="addShipment")
	WebElement addShipment;
	@FindBy(css="a[id='3pl_cpp_clone'] i[title='Add product']")
	WebElement addProductElement;
	
	@FindBy(id="commercial_name_input")
	WebElement commName;
	
	@FindBy(id="unnumber")
	WebElement unNum;
	
	//Selecting package group for UN1224
	@FindBy(id="pkg_group")
	WebElement pakagElement ;
	
	@FindBy(className="cpp_3pl_insert")
	WebElement addElement;
	@FindBy(id="only_cargo")
	WebElement cargoElement;
	
	@FindBy(id="passenger_and_cargo")
	WebElement passengerAndCargo;
	
	@FindBy(xpath="//div[@id='iata']//section[@class='col col-2']//label[@class='radio'][normalize-space()='Yes']//i")
	WebElement marinePollutant;
	
	@FindBy(xpath="//section[@class='col col-4 shiping_mode']//label[@class='radio spm_non_bulk'][normalize-space()='Non-Bulk']")
	WebElement shippingModElement;
	
	@FindBy(xpath="//section[@class='col col-2 combination_mode']//label[contains(@class,'radio')][normalize-space()='Yes']//i")
	
		WebElement combElement;
	
	@FindBy(xpath="//section[@class='col col-2 combination_mode']//label[@class='radio']//i")
	WebElement combElementNo;
	
	@FindBy(id="select2-inner_packing_type-container")
	WebElement packType;
	
	@FindBy(xpath="//ul[@id='select2-inner_packing_type-results']/li")
	List<WebElement> packTypElements;
	
	@FindBy(id="inner_pkg_wt")
	WebElement innpkgWgt;
	
	@FindBy(id="inner_pkg_units")
	WebElement units;
	@FindBy(id="select2-outer_packing_type-container")
	WebElement outPkgType;
	
	@FindBy(xpath="//ul[@id='select2-outer_packing_type-results']/li")
	List<WebElement> outType;
	
	@FindBy(id="outer_pkg_wt")
		WebElement outWgt;
	
	@FindBy(xpath="//button[@class='btn btn-primary-add cpp_3pl_insert']")
	WebElement addElement2;
	
	@FindBy(xpath="//a[@id='nos_add']//i[@title='Add']")
	WebElement NOS;
	
	@FindBy(xpath="//section[@class='col col-8']//label[@class='textarea']//input[@id='chemical_name_add']")
      WebElement chemicalName;
	
	
	
	@FindBy(xpath="//button[@id='add_nos_insert']")
	WebElement addChemicalElement;
	
	@FindBy(xpath="//input[@id='chemical_cas_add']")
	WebElement CAS;
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement savElement;
	
	@FindBy(xpath="//div[@id='iata_psn_pop_chosen']//span")
	WebElement selectPSN;
	
	
	@FindBy(xpath="//div[@id='iata_psn_pop_chosen']//ul[@class='chosen-results']/li")
	List<WebElement> selectPSNOptions;
	
	
	
	 @FindBy(xpath="//div[@class='modal-dialog']//button[2]")
	  WebElement addPSN; 
	
	@FindBy(xpath="//div[@role='dialog']//section[@class='col col-3 iata_viscous_substance']//label[1]//i[1]")
	WebElement viscousYesElement;
	
	@FindBy(xpath="//div[@role='dialog']//section[@class='col col-3 iata_viscous_substance']//label[2]//i[1]")
	WebElement viscousNoElement;
	
	@FindBy(xpath="//section[@class='col col-4 shiping_mode']//label[@class='radio spm_lq']//i")
	WebElement ShipmodeLQ;
	
	@FindBy(xpath="//label[@class='radio spm_eq']//i")
	WebElement ShipmodeEQ;
	
	public WebElement shipmodeEQ()
	{
		return ShipmodeEQ;
	}
	
	
	public WebElement shipmodeLQ()
	{
		return ShipmodeLQ;
	}
	
	public WebElement combNo()
	{
		return combElementNo;
	}
	
	
	
	
	public WebElement viscousNo()
	{
		return viscousNoElement;
	}
	
	public WebElement  addClone()
	{
		return addClone;
	}
	public WebElement unitAddElement()
	{
		return unitAddElement;
	}
	
	
	
	
	public WebElement viscousYes()
	{
		return viscousYesElement;
	}
	
	public WebElement addPSN()
	{
		return addPSN;
	}
	
	public List<WebElement> selectPSNOptions()
	{
		return selectPSNOptions;
	}
	public WebElement selectPSN()
	{
		return selectPSN;
	}
	
	public WebElement Save()
	{
		return savElement;
	}
	
	public WebElement CAS()
	{
		return CAS;
	}
	
	public WebElement addChemical()
	{
		return addChemicalElement;
	}
	
	
	
	
	
	public WebElement chemicalName()
	{
		return chemicalName;
	}
	public WebElement NOS()
	{
		return NOS;
	}
	
	public WebElement passengerAndCargo()
	{
		return passengerAndCargo;
	}
	
	public WebElement packagElement()
	{
		return pakagElement;
	}
	
	public WebElement TotalNet()
	{
		return totalnet;
	}
	
	public WebElement AdElement()
	{
		return addElement2;
	}
	public WebElement outWgt()
	{
		return outWgt;
	}
	
	
	
	
	public List<WebElement> outType()
	{
		return outType;
	}
	
	public WebElement outerType()
	{
		return outPkgType;
	}
	
	public WebElement units()
	{
		return units;
	}
	public WebElement innerPkg()
	{
		return innpkgWgt;
	}
	
	public List<WebElement> packTypeElements()
	{
		return packTypElements;
	}
	public WebElement packType()
	{
		return packType;
	}
	
	public WebElement Shippingmode()
	{
		return shippingModElement;
	}
	
	public WebElement combElement()
	{
		return combElement;
	}
	public WebElement marinePollutant()
	{
		return marinePollutant;
	}
	public WebElement cargo()
	{
		return cargoElement;
	}
	
	public WebElement addEle()
	{
		return addElement;
	}
	
	
	public WebElement addShipment()
	{
		return addShipment;
	}

	public WebElement addProduct()
	{
		return addProductElement;
	}
	public WebElement commName()
	{
		return commName;
	}
	public WebElement unNum()
	{
		return unNum;
	}
}

package dgdox;

import java.io.IOException;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import dgdox.pageobjects.AddShipment;
import dgdox.pageobjects.Selectmode;
import dgdox.pageobjects.loginpage;
import dgdox.utilities.Datadriven;
import dgdox.utilities.PropertiesFileReader;
import dgdox.utilities.TestUtils;

public class conditional extends Baseclass {

	public static Properties elementProperties = null;

	static {
		elementProperties = PropertiesFileReader.getData("config.properties");

	}

	public AddShipment addShipment;

	public WebDriver driver;

	@BeforeTest
	public void setup() {
		driver = setupBrowser();
		driver.get(baseURL);
	}

	@Test(priority = 1)
	public void addShippermode() throws InterruptedException, IOException {

		loginpage lpLoginpage = new loginpage(driver);

		lpLoginpage.username().sendKeys(elementProperties.getProperty("userName"));
		logger.debug("I have entered Username");

		lpLoginpage.setpass().sendKeys(elementProperties.getProperty("password"));
		logger.info("Password Entered");
		Assert.assertTrue(true);

		lpLoginpage.bulogin();

		if (driver.getTitle().equals(loginpageTitle)) {
			Assert.assertTrue(true);

			logger.info("Login Test Passed");
		} else {
			// Assert.assertFalse(true);

			logger.error("Loggin failed");
		}

		Selectmode modeselect = new Selectmode(driver);
		modeselect.modeElement().click();

		List<WebElement> options = modeselect.selectoption();

		System.out.println(options.size());

		for (WebElement option : options) {
			if (option.getText().contains(elementProperties.getProperty("mode")))

			{
				option.click();
				logger.info("mode selection done");

			}
			if (Boolean.valueOf(option.getAttribute("xpath"))) {
				option.click();
				logger.error("mode cannot be found");

			}
		}
	}

	@Test(priority = 2)
	public void AddShipment() {
		driver.findElement(By.id("shipper_chosen")).click();

		List<WebElement> shiperElements = driver
				.findElements(By.xpath("//div[@id='shipper_chosen']//ul[@class='chosen-results']/li"));

		for (WebElement ship : shiperElements) {

			if (ship.getText().equals("Testkrish, Central Depot")) {
				ship.click();
			}

		}

	}

	@Test(priority = 3)
	public void AddConsignee() {
		driver.findElement(By.id("consignee_chosen")).click();

		List<WebElement> consigElements = driver
				.findElements(By.xpath("//div[@id='consignee_chosen']//ul[@class='chosen-results']/li"));
		for (WebElement consignee : consigElements) {
			System.out.println(consignee.getText());

			if (consignee.getText().equals("Testkrish1, Central Depot")) {
				consignee.click();
			}

		}

	}
	//data coming from excel for Data provider

	@DataProvider
	public Object[][] addUN() {

		Object[][] testUN = TestUtils.getTestData("UNIATA");
		return (testUN);

	}

	@Test(priority = 4, dataProvider = "addUN")
	public void AddShip(String UNNumber, String SelectPSN, String PkgGroup, String AircraftType, String MarinePollutant,
			String Viscous, String ShippingMode, String CombinationPkg, String NOS1, String NOS2, String InnerpkgType,
			String InnerWgt, String Units, String OuterType, String OuterWgt, String UnitAdd)
			throws InterruptedException, IOException {

		System.out.println(PkgGroup + AircraftType);

		addShipment = new AddShipment(driver);
		Thread.sleep(3000);
		addShipment.addShipment().click();
		WebElement element = addShipment.addProduct();
		logger.debug("Clicked Add Product");
		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

		addShipment.unNum().sendKeys(UNNumber);
		logger.debug("Entered UN Number");

		
		addShipment.unNum().sendKeys(Keys.ENTER);
		selectPSN(UNNumber, SelectPSN);
		

		selectPackGroup(PkgGroup);
		Thread.sleep(1000);

		AircraftType(AircraftType);
		marine(MarinePollutant);

		viscous(UNNumber, Viscous);
		Thread.sleep(1000);

		shipMode(ShippingMode);
		NOS(NOS1, NOS2, UNNumber);
		Thread.sleep(1000);

		combinationPkg(CombinationPkg);

		addShipment.packType().click();
		logger.debug("Inner package clicked");
		innerPackageSelect(InnerpkgType);
		innerWgt(InnerWgt);
		innerUnit(Units);

		addShipment.outerType().click();
		logger.info("OuterType clicked");

		outerPackageSelect(OuterType);
		// validateNetQuantity();
		addShipment.outWgt().sendKeys(OuterWgt);
		logger.debug("outer weight sent");
		addShipment.AdElement().click();
		logger.info("All Elements Added");
		Thread.sleep(1000);
		addShipment.unitAddElement().sendKeys(UnitAdd);
		logger.info("Units Clone Added");
		addShipment.addClone().click();
		logger.info("Shipment Added");
		Thread.sleep(1000);

	}

	public void marine(String MarinePollutant) {

		System.out.println(MarinePollutant);
		if (MarinePollutant.equals(elementProperties.getProperty("marineyes"))) {

			addShipment.marinePollutant().click();
			logger.debug("Marine pollutant selected");
		}
	}

	public void shipMode(String ShippingMode) {
		if (ShippingMode.equals("Non-Bulk")) {

			addShipment.Shippingmode().click();
			logger.debug("Non Bulk selected");
		}
		else if(ShippingMode.equals("EQ"))
		{
			addShipment.shipmodeEQ().click();
		}
		else {
			addShipment.shipmodeLQ().click();
		}
	}

	public void combinationPkg(String CombinationPkg) {

		if (CombinationPkg.equals(elementProperties.getProperty("combinationyes"))) {

			addShipment.combElement().click();

			logger.debug("Combination package clicked YES");
		}
		else {
			addShipment.combNo().click();
			logger.debug("Combination Package clicked No");
		}

	}

	public void viscous(String UNNumber, String Viscous) throws IOException {

		if (UNNumber.equals(elementProperties.getProperty("UN1207"))
				|| UNNumber.equals(elementProperties.getProperty("UN1212"))) {

			if (Viscous.equals(elementProperties.getProperty("viscousyes"))) {
				addShipment.viscousYes().click();
				logger.info("Viscous selected with yes Option");
				
				
			}
			else
				addShipment.viscousNo().click();
			
		}
	}

	public void validateNetQuantity() throws IOException {

		String innerPkgValue = addShipment.innerPkg().getAttribute("value");
		System.out.println(innerPkgValue);
		String unitsValue = addShipment.units().getAttribute("value");
		System.out.println(unitsValue);

		String allowedLimit = String.valueOf(Integer.parseInt(innerPkgValue) * Integer.parseInt(unitsValue));

		System.out.println("Allowed Limit" + allowedLimit);

		logger.info("Allowed Limit obtained");

		String totalString = addShipment.TotalNet().getAttribute("value");

		if (totalString.equals(allowedLimit)) {
			// Validation for NetQuantity

			logger.info("Total Net Quantity generated is correct");
			System.out.println("validation done");
		} else {
			logger.error("value mismatch");
		}
	}

	public void outerPackageSelect(String OuterType) throws IOException {

		try {

			List<WebElement> outerElements = addShipment.outType();
			for (WebElement outer : outerElements) {
				if (outer.getText().contains(OuterType)) {
					outer.click();
				}
			}
		} catch (StaleElementReferenceException e) {
			List<WebElement> outerElements = addShipment.outType();
			for (WebElement outer : outerElements) {
				if (outer.getText().contains(OuterType)) {
					outer.click();
				}
			}
		}

		logger.debug("Outer Package Type selected");
	}

	public void innerPackageSelect(String InnerpkgType) throws IOException {

		try {

			List<WebElement> innerPack = addShipment.packTypeElements();
			for (WebElement inner : innerPack) {
				if (inner.getText().contains(InnerpkgType)) {
					inner.click();
				}
			}

		} catch (StaleElementReferenceException e) {
			List<WebElement> innerPack = addShipment.packTypeElements();
			for (WebElement inner : innerPack) {
				if (inner.getText().contains(InnerpkgType)) {
					inner.click();
				}
			}

		}
		logger.debug("inner package selected");
	}

	public void NOS(String NOS1, String NOS2, String UNNumber) throws IOException {

		addShipment = new AddShipment(driver);
		if (UNNumber.equals(elementProperties.getProperty("UN1224"))) {

			addShipment.NOS().click();
			logger.info("NOS selected");
			for (int i = 0; i <= 1; i++) {
				if (i == 0) {
					addShipment.chemicalName().sendKeys(NOS1);
					addShipment.chemicalName().sendKeys(Keys.TAB);
					addShipment.CAS().sendKeys("15");

					addShipment.addChemical().click();
				} else {
					addShipment.chemicalName().sendKeys(NOS2);
					addShipment.chemicalName().sendKeys(Keys.TAB);
					addShipment.CAS().sendKeys("12");

					addShipment.addChemical().click();
				}
			}
			addShipment.Save().click();
		} else {
			logger.info("No NOS for this UNNumber");
		}
	}

	public void innerWgt(String InnerWgt) throws IOException {
		addShipment = new AddShipment(driver);

		addShipment.innerPkg().sendKeys(InnerWgt);

		logger.info("Inner package weight sent ");

	}

	public void innerUnit(String Units) {
		addShipment = new AddShipment(driver);

		addShipment.units().sendKeys(Units);

		logger.info("Inner unit sent ");
	}

	public void selectPackGroup(String PkgGroup) throws IOException {
		System.out.println("Package group" + PkgGroup);
		if (PkgGroup.equals("II")) {

			Select packageGroup = new Select(addShipment.packagElement());
			packageGroup.selectByValue(PkgGroup);
			logger.debug("Package group II selected ");
		}
	}

	public void AircraftType(String AircraftType) {
		System.out.println("AircraftType" + AircraftType);

		addShipment = new AddShipment(driver);
		if (AircraftType.equals(elementProperties.getProperty("Aircraft"))) {
			addShipment.cargo().click();
			logger.debug("cargo only clicked");
		} else {
			addShipment.passengerAndCargo().click();
			logger.debug("Passenger and cargo selected");
		}

	}

	public void selectPSN(String UNNumber, String SelectPSN) throws IOException, InterruptedException {

		if (UNNumber.equals(elementProperties.getProperty("UN1203"))) {

			addShipment.selectPSN().click();
			System.out.println("Clicked Select");

		List<WebElement> selectPSNOptionsElements = addShipment.selectPSNOptions();
			for (int i = 1; i < selectPSNOptionsElements.size(); i++) {
				System.out.println(selectPSNOptionsElements.get(i).getText());
				String selectPSNE = selectPSNOptionsElements.get(i).getText();
				if (selectPSNE.contains(SelectPSN))
					

				{
					System.out.println(SelectPSN);

					System.out.println(selectPSNE);
					selectPSNOptionsElements.get(i).click();
					logger.info("PSN Selected");
					break;
					
				}

			}
			//Thread.sleep(1000);
			addShipment.addPSN().click();
		}
			
		
	
		/*	List<WebElement> selectPSNOptionsElements = addShipment.selectPSNOptions();

			for (WebElement selectPSN : selectPSNOptionsElements) {
				//System.out.println(SelectPSN);
				if (selectPSN.getText().contains(SelectPSN)) {
					System.out.println(selectPSN.getText());
					

					selectPSN.click();
					logger.info("PSN Selected");
				}

			}

          
			Thread.sleep(1000); 

			addShipment.addPSN().click();
			logger.info("Added PSN");

		}*/
		
		else if (UNNumber.equals(elementProperties.getProperty("UN1212"))) {

			addShipment.selectPSN().click();

			List<WebElement> selectPSNOptionsElements = addShipment.selectPSNOptions();

			for (WebElement selectPSN : selectPSNOptionsElements) {
				//System.out.println(SelectPSN);
				if (selectPSN.getText().contains(SelectPSN)) {
					System.out.println(selectPSN.getText());
					

					selectPSN.click();
					logger.info("PSN Selected");
					break;
				}

			}

          
			Thread.sleep(1000); 

			addShipment.addPSN().click();
			logger.info("Added PSN");

		}
	}

	@AfterTest
	public void tear() {
		driver.close();
	}

}

package dgdox;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.bouncycastle.asn1.BEROctetStringGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import dgdox.pageobjects.AddConsignee;
import dgdox.pageobjects.AddShipment;
import dgdox.pageobjects.AddShipper;
import dgdox.pageobjects.Selectmode;
import dgdox.pageobjects.loginpage;
import dgdox.utilities.Datadriven;
import dgdox.utilities.PropertiesFileReader;
import dgdox.utilities.TestUtils;

public class dataProvider extends Baseclass {
	public static Properties elementProperties = null;
	// public static Properties commonProperties = null;

	static {
		elementProperties = PropertiesFileReader.getData("config.properties");
		// commonProperties = PropertiesFileReader.getData("common.properties");
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

	@DataProvider
	public Object[][] driveTest() throws InvalidFormatException {

		Object[][] testObjects = TestUtils.getTestData("AddShipment");
		return (testObjects);

	}

	@Test(priority = 2, dataProvider = "driveTest")

	public void addShipperComp(String ShipperName, String Address, String Unit, String City, String Country,
			String State, String Zipcode, String Validate) throws InterruptedException, IOException {

		System.out.println("Add Shipment Method");

		System.out.println(ShipperName + Address);
		Thread.sleep(1000);
		Selectmode modeselect = new Selectmode(driver);
		modeselect.Add().click();
		Thread.sleep(1000);

		AddShipper addShipper = new AddShipper(driver);

		logger.info("Entering all shipper Details");
		addShipper.shipCompany().sendKeys(ShipperName);
		addShipper.addressElement().sendKeys(Address);

		addShipper.unitNo().sendKeys(Unit);
		addShipper.City().sendKeys(City);
		addShipper.selectCountry().click();
		Thread.sleep(1000);

		try {
			List<WebElement> shipCountry = addShipper.Shipcountry();
			for (WebElement country : shipCountry) {

				if (country.getText().contains(Country))

				{
					country.click();

				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		addShipper.state().click();

		List<WebElement> stateSelect = addShipper.State();
		for (WebElement state : stateSelect) {

			if (state.getText().contains(State))

			{
				state.click();

			}
		}
		addShipper.zipCode().sendKeys(Zipcode);
		addShipper.AddClick().click();
		addShipper.AddClick().click();
		Thread.sleep(1000);
		String shippername = addShipper.shipperNameElement().getText();
		logger.info("Shippername validated");
		Assert.assertEquals(shippername, Validate);
	}

	@DataProvider
	public Object[][] addConsignee() throws InvalidFormatException {

		Object[][] testConsignee = TestUtils.getTestData("AddConsignee");
		return (testConsignee);

	}

	@Test(priority = 3, dataProvider = "addConsignee")
	public void addConsignee(String ConsigneeName, String Address, String Unit, String City, String Country,
			String State, String Zipcode) throws InterruptedException, IOException {

		AddConsignee addConsignee = new AddConsignee(driver);
		addConsignee.AddCon().click();
		addConsignee.namElement().sendKeys(ConsigneeName);
		Thread.sleep(1000);
		try {
			addConsignee.Address().sendKeys(Address);
			logger.info("Address entered");
		} catch (Exception e) {
			addConsignee.Address().sendKeys(Address);
		}

		addConsignee.unit().sendKeys(Unit);
		addConsignee.city().sendKeys(City);
		addConsignee.Zip().sendKeys(Zipcode);
		Thread.sleep(20);

		addConsignee.selectCoun().click();
		Thread.sleep(1000);
		try {
			List<WebElement> countryElements = addConsignee.Country();

			for (WebElement countryCons : countryElements) {
				if (countryCons.getText().contains(Country))

				{
					countryCons.click();

				}
			}
		} catch (StaleElementReferenceException e) {
			List<WebElement> countryElements = addConsignee.Country();

			for (WebElement countryCons : countryElements) {
				if (countryCons.getText().contains(Country))

				{
					countryCons.click();

				}
			}
		}

		addConsignee.state().click();
		Thread.sleep(1000);
		try {

			List<WebElement> statElement = addConsignee.StateSelect();
			for (WebElement stateEle : statElement) {
				if (stateEle.getText().contains(State))

				{
					stateEle.click();

				}
			}
		} catch (StaleElementReferenceException e) {
			List<WebElement> statElement = addConsignee.StateSelect();
			for (WebElement stateEle : statElement) {
				if (stateEle.getText().contains(State))

				{
					stateEle.click();

				}

			}
		}

		addConsignee.Addconsig().click();
		logger.info("Details Entered");
	}

	
	
	
	@DataProvider
	public Object[][] addUN() throws InvalidFormatException {

		Object[][] testUN = TestUtils.getTestData("UNIATA");
		return (testUN);

	}


	@Test(priority = 4, dataProvider = "addUN")
	public void AddShip(String UNNumber, String PkgGroup, String AircraftType, String MarinePollutant,
			String ShippingMode, String CombinationPkg, String NOS1, String NOS2, String InnerpkgType, String InnerWgt,
			String Units, String OuterType, String OuterWgt) throws InterruptedException, IOException {

		// System.out.println(PkgGroup + AircraftType);

		addShipment = new AddShipment(driver);
		addShipment.addShipment().click();
		WebElement element = addShipment.addProduct();
		logger.debug("Clicked Add Product");
		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

		addShipment.unNum().sendKeys(UNNumber);
		logger.debug("Entered UN Number");

		selectPSN(UNNumber);
		addShipment.unNum().sendKeys(Keys.ENTER);
		// Thread.sleep(1000);

		selectPackGroup(PkgGroup);

		AircraftType(AircraftType);
		marine(MarinePollutant);

		viscous(UNNumber);

		shipMode(ShippingMode);
		NOS(NOS1, NOS2);

		combinationPkg(CombinationPkg);

		addShipment.packType().click();
		logger.debug("Inner package clicked");
		innerPackageSelect(InnerpkgType);
		innerWgt(InnerWgt);
		innerUnit(Units);

		addShipment.outerType().click();
		logger.info("OuterType clicked");
		Thread.sleep(1000);
		outerPackageSelect(OuterType);
		// validateNetQuantity();
		addShipment.outWgt().sendKeys(OuterWgt);
		logger.debug("outer weight sent");
		addShipment.AdElement().click();
		logger.info("All Elements Added");

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
	}

	public void combinationPkg(String CombinationPkg) {

		if (CombinationPkg.equals(elementProperties.getProperty("combinationyes"))) {

			addShipment.combElement().click();

			logger.debug("Combination package clicked YES");
		}

	}

	public void viscous(String UNNumber) throws IOException {

		if (UNNumber.equals(elementProperties.getProperty("UN1207")) || (UNNumber.equals(elementProperties.getProperty("UN1212")))) {
			addShipment.viscousYes().click();
			logger.info("Viscous selected with yes Option");
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

	public void NOS(String NOS1, String NOS2) throws IOException {

		addShipment = new AddShipment(driver);

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
	}

	public void innerWgt(String InnerWgt) throws IOException {

		addShipment.innerPkg().sendKeys(InnerWgt);

		logger.info("Inner package weight sent ");

	}

	public void innerUnit(String Units) {
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

	public void selectPSN( String UNNumber) throws IOException {

		if (UNNumber.equals(elementProperties.getProperty("UN1203"))) {

			addShipment.selectPSN().click();

			List<WebElement> selectPSNOptionsElements = addShipment.selectPSNOptions();

			for (WebElement selectPSN : selectPSNOptionsElements) {
				if (selectPSN.getText().equals("Motor spirit")) {
					selectPSN.click();
					logger.info("PSN Selected");
				}

			}
			addShipment.addPSN().click();
		} else if (UNNumber.equals(elementProperties.getProperty("UN1212"))) {
			addShipment.selectPSN().click();

			List<WebElement> selectPSNOptionsElements = addShipment.selectPSNOptions();

			for (WebElement selectPSN : selectPSNOptionsElements) {

				if (selectPSN.getText().equals("Isobutanol")) {
					selectPSN.click();
					logger.info("PSN Selected for UN1212");
				}
			}
			addShipment.addPSN().click();
		}
	}

}


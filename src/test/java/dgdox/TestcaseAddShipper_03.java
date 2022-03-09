package dgdox;

import java.io.IOException;
import java.security.PublicKey;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.spi.TransactionalWriter;

import org.apache.logging.log4j.message.Message;
import org.bouncycastle.asn1.dvcs.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import dgdox.pageobjects.AddConsignee;
import dgdox.pageobjects.AddShipment;
import dgdox.pageobjects.AddShipper;
import dgdox.pageobjects.Selectmode;
import dgdox.pageobjects.loginpage;
import dgdox.utilities.Datadriven;
import lombok.experimental.var;

public class TestcaseAddShipper_03 extends Baseclass {
	public AddShipment addShipment;
	public Datadriven datadriven;
	// public WebDriver driver;

//	@BeforeTest
	public void setup() {
		driver = setupBrowser();
		driver.get(baseURL);
	}

//    @Test(priority=1)
	public void addShippermode() throws InterruptedException, IOException {
		datadriven = new Datadriven();

		ArrayList<String> data = datadriven.getData("Login");

		loginpage lpLoginpage = new loginpage(driver);

		lpLoginpage.username().sendKeys(data.get(1));
		logger.debug("I have entered Username");

		lpLoginpage.setpass().sendKeys(data.get(2));
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
			if (option.getText().contains(mode))

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

	// @Test(priority=2)
	public void addShipperComp() throws InterruptedException, IOException {

		// System.out.println(data1);
		Selectmode modeselect = new Selectmode(driver);
		modeselect.Add().click();
		Thread.sleep(1000);

		AddShipper addShipper = new AddShipper(driver);
		datadriven = new Datadriven();
		ArrayList<String> data1 = datadriven.getData("AddShipper");
		System.out.println(data1);
		logger.info("Entering all shipper Details");
		addShipper.shipCompany().sendKeys(data1.get(1));
		addShipper.addressElement().sendKeys(data1.get(2));

		addShipper.unitNo().sendKeys(data1.get(3));
		addShipper.City().sendKeys(data1.get(4));
		addShipper.selectCountry().click();
		Thread.sleep(1000);

		try {
			List<WebElement> shipCountry = addShipper.Shipcountry();
			for (WebElement country : shipCountry) {

				if (country.getText().contains(data1.get(5)))

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

			if (state.getText().contains(data1.get(6)))

			{
				state.click();

			}
		}
		addShipper.zipCode().sendKeys(data1.get(7));
		addShipper.AddClick().click();
		addShipper.AddClick().click();
		Thread.sleep(1000);
		String shippername = addShipper.shipperNameElement().getText();
		logger.info("Shippername validated");
		Assert.assertEquals(shippername, data1.get(8));
	}

	 @Test(priority=3)
	public void addConsignee() throws InterruptedException, IOException {

		Datadriven datadriven = new Datadriven();
		ArrayList<String> data1 = datadriven.getData("AddConsignee");

		AddConsignee addConsignee = new AddConsignee(driver);
		addConsignee.AddCon().click();
		addConsignee.namElement().sendKeys(data1.get(1));
		Thread.sleep(1000);
		try {
			addConsignee.Address().sendKeys(data1.get(2));
			logger.info("Address entered");
		} catch (Exception e) {
			addConsignee.Address().sendKeys(data1.get(2));
		}

		addConsignee.unit().sendKeys(data1.get(3));
		addConsignee.city().sendKeys(data1.get(4));
		addConsignee.Zip().sendKeys(data1.get(7));
		Thread.sleep(20);

		addConsignee.selectCoun().click();
		Thread.sleep(1000);
		try {
			List<WebElement> countryElements = addConsignee.Country();

			for (WebElement countryCons : countryElements) {
				if (countryCons.getText().contains(data1.get(5)))

				{
					countryCons.click();

				}
			}
		} catch (StaleElementReferenceException e) {
			List<WebElement> countryElements = addConsignee.Country();

			for (WebElement countryCons : countryElements) {
				if (countryCons.getText().contains(data1.get(5)))

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
				if (stateEle.getText().contains(data1.get(6)))

				{
					stateEle.click();

				}
			}
		} catch (StaleElementReferenceException e) {
			List<WebElement> statElement = addConsignee.StateSelect();
			for (WebElement stateEle : statElement) {
				if (stateEle.getText().contains(data1.get(6)))

				{
					stateEle.click();

				}

			}
		}

		addConsignee.Addconsig().click();
		logger.info("Details Entered");
	}

	 @Test(priority=4)
	public void AddShip() throws InterruptedException, IOException {

		datadriven = new Datadriven();
		ArrayList<String> data1 = datadriven.getData("AddShipment");

		addShipment = new AddShipment(driver);
		addShipment.addShipment().click();
		WebElement element = addShipment.addProduct();
		logger.debug("Clicked Add Product");
		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

		addShipment.commName().sendKeys(data1.get(1));
		logger.info("Entered Commercial Name");
		UNNumber();

		addShipment.addEle().click();
	//	logger.debug("Add Button clicked");
		selectPSN();

	/*	selectPackGroup();

		AircraftType();

		addShipment.marinePollutant().click();
		logger.debug("Marine pollutant selected");

		viscous();

		addShipment.Shippingmode().click();
		logger.debug("Non Bulk selected");
		NOS();

		addShipment.combElement().click();

		logger.debug("Combination package clicked YES");

		addShipment.packType().click();
		logger.debug("Inner package clicked");
		innerPackageSelect();
		innerWgt();

		addShipment.outerType().click();
		logger.info("OuterType clicked");
		Thread.sleep(1000);
		outerPackageSelect();
		validateNetQuantity();
		addShipment.outWgt().sendKeys(data1.get(7));
		logger.debug("outer weight sent");
		addShipment.AdElement().click();
		logger.info("All Elements Added");

	}

	public void UNNumber() throws IOException {
		datadriven = new Datadriven();
		ArrayList<String> data1 = datadriven.getData("AddShipment");
		if (data1.get(2).equals(UNNumber)) {
			addShipment.unNum().sendKeys(data1.get(2));
			logger.debug("Entered UN Number");
		}
	}

	public void viscous() throws IOException {
		datadriven = new Datadriven();
		ArrayList<String> data1 = datadriven.getData("AddShipment");

		if (data1.get(2).equals(UN1207) || data1.get(2).equals(UN1212)) {
			addShipment.viscousYes().click();
			logger.info("Viscous selected with yes Option");
		}
	}

	public void validateNetQuantity() throws IOException {
		datadriven = new Datadriven();
		ArrayList<String> data1 = datadriven.getData("AddShipment");

		if (data1.get(2).equals(UNNumber)) {

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

	}

	public void outerPackageSelect() throws IOException {
		datadriven = new Datadriven();
		ArrayList<String> data1 = datadriven.getData("AddShipment");

		try {

			List<WebElement> outerElements = addShipment.outType();
			for (WebElement outer : outerElements) {
				if (outer.getText().contains(data1.get(6))) {
					outer.click();
				}
			}
		} catch (StaleElementReferenceException e) {
			List<WebElement> outerElements = addShipment.outType();
			for (WebElement outer : outerElements) {
				if (outer.getText().contains(data1.get(6))) {
					outer.click();
				}
			}
		}

		logger.debug("Outer Package Type selected");
	}

	public void innerPackageSelect() throws IOException {
		datadriven = new Datadriven();
		ArrayList<String> data1 = datadriven.getData("AddShipment");

		try {

			List<WebElement> innerPack = addShipment.packTypeElements();
			for (WebElement inner : innerPack) {
				if (inner.getText().contains(data1.get(3))) {
					inner.click();
				}
			}

		} catch (StaleElementReferenceException e) {
			List<WebElement> innerPack = addShipment.packTypeElements();
			for (WebElement inner : innerPack) {
				if (inner.getText().contains(data1.get(3))) {
					inner.click();
				}
			}

		}
		logger.debug("inner package selected");
	}

	public void NOS() throws IOException {
		datadriven = new Datadriven();
		ArrayList<String> data1 = datadriven.getData("AddShipment");

		addShipment = new AddShipment(driver);

	//	if (data1.get(2).equals(UN1224)) {

			addShipment.NOS().click();
			logger.info("NOS selected");
			for (int i = 0; i <= 1; i++) {
				if (i == 0) {
					addShipment.chemicalName().sendKeys("Ketones");
					addShipment.chemicalName().sendKeys(Keys.TAB);
					addShipment.CAS().sendKeys("15");

					addShipment.addChemical().click();
				} else {
					addShipment.chemicalName().sendKeys("Nitric Acid");
					addShipment.chemicalName().sendKeys(Keys.TAB);
					addShipment.CAS().sendKeys("12");

					addShipment.addChemical().click();
				}
			}
			addShipment.Save().click();
		//}
	}

	public void innerWgt() throws IOException {
		datadriven = new Datadriven();
		ArrayList<String> data1 = datadriven.getData("AddShipment");
		if (data1.get(2).equals(UN1204)) {
			addShipment.innerPkg().sendKeys(data1.get(4));

			logger.info("Inner package weight sent with Maximum Quantity 1L");
			addShipment.units().sendKeys(data1.get(5));

			logger.info("Inner unit sent is less than or equal to 1L");

		} else {

			addShipment.innerPkg().sendKeys(data1.get(4));

			logger.info("Inner package weight sent");

			addShipment.units().sendKeys(data1.get(5));

			logger.info("Inner unit sent");
		}
	}

	public void selectPackGroup() throws IOException {
	//	datadriven = new Datadriven();
		//ArrayList<String> data1 = datadriven.getData("AddShipment");
		//if (data1.get(2).equals(UN1224)) {
			logger.info("Entered UN Number : 1224");
			Select packageGroup = new Select(addShipment.packagElement());
			packageGroup.selectByValue("II");
			logger.debug("Package group II selected ");
	//	}
	}

	public void AircraftType() {
		addShipment = new AddShipment(driver);
	//	if (Aircraft.equals("Cargo Only")) {
			addShipment.cargo().click();
			logger.debug("cargo only clicked");
		} else {
			addShipment.passengerAndCargo().click();
			logger.debug("Passenger and cargo selected");
		}

	}

	public void selectPSN() throws IOException {
		datadriven = new Datadriven();
		ArrayList<String> data1 = datadriven.getData("AddShipment");
		if (data1.get(2).equals(UN1203)) {

			addShipment.selectPSN().click();

			List<WebElement> selectPSNOptionsElements = addShipment.selectPSNOptions();

			for (WebElement selectPSN : selectPSNOptionsElements) {
				if (selectPSN.getText().equals("Motor spirit")) {
					selectPSN.click();
					logger.info("PSN Selected");
				}

			}
			addShipment.addPSN().click();
		} else if (data1.get(2).equals(UN1212)) {
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
	}*/

	@AfterTest
	public void tear() {
		driver.close();
	}
}

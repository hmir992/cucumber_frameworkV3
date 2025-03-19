package pages;

import helper.SeleniumUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseDriverClass;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AdjustBatchPageBackup extends BaseDriverClass {

	@FindBy(id = "item-type-field")
	@CacheLookup
	private WebElement itemTypeDropDown;

	@FindBy(id = "subtype-field")
	@CacheLookup
	private WebElement subTypeDropDown;

	@FindBy(xpath = "//*[@id='subtype-field']/div/div/div[2]")
	@CacheLookup
	private WebElement subTypeDropDown2;

	@FindBy(xpath = "//div[@ng-reflect-tooltip='CONTR - Contributions']")
	@CacheLookup
	private WebElement contrSubType;
	@FindBy(xpath = "//div[@ng-reflect-tooltip='ADJUST - Adjustment']")
	@CacheLookup
	private WebElement adjustItemType;

	@FindBy(xpath = "//button[@ng-reflect-klass='btn btn-primary btn-next btn-c']")
	@CacheLookup
	private WebElement nextButton;

	@FindBy(xpath = "//div[@data-field-label='Product']")
	@CacheLookup
	private WebElement productDropDown;
	@FindBy(xpath = "//input[@autocomplete='a5ea283f7589']")
	@CacheLookup
	private WebElement productDropDown2;

	@FindBy(xpath = "//ng-select[@class='xtrac-value-group field-control xtrac-field ng-select ng-select-single ng-select-searchable ng-pristine ng-valid ng-select-bottom ng-touched']")
	@CacheLookup
	private WebElement productDropDown3;


	@FindBy(xpath = "(//div[@class='ng-input'])[5]")
	@CacheLookup
	private WebElement productDropDown5;

	@FindBy(xpath = "/html/body/span/xwh-bootstrap/xwh-app/div/div/routing-work-item-create/div/xwi-create/form/div[3]/div/xwi-details-container/xwi-details/div/div[2]/div[1]/xwi-fields-sections/xwi-fields-section/div/div/xtrac-fields/div[1]/div[11]/xtrac-field/div/div[2]/xtrac-value-group-field/ng-select/div/div/div[2]")
	@CacheLookup
	private WebElement productDropDown6;

	@FindBy(xpath = "//label[contains(text(), 'Product')]")
	@CacheLookup
	private WebElement productDropDown10;

	@FindBy(xpath = "//span[contains(text(), 'DC')]")
	@CacheLookup
	private WebElement selectDCProduct;

	@FindBy(xpath = "//span[contains(text(), 'DB')]")
	@CacheLookup
	private WebElement selectDBProduct;

	@FindBy(xpath = "//span[contains(text(), 'HS')]")
	@CacheLookup
	private WebElement selectHSProduct;

	@FindBy(xpath = "//span[contains(text(), 'HW')]")
	@CacheLookup
	private WebElement selectHWProduct;

	@FindBy(xpath = "//span[contains(text(), 'MP')]")
	@CacheLookup
	private WebElement selectMPProduct;

	@FindBy(xpath = "//span[contains(text(), 'PR')]")
	@CacheLookup
	private WebElement selectPRProduct;

	@FindBy(xpath = "//span[contains(text(), 'RD')]")
	@CacheLookup
	private WebElement selectRDProduct;

	@FindBy(xpath = "//span[contains(text(), 'RE')]")
	@CacheLookup
	private WebElement selectREProduct;

	@FindBy(xpath = "//span[contains(text(), 'SL')]")
	@CacheLookup
	private WebElement selectSLProduct;

	@FindBy(xpath = "//span[contains(text(), 'SO')]")
	@CacheLookup
	private WebElement selectSOProduct;

	@FindBy(xpath = "//span[contains(text(), 'WG')]")
	@CacheLookup
	private WebElement selectWGProduct;


	@FindBy(xpath = "//span[contains(text(), 'Life')]")
	@CacheLookup
	private WebElement lifetest;

	@FindBy(xpath = "//span[contains(text(), 'Amend')]")
	@CacheLookup
	private WebElement amendTest;


	@FindBy(xpath = "//*[@class='ng-dropdown-panel-items scroll-host']")
	@CacheLookup
	private WebElement selectProductScrollBar;

	@FindBy(xpath = "//*[@class='ng-dropdown-panel-items scroll-host']")
	@CacheLookup
	private WebElement selectItemTypeSubTypeScrollBar;
	@FindBy(xpath = "(//div[@class='ng-input'])[2]")
	@CacheLookup
	private WebElement subtypeInputtest;



	//	(//*[@data-select-value='RD'])
					//(//*[@class='ng-dropdown-panel-items scroll-host'])
	@FindBy(xpath = "/html/body/span/xwh-bootstrap/xwh-app/div/div/routing-work-item-create/div/xwi-create/form/div[3]/div/xwi-details-container/xwi-details/div/div[2]/div[1]/xwi-fields-sections/xwi-fields-section/div/div/xtrac-fields/div[1]/div[10]/xtrac-field/div/div[2]/xtrac-character-field/input")
	@CacheLookup
	private WebElement planTextBox;

	@FindBy(xpath = "/html/body/span/xwh-bootstrap/xwh-app/div/div/routing-work-item-create/div/xwi-create/form/div[3]/div/xwi-details-container/xwi-details/div/div[2]/div[1]/xwi-fields-sections/xwi-fields-section/div/div/xtrac-fields/div[1]/div[8]/xtrac-field/div/div[2]/xtrac-customer-id-field/input")
	@CacheLookup
	private WebElement customerTextBox;

	@FindBy(xpath = "/html/body/span/xwh-bootstrap/xwh-app/div/div/routing-work-item-create/div/xwi-create/form/div[3]/div/xwi-details-container/xwi-details/div/div[2]/div[1]/xwi-fields-sections/xwi-fields-section/div/div/xtrac-fields/div[1]/div[14]/xtrac-field/div/div[2]/xtrac-character-field/input")
	@CacheLookup
	private WebElement clientTextBox;


	@FindBy(xpath = "//button[@class='btn prefill-r-button']")
	@CacheLookup
	private WebElement rButton;


	@FindBy(xpath = "//button[@class='btn btn-primary modal-confirm-btn']")
	@CacheLookup
	private WebElement afterPrefillPopUp;

	@FindBy(xpath = "//b[contains(text(), 'PLAN')]")
	@CacheLookup
	private WebElement partiesPlanLabel;

	@FindBy(xpath = "//b[contains(text(), 'CLNT')]")
	@CacheLookup
	private WebElement partiesClientLabel;

	@FindBy(xpath = "//label[contains(text(), 'Subtype')]")
	@CacheLookup
	private WebElement subTypeLabel;

	@FindBy(xpath = "/html/body/span/xwh-bootstrap/xwh-app/div/div/routing-work-item-create/div/xwi-create/form/div[3]/div/xwi-details-container/xwi-details/div/div[2]/div[4]/div/xwi-parties/div/xwi-party[3]/div/div[2]/xtrac-fields/div[1]/div[10]")
	@CacheLookup
	private WebElement partiesPlanCityLabel;




	private WebDriver driver;

	public AdjustBatchPageBackup(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginToSite() throws Exception {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	//	WebElement itemType = driver.findElement(By.xpath("xpath"));
		SeleniumUtils.waitAndClickElement(driver, itemTypeDropDown);
		WebElement itemTypeDropDown2 = driver.findElement(By.id("item-type-field"));
		itemTypeDropDown2.click();
		SeleniumUtils.selectAndScroll(driver,selectItemTypeSubTypeScrollBar,adjustItemType);
		//this was working
		//SeleniumUtils.waitAndClickElement(driver, adjustItemType);

		SeleniumUtils.pause(2000);

		SeleniumUtils.waitAndClickElement(driver, subtypeInputtest);
		//SeleniumUtils.selectDropdownOptionAngular(driver,selectItemTypeSubTypeScrollBar,amendTest);
		//SeleniumUtils.sendKeysJs(driver,subtypeInputtest,"test");

		Actions actions = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("(//div[@class='ng-input'])[2]"));
		actions.sendKeys(element, "CONTR").perform();
		actions.moveToElement(element).sendKeys(Keys.ENTER).perform();

		//SeleniumUtils.sendKeysJs(driver,subTypeDropDown, "CONTR");
		//WebElement subTypeDropDown2 = driver.findElement(By.id("subtype-field"));
		//subTypeDropDown2.click();
		//WebElement selectdropdown2 = driver.findElement(By.xpath("//*[@class='ng-dropdown-panel-items scroll-host']"));

		//SeleniumUtils.sendKeysJs(driver,subTypeDropDown,"test");

		//WebElement adjustItemType2 = driver.findElement(By.xpath("//div[@ng-reflect-tooltip='ADJUST - Adjustment']"));
		//adjustItemType2.click();
		SeleniumUtils.waitAndClickElement(driver, nextButton);
		//WebElement nextButton2 = driver.findElement(By.xpath("//button[@ng-reflect-klass='btn btn-primary btn-next btn-c']"));
		//nextButton2.click();
		//SeleniumUtils.waitAndClickElement(driver,productDropDown3);
		//WebElement productDropDown4 = driver.findElement(By.xpath("//ng-select[@class='xtrac-value-group field-control xtrac-field ng-select ng-select-single ng-select-searchable ng-pristine ng-valid ng-select-bottom ng-touched']"));
		//productDropDown4.click();


		SeleniumUtils.waitAndClickElement(driver,planTextBox);
		//WebElement test = driver.findElement(By.xpath("/html/body/span/xwh-bootstrap/xwh-app/div/div/routing-work-item-create/div/xwi-create/form/div[3]/div/xwi-details-container/xwi-details/div/div[2]/div[1]/xwi-fields-sections/xwi-fields-section/div/div/xtrac-fields/div[1]/div[10]/xtrac-field/div/div[2]/xtrac-character-field/input"));
		//test.click();
		SeleniumUtils.sendKeysToWebElement(driver,planTextBox,"");
		SeleniumUtils.waitAndClickElement(driver,customerTextBox);
		SeleniumUtils.sendKeysToWebElement(driver,customerTextBox,"");
		SeleniumUtils.waitAndClickElement(driver,clientTextBox);
		SeleniumUtils.sendKeysToWebElement(driver,clientTextBox,"");

		//this works its opening the productType
		SeleniumUtils.waitAndClickElement(driver,productDropDown5);
		//not needed?
		//WebElement productDropDown6 = driver.findElement(By.xpath("(//div[@class='ng-input'])[5]"));
		//productDropDown6.click();
		//SeleniumUtils.sendKeysToWebElement(driver,productDropDown5,"");
		//SeleniumUtils.waitAndClickElement(driver,selectDCProduct);

		//SeleniumUtils.selectAndScroll(driver,selectProductScrollBar,selectRDProduct);

		// working
		//SeleniumUtils.selectAndScroll(driver,selectProductScrollBar,selectWGProduct);

		SeleniumUtils.selectAndScroll(driver,selectProductScrollBar,selectDCProduct);

		//SeleniumUtils.waitAndClickElement(driver,rButton);


		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		SeleniumUtils.waitAndClickElement(driver,afterPrefillPopUp);


		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		SeleniumUtils.scrollToElement(driver,subTypeLabel);


		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		// Initialize an instance to the TakeScreenshot class
		TakesScreenshot ts = (TakesScreenshot)driver;
		// Capture screenshot as output type FILE
		File file = ts.getScreenshotAs(OutputType.FILE);

		try {
			//save the screenshot taken in destination path

			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
			String formatDateTime = now.format(formatter);
			System.out.println("Current Date and Time with Milliseconds: " + formatDateTime);


			FileUtils.copyFile(file, new File("/Users/a754005/repos/POM-cucumber-selenium-framework/POM-cucumber-selenium-framework/src/test/java/Screenshots/TestRun"+formatDateTime+".-DC-product.png"));
			// Print the title after screenshot capture
			String title = driver.getTitle();
			System.out.println("Captured Screenshot for: " +title);
		} catch (IOException e) {
			// Catch any unexpected errors
			e.printStackTrace();
		}

		//itemTypeDropDown.click();
		//adjustItemType.click();
		//nextButton.click();



		SeleniumUtils.scrollToElement(driver,partiesClientLabel);
		SeleniumUtils.scrollDown(driver);
		SeleniumUtils.waitAndClickElement(driver,partiesClientLabel);
		SeleniumUtils.scrollDown(driver);
		SeleniumUtils.waitAndClickElement(driver,partiesPlanLabel);
		SeleniumUtils.scrollDown(driver);
		SeleniumUtils.scrollToElement(driver,partiesPlanCityLabel);

		//SeleniumUtils.waitAndClickElement(driver,productDropDown10);
		//WebElement productDropDown11 = driver.findElement(By.xpath("//label[contains(text(), 'Product')]"));
		//productDropDown11.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}



		// Initialize an instance to the TakeScreenshot class
		TakesScreenshot ts2 = (TakesScreenshot)driver;
		// Capture screenshot as output type FILE
		File file2 = ts2.getScreenshotAs(OutputType.FILE);

		try {
			//save the screenshot taken in destination path

			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
			String formatDateTime = now.format(formatter);
			System.out.println("Current Date and Time with Milliseconds: " + formatDateTime);


			FileUtils.copyFile(file2, new File("/Users/a754005/repos/POM-cucumber-selenium-framework/POM-cucumber-selenium-framework/src/test/java/Screenshots/TestRun"+formatDateTime+".-DC-product.png"));
			// Print the title after screenshot capture
			String title = driver.getTitle();
			System.out.println("Captured Screenshot for: " +title);
		} catch (IOException e) {
			// Catch any unexpected errors
			e.printStackTrace();
		}

		//itemTypeDropDown.click();
		//adjustItemType.click();
		//nextButton.click();
	}

	public Boolean verifyOnLoginPage() {
		///SeleniumUtils.wait(driver, onlyOneSmallBag);
		//SeleniumUtils.waitAndClickElement(driver, selectPriorityBagsContinueButton);
		return itemTypeDropDown.isDisplayed();
	}
}

package pages;

import helper.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseDriverClass;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FuelReturnCheckerPage extends BaseDriverClass {


	@FindBy(id = "fuelOnReturn")
	@CacheLookup
	private WebElement fuelOnReturnfield;

	@FindBy(id = "fuelPrice")
	@CacheLookup
	private WebElement fuelPricefield;

	@FindBy(xpath = "//button[contains(text(), 'Calculate')]")
	@CacheLookup
	private WebElement calculateButton;


	private WebDriver driver;

	public FuelReturnCheckerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterFuelOnReturnValue(String fuelOnReturnValue) throws Exception {

		SeleniumUtils.waitAndClickElement(driver, fuelOnReturnfield);
		SeleniumUtils.sendKeysToWebElement(driver, fuelOnReturnfield, fuelOnReturnValue);

	}

	public void enterFuelPricePerLitreValue(String fuelPricePerLitreValue) throws Exception {
		SeleniumUtils.waitAndClickElement(driver, fuelPricefield);
		SeleniumUtils.sendKeysToWebElement(driver, fuelPricefield, fuelPricePerLitreValue);
	}

	public void clickCalculateButton() throws IOException, InterruptedException {
		SeleniumUtils.waitAndClickElement(driver, calculateButton);
	}

	public void assertEstimatedFuelCostValue(String estimateFuelCost) {
        WebElement fuelCostElement = driver.findElement(By.xpath("//p[contains(text(), 'Estimated Fuel Cost:')]"));
        // Get the text content
        String text = fuelCostElement.getText(); // Example: "Estimated Fuel Cost: -3.90 units"

        // Use regex to extract the numeric value
        Pattern pattern = Pattern.compile("(-?\\d+\\.\\d+)"); // Matches positive/negative decimal numbers
        Matcher matcher = pattern.matcher(text);

        String actualfuelCost = null;
        if (matcher.find()) {
            actualfuelCost = matcher.group(1);
            System.out.println("Extracted Fuel Cost: " + actualfuelCost);
        } else {
            System.out.println("Fuel cost value not found!");
        }
        String actualTitle = driver.getTitle();
        assertThat("Actual Fuel Cost and Estimated Fuel Cost do not match", actualfuelCost, is(estimateFuelCost));
        //assertTrue("Login button is not displayed!", loginButton.isDisplayed());
    }
}

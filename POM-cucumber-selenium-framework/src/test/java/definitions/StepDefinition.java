package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.FuelReturnCheckerPage;
import pages.HomePageBackupPage;
import pages.LoginPage;

public class StepDefinition {
	private WebDriver driver;
	private WebDriverWait wait;
	private LoginPage loginPage;
	private HomePageBackupPage homePage;
	private FuelReturnCheckerPage fuelReturnCheckerPage;

	public StepDefinition() throws Exception {
		driver = Hooks.driver;
		wait = new WebDriverWait(driver, 5);
		loginPage = new LoginPage(driver);
		homePage = new HomePageBackupPage(driver);
		fuelReturnCheckerPage = new FuelReturnCheckerPage(driver);
	}

	@Given("^User logins into the system$")
	public void loginPage() throws Exception {
		loginPage.loginToSite();
	}

	@When("User Enters {string} into the Fuel on return field")
	public void userEntersIntoTheFuelOnReturnField(String FuelOnReturnValue) throws Exception {
		fuelReturnCheckerPage.enterFuelOnReturnValue(FuelOnReturnValue);

	}

	@And("User Enters {string} into the Fuel Price per Litre field")
	public void userEntersIntoTheFuelPricePerLitreField(String FuelPricePerLitreValue) throws Exception {
		fuelReturnCheckerPage.enterFuelPricePerLitreValue(FuelPricePerLitreValue);
	}

	@And("User clicks the calculate button")
	public void userClicksTheCalculateButton() throws Exception {
		fuelReturnCheckerPage.clickCalculateButton();
	}

	@Then("Assert that is Estimated Fuel Cost is {string}")
	public void assertThatIsEstimatedFuelCostIs(String estimateFuelCost) {
		fuelReturnCheckerPage.assertEstimatedFuelCostValue(estimateFuelCost);
	}
}

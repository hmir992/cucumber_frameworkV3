package definitions;

/*
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;

public class RButtonPage {
	private WebDriver driver;
	private WebDriverWait wait;
	private LoginPage loginPage;
	private HomePage homePage;

	public RButtonPage() throws Exception {
		driver = Hooks.driver;
		wait = new WebDriverWait(driver, 5);
		loginPage = new LoginPage(driver, wait);
		homePage = new HomePage(driver, wait);
	}

	@Given("^User is on a page$")
	public void loginPage() {
		Assert.assertTrue(loginPage.verifyOnLoginPage());
	}

	@When("^User submit a and password$")
	public void submitEmailPassword() {
		loginPage.loginToSite("standard_user", "secret_sauce");
	}

	@Then("^User should be a to login sucessfully and new page open$")
	public void successLogin() {
		Assert.assertTrue(homePage.verifyOnHomePage());
	}
}

*/

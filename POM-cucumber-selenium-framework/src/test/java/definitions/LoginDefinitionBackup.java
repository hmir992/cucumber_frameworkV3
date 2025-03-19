package definitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.HomePageBackupPage;

public class LoginDefinitionBackup {
	private WebDriver driver;
	private WebDriverWait wait;
	private LoginPage adjustRButtonPage;
	private HomePageBackupPage homePage;

	public LoginDefinitionBackup() throws Exception {
		driver = Hooks.driver;
		wait = new WebDriverWait(driver, 5);
		adjustRButtonPage = new LoginPage(driver);
		homePage = new HomePageBackupPage(driver);
	}

	@Given("^User is on login page$")
	public void loginPage() throws Exception {
		adjustRButtonPage.loginToSite();
		//Assert.assertTrue(loginPage.verifyOnLoginPage());
	}

//	@When("^User submit email and password$")
	//public void submitEmailPassword() {
	//	loginPage.loginToSite("standard_user", "secret_sauce");
	//}

//	@Then("^User should be able to login sucessfully and new page open$")
	//public void successLogin() {
	//	Assert.assertTrue(homePage.verifyOnHomePage());
	//}
//}
}
